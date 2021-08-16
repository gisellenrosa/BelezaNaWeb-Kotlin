package Boticario.Test.BelezaNaWeb.extension

import Boticario.Test.BelezaNaWeb.controllers.requests.InventoryRequest
import Boticario.Test.BelezaNaWeb.controllers.requests.ProductRequest
import Boticario.Test.BelezaNaWeb.controllers.requests.WarehouseRequest
import Boticario.Test.BelezaNaWeb.model.InventoryModel
import Boticario.Test.BelezaNaWeb.model.ProductModel
import Boticario.Test.BelezaNaWeb.model.WarehouseModel

fun ProductRequest.ToProductModel(): ProductModel {
    return  ProductModel(sku= this.sku, name= this.name, inventory = this.inventory.toInventoryModel())
}
fun ProductRequest.ToProductModelMethodPut(sku: Long): ProductModel {
    return  ProductModel(sku= sku, name= this.name, inventory = this.inventory.toInventoryModel())
}

fun InventoryRequest.toInventoryModel(): InventoryModel{
    return InventoryModel(warehouses = this.warehouses.map { it.toWarehouseModel()})
}
fun WarehouseRequest.toWarehouseModel(): WarehouseModel{
    return WarehouseModel(locality, quantity, type )
}


