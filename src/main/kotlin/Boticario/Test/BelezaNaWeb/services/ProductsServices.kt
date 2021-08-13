package Boticario.Test.BelezaNaWeb.services

import Boticario.Test.BelezaNaWeb.model.ProductModel
import org.springframework.stereotype.Service

@Service
class ProductsServices {
    val products = mutableListOf<ProductModel>()

    fun CreateProductServices(product: ProductModel) {
        products.add(product)
    }

}