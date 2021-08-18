package Boticario.Test.BelezaNaWeb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
class BelezaNaWebApplication

fun main(args: Array<String>) {
	runApplication<BelezaNaWebApplication>(*args)
}
