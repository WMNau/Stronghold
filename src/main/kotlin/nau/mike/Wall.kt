package nau.mike

class Wall(defense: Int, var turretStrength: Int) {

    var defense: Int = defense
        get() {
            return if (field <= 0) 0 else field
        }
        private set

    fun gotHit(hp: Int) {
        defense -= hp
    }

    fun powerUp() {
        turretStrength *= 2
    }

    fun repair(hp: Int) {
        defense += hp
    }
}
