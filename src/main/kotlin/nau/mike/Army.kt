package nau.mike

class Army(
    size: Int, private val unitStrength: Int,
    var offenseToken: Int, var defenseToken: Int, private val maxTokens: Int
) {

    var size: Int = size
        get() {
            return if (field <= 0) 0 else field
        }
        private set

    init {
        clampTokens()
    }

    fun gotHit(hp: Int) {
        if (defenseToken <= 0) {
            size -= hp
        } else {
            defenseToken--
        }
    }

    fun hasOffenseToken(): Boolean {
        return if (offenseToken > 0) {
            offenseToken--
            true
        } else {
            false
        }
    }

    fun catapultStrength(): Int {
        return 100 * unitStrength
    }

    fun totalArmyStrength(): Int {
        return size * unitStrength
    }

    fun isDead(): Boolean {
        return size <= 0
    }

    private fun clampTokens() {
        offenseToken = if (offenseToken + defenseToken > maxTokens) 2 else offenseToken
        defenseToken = if (offenseToken + defenseToken > maxTokens) 2 else defenseToken
    }
}
