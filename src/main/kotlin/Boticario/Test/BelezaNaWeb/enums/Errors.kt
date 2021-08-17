package Boticario.Test.BelezaNaWeb.enums

enum class Errors( val message: String ) {
    BLZ001( "Sku [%s] already exists"),
    BLZ002( "Sku not found, the value of sku[%s] doesn't exists")
}