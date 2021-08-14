fun main() {
    val productType = readLine()!!
    val price = readLine()!!.toInt()
    val product = Product.create(productType, price)
    println(totalPrice(product))
}

fun totalPrice(product: Product): Int {
    return product.totalPrice.toInt()
}

open class Product(val price: Int, val tax: Int) {
    val totalPrice = price + price.toDouble() * tax / 100
    companion object {
        fun create(productType: String, price: Int): Product {
            return when (productType) {
                "headphones" -> Headphone(price)
                "smartphone" -> Smartphone(price)
                "tv" -> Tv(price)
                "laptop" -> Laptop(price)
                else -> Product(price, 0)
            }
        }
    }
}

class Headphone(price: Int): Product(price, 11)
class Smartphone(price: Int): Product(price, 15)
class Tv(price: Int): Product(price, 17)
class Laptop(price: Int): Product(price, 19)