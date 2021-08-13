package Boticario.Test.BelezaNaWeb.controllers.requests

import Boticario.Test.BelezaNaWeb.enums.WarehouseTypeEnum

data class WarehouseRequest(
    val locality: String,
    val quantity: Int,
    val type: WarehouseTypeEnum
)
