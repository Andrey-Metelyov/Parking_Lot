package parking

class Parking {
    private var spots: Array<Car?>? = null
    private var occupied = 0

    fun create(size: Int) {
        spots = Array(size) { null }
//        val s = if (spots!!.size > 1) "s" else ""
        occupied = 0
        println("Created a parking lot with $size spots.")
    }

    fun park(car: Car) {
        if (spots == null) {
            println("Sorry, a parking lot has not been created.")
            return
        }
        val freeSpot = spots!!.indexOf(null)
        if (freeSpot != -1) {
            spots!![freeSpot] = car
            occupied++
            println("${car.color} car parked in spot ${freeSpot + 1}.")
        } else {
            println("Sorry, the parking lot is full.")
        }
    }

    fun leave(spot: Int) {
        if (spots == null) {
            println("Sorry, a parking lot has not been created.")
            return
        }
        if (spots!![spot - 1] != null) {
            spots!![spot - 1] = null
            occupied--
            println("Spot $spot is free.")
            return
        }
        println("There is no car in spot $spot.")
    }

    fun status() {
        if (spots == null) {
            println("Sorry, a parking lot has not been created.")
            return
        }
        if (occupied == 0) {
            println("Parking lot is empty.")
            return
        }
        for ((i, spot) in spots!!.withIndex()) {
            if (spot != null) {
                println("${i + 1} ${spot.id} ${spot.color}")
            }
        }
    }

}
