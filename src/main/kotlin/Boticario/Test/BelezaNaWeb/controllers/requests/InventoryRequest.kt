package Boticario.Test.BelezaNaWeb.controllers.requests

import Boticario.Test.BelezaNaWeb.model.WarehouseModel

data class InventoryRequest(
    val warehouseRequest: List<WarehouseRequest>
)
