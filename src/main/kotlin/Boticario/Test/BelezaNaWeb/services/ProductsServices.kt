package Boticario.Test.BelezaNaWeb.services


import Boticario.Test.BelezaNaWeb.enums.Errors
import Boticario.Test.BelezaNaWeb.extension.ForbiddenException
import Boticario.Test.BelezaNaWeb.extension.NotFoundException
import Boticario.Test.BelezaNaWeb.model.ProductModel
import Boticario.Test.BelezaNaWeb.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductsServices(val productRepository: ProductRepository) {

    fun getAllProducts(): List<ProductModel> {
        return productRepository.findAll()
    }

    fun getProductsBySku(sku:Long): ProductModel{
        productRepository.findBySku(sku).let{
             if(it == null){
                 throw NotFoundException(Errors.BLZ002.message.format(sku))
             } else {
                 return it
             }
         }
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
        productRepository.findAll().find { it.sku == product.sku}.let{
           if (it != null) {
               throw ForbiddenException(Errors.BLZ001.message.format(it.sku))
           }
       }
        verifyQuantity(product)
        productRepository.save(product)
    }

    fun putProductBySku( product: ProductModel){
        productRepository.findAll().find { it.sku == product.sku }.let {
            if(it == null){
                throw NotFoundException(Errors.BLZ002.message.format(product.sku))
            } else {
                it.name = product.name
                it.inventory = product.inventory
                verifyQuantity(it)
            }
        }
    }

    fun deleteProductsBySku(sku:Long){
        productRepository.findBySku(sku).let {
            if(it == null){
                throw NotFoundException(Errors.BLZ002.message.format(sku))
            } else {
                productRepository.delete(it)
            }
        }
    }

}

