package Boticario.Test.BelezaNaWeb.model

import Boticario.Test.BelezaNaWeb.enums.WarehouseTypeEnum

data class WarehouseModel(
    val locality: String,
    val quantity: Int,
    val type: WarehouseTypeEnum
)
