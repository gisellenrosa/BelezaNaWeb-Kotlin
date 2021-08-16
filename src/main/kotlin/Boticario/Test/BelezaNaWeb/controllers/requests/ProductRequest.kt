package Boticario.Test.BelezaNaWeb.controllers.requests

import Boticario.Test.BelezaNaWeb.model.InventoryModel

data class ProductRequest(
    val sku: Long,
    val name: String,
    val inventory: InventoryRequest
)
