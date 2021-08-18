package Boticario.Test.BelezaNaWeb.repository

import Boticario.Test.BelezaNaWeb.model.ProductModel
import org.springframework.stereotype.Repository

@Repository
class ProductRepository {
    val products = mutableListOf<ProductModel>()

    fun findAll(): List<ProductModel>{
        return products
    }

    fun findBySku(sku: Long): ProductModel? {
        return products.find { it.sku == sku }
    }

    fun save(product: ProductModel): ProductModel{
        products.add(product)
        return product
    }

    fun delete(product:ProductModel){
        products.removeIf { it.sku == product.sku }
    }
}