package Boticario.Test.BelezaNaWeb.model

data class InventoryModel(
    var quantity: Int? = 0,
    val warehouses: List<WarehouseModel>
)
