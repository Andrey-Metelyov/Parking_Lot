fun main() {
    val rooms = readLine()!!.toInt()
    val price = readLine()!!.toInt()
    val house = House(rooms, price)
    println(totalPrice(house))
}

fun totalPrice(house: House): Int {
    return house.totalPrice.toInt()
}

class House(val rooms: Int, val price: Int) {
    enum class HouseType(val coef: Double) {
        Cabin(1.0),
        Bungalow(1.2),
        Cottage(1.25),
        Mansion(1.4),
        Palace(1.6)
    }
    val totalPrice: Double
    val type: HouseType
    init {
        type = when {
            rooms <= 1 -> HouseType.Cabin
            rooms in 2..3 -> HouseType.Bungalow
            rooms == 4 -> HouseType.Cottage
            rooms in 5..6 -> HouseType.Mansion
            else -> HouseType.Palace
        }
        totalPrice = type.coef * (if (price < 0) 0 else if (price > 1_000_000) 1_000_000 else price)
    }
}