package Boticario.Test.BelezaNaWeb.model

data class ProductModel(
    val sku: Long,
    val name: String,
    val inventory:InventoryModel,
    val isMarketable: Boolean? = null
)
