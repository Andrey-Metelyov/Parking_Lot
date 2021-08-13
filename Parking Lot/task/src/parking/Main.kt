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
//            else -> println("ERROR")
        }
    } while (command != "exit")
    System.err.println("exited")
}
