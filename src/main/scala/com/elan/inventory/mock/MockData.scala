package com.elan.inventory.mock

object MockData {
  
  import com.elan.inventory.model.InventoryItem
  
  var inventory: Seq[InventoryItem] = Seq(
    InventoryItem(1, "Item1", 10, 15.5),
    InventoryItem(2, "Item2", 5, 7.5),
    InventoryItem(3, "Item3", 20, 12.0)
  )

  def addItem(item: InventoryItem): Unit = {
    inventory = inventory :+ item
  }

  def updateItem(id: Int, updatedItem: InventoryItem): Unit = {
    inventory = inventory.map(item => if (item.id == id) updatedItem else item)
  }

  def deleteItem(id: Int): Unit = {
    inventory = inventory.filterNot(_.id == id)
  }
}

