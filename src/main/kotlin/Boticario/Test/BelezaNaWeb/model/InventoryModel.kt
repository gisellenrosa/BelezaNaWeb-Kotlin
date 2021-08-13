package Boticario.Test.BelezaNaWeb.model

data class InventoryModel(
    var quantity: Int? = null,
    val warehouses: List<WarehouseModel>
)
