package Boticario.Test.BelezaNaWeb.model

data class ProductModel(
    val sku: Long,
    val name: String,
    val inventoryModel:InventoryModel,
    val isMarketable: Boolean?
)
