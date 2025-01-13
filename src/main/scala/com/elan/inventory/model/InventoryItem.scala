package com.elan.inventory.model

import spray.json.{RootJsonFormat, DefaultJsonProtocol}

final case class InventoryItem(id: Int, name: String, quantity: Int, price: Double)

object JsonFormats {
  import DefaultJsonProtocol._
  implicit val inventoryItemFormat: RootJsonFormat[InventoryItem] = jsonFormat4(InventoryItem)
}
