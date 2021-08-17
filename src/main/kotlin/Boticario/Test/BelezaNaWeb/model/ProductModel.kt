package Boticario.Test.BelezaNaWeb.model

data class ProductModel(
    val sku: Long,
    var name: String,
    var inventory:InventoryModel,
    var isMarketable: Boolean? = false
)
