package Boticario.Test.BelezaNaWeb.controllers

import Boticario.Test.BelezaNaWeb.controllers.requests.ProductRequest
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductsController {
    @PostMapping("Products")
    @ResponseStatus(HttpStatus.CREATED)
    fun CreateANewProduct(@RequestBody body: ProductRequest) {

    }

}