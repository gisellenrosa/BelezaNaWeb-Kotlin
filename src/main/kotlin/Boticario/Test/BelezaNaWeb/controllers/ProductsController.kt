package Boticario.Test.BelezaNaWeb.controllers

import Boticario.Test.BelezaNaWeb.controllers.requests.ProductRequest
import Boticario.Test.BelezaNaWeb.extension.toProductModel
import Boticario.Test.BelezaNaWeb.extension.toProductModelMethodPut
import Boticario.Test.BelezaNaWeb.model.ProductModel
import Boticario.Test.BelezaNaWeb.services.ProductsServices
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")

class ProductsController(val productsServices: ProductsServices) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody body: ProductRequest) {
        productsServices.createProductServices(body.toProductModel())
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getAllProducts(): List<ProductModel> {
       return productsServices.getAllProducts()
    }

    @GetMapping("/{sku}")
    fun getProductsBySku(@PathVariable sku:Long): ProductModel {
        return productsServices.getProductsBySku(sku)
    }

    @PutMapping("/{sku}")
    fun putProductBySku(@PathVariable sku: Long, @RequestBody body: ProductRequest){
        productsServices.putProductBySku(body.toProductModelMethodPut(sku))
    }

    @DeleteMapping("/{sku}")
    fun deleteProductBySky(@PathVariable sku:Long){
        productsServices.deleteProductsBySku(sku)
    }

}