package Boticario.Test.BelezaNaWeb.controllers

import Boticario.Test.BelezaNaWeb.controllers.requests.ProductRequest
import Boticario.Test.BelezaNaWeb.extension.ToProductModel
import Boticario.Test.BelezaNaWeb.services.ProductsServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class ProductsController(val productsServices: ProductsServices) {

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    fun CreateProduct(@RequestBody body: ProductRequest) {
        productsServices.CreateProductServices(body.ToProductModel())
    }

}