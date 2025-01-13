package com.elan.inventory.route

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._
import com.elan.inventory.mock.MockData
import com.elan.inventory.model.InventoryItem

import scala.concurrent.ExecutionContext
import com.elan.inventory.model.JsonFormats._

class InventoryRoutes()(implicit ec: ExecutionContext) {
  val routes: Route = pathPrefix("inventory") {
    concat(
      pathEnd {
        concat(
          get {
            complete(MockData.inventory.find(_.id == 1))
          },
          post {
            entity(as[InventoryItem]) { item =>
              MockData.addItem(item)
              complete(StatusCodes.Created)
            }
          }
        )
      },
      path(IntNumber) { id =>
        concat(
          get {
            rejectEmptyResponse {
              complete(MockData.inventory.find(_.id == id))
            }
          },
          put {
            entity(as[InventoryItem]) { item =>
              MockData.updateItem(id, item)
              complete(StatusCodes.OK)
            }
          },
          delete {
            MockData.deleteItem(id)
            complete(StatusCodes.OK)
          }
        )
      }
    )
  }
}
