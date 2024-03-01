package graph

class MealyMachine {

    private enum class State {
        CITY, PARKING, TRASSA, BRAKE, AVOID, FINDFUEL
    }

    private var currentState: State = State.CITY
    private val transitionMatrix = arrayOf(
            intArrayOf(0, 1, 2, 3, 4, 5),
            intArrayOf(0, 1, 2, 3, 4, 5),
            intArrayOf(0, 1, 2, 3, 4, 5),
            intArrayOf(0, 1, 2, 3, 4, 5),
            intArrayOf(0, 1, 2, 3, 4, 5),
    )

    fun processInput(speed: Int, distance: Int, fuel: Int, mode: String): String {
        currentState = State.values()[transitionMatrix[currentState.ordinal][calculateCategory(speed, distance, fuel, mode)]]


        return when (currentState) {
            State.PARKING -> "Парковка"
            State.CITY -> "Городской режим"
            State.TRASSA -> "Трасса"
            State.BRAKE -> "Торможение"
            State.AVOID -> "Избегание столкновений"
            State.FINDFUEL -> "Поиск АЗС"
        }
    }

    fun category(mode: String): Int {
        return when {
            mode == State.PARKING.name -> 0
            mode == State.CITY.name -> 1
            mode == State.TRASSA.name -> 2
            else -> 1

        }
    }

    fun Input(mode: String): String {
        currentState = State.values()[transitionMatrix[currentState.ordinal][category(mode)]]
        return when (currentState) {
            State.PARKING -> "Парковка"
            State.CITY -> "Городской режим"
            State.TRASSA -> "Трасса"
            State.BRAKE -> "Торможение"
            State.AVOID -> "Избегание столкновений"
            State.FINDFUEL -> "Поиск АЗС"
        }
    }

    fun calculateCategory(speed: Int, distance: Int, fuel: Int, mode: String): Int {
        return when {
            distance < 5 -> 4
            speed < 80 && distance < 10 -> 3
            fuel < 5 -> 5
            else -> 2
        }
    }
}

fun main() {
    val mealyMachine = MealyMachine()
    val result = mealyMachine.processInput(2, 16, 35, "Городской режим")
    val results = mealyMachine.Input("Парковка")
    println("Выход: $result\n")
    println("Выход: $results\n")

}
