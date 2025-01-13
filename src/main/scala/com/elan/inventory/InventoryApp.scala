package com.elan.inventory

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import akka.stream.Materializer
import com.elan.inventory.route.InventoryRoutes

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

@main def main(): Unit = {

  implicit val system: ActorSystem[_] = ActorSystem(Behaviors.empty, "InventoryApp")
  implicit val materializer: Materializer = Materializer(system)
  implicit val executionContext: ExecutionContextExecutor = system.executionContext

  val inventoryRoutes = new InventoryRoutes()

  val bindingFuture = Http().newServerAt("localhost", 8080).bind(inventoryRoutes.routes)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  StdIn.readLine()
  bindingFuture
    .flatMap(_.unbind())
    .onComplete(_ => system.terminate())
}
