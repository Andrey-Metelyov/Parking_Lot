package parking

fun main() {
    val parking = Parking()
//    parking.park()
    do {
        val response = readLine()!!.split(" ")
        val command = response[0]
        when (command) {
            "park" -> parking.park(Car(response[1], response[2]))
            "leave" -> parking.leave(response[1].toInt())
            "create" -> parking.create(response[1].toInt())
            "status" -> parking.status()
            "reg_by_color" -> parking.regByColor(response[1])
            "spot_by_color" -> parking.spotByColor(response[1])
            "spot_by_reg" -> parking.spotByReg(response[1])
//            else -> println("ERROR")
        }
    } while (command != "exit")
    System.err.println("exited")
}
