package Boticario.Test.BelezaNaWeb.services


import Boticario.Test.BelezaNaWeb.model.ProductModel
import org.springframework.stereotype.Service

@Service
class ProductsServices {
    val products = mutableListOf<ProductModel>()

    fun getAllProducts(): List<ProductModel> {
        return products
    }
    fun getProductsBySku(sku:Long): ProductModel{
       return products.filter { it.sku == sku }.first()
    }

    fun verifyQuantity (product:ProductModel){
        val totalQuantity = product.inventory.warehouses.map { it.quantity }.sum()
        if(totalQuantity > 0) {
            product.inventory.quantity = totalQuantity
            product.isMarketable = true
        }else {
            product.isMarketable = false
        }
    }

    fun createProductServices(product: ProductModel) {
        verifyQuantity(product)
        products.add(product)
    }

    fun putProductBySku( product: ProductModel){
        products.filter { it.sku == product.sku }.first().let {
            it.name = product.name
            it.inventory = product.inventory
            verifyQuantity(it)
        }
    }

    fun deleteProductsBySku(sku:Long){
        products.removeIf { it.sku == sku }
    }

}

