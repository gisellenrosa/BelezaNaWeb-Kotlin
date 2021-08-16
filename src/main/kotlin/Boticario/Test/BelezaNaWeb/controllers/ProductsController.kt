package Boticario.Test.BelezaNaWeb.controllers

import Boticario.Test.BelezaNaWeb.controllers.requests.ProductRequest
import Boticario.Test.BelezaNaWeb.extension.ToProductModel
import Boticario.Test.BelezaNaWeb.extension.ToProductModelMethodPut
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
        productsServices.createProductServices(body.ToProductModel())
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
        productsServices.putProductBySku(body.ToProductModelMethodPut(sku))
    }

    @DeleteMapping("/{sku}")
    fun deleteProductBySky(@PathVariable sku:Long){
        productsServices.deleteProductsBySku(sku)
    }

}