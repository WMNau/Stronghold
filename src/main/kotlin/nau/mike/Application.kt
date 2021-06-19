package nau.mike

import java.util.*

class Application(private val maxBattleLength: Int = 60, private val maxTokens: Int = 4) {

    private val scanner = Scanner(System.`in`)

    private lateinit var wall: Wall
    private lateinit var army: Army

    private var minutes: Int = 0

    fun render() {
        Dialog.intro()

        do {
            println()
            Dialog.inputIntro()

            var answer = getData("")
            parseData(answer)

            temp()
            outCome(minutes, wall, army)

            answer = getData("Do you want to quit? (y): ")
        } while (answer.uppercase() != "Y")
    }

    private fun temp() {
        for (i in 1..maxBattleLength) {
            minutes = i

            if (minutes % 10 == 0) {
                wall.gotHit(army.catapultStrength())
                wall.powerUp()

                army.gotHit(wall.turretStrength)
            }

            if (minutes % 5 == 0) {
                if (!army.hasOffenseToken()) {
                    wall.repair(5 * army.totalArmyStrength())
                }
            }

            wall.gotHit(army.totalArmyStrength())

            if (wall.defense == 0) {
                break
            }

            if (army.isDead()) {
                break
            }
        }
    }

    private fun parseData(answer: String) {
        val splitStr = answer.split(",")

        wall = Wall(parseData(splitStr, 0), parseData(splitStr, 3))
        army = Army(
            parseData(splitStr, 1), parseData(splitStr, 2),
            parseData(splitStr, 4), parseData(splitStr, 5), maxTokens
        )
    }

    private fun parseData(splitStr: List<String>, index: Int): Int {
        return try {
            splitStr[index].toInt()
        } catch (_: Exception) {
            0
        }
    }

    private fun outCome(minutes: Int, wall: Wall, army: Army) {
        val winLose = if (wall.defense >= 0) "Won" else "Lost"
        val defense = if (wall.defense < 0) 0 else wall.defense
        val armySize = if (army.size < 0) 0 else army.size

        println("Battle $winLose in $minutes Minutes")
        println("Wall Defense Remaining: $defense")
        println("Army Remaining: $armySize")
    }

    private fun getData(message: String): String {
        print(message)
        return scanner.nextLine()
    }
}

fun main() {
    val application = Application()
    application.render()
}
