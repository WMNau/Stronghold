package nau.mike


object Dialog {

    fun intro() {
        for (i in 0 until 100) {
            println()
        }

        println("  In the distant future, a team of treasure hunters discovers an old, seemingly abandoned fortress")
        println("fabled to contain the treasures of a long lost civilization. When they arrive, they realize the")
        println("fortress has been magically sealed and fortified with defenses. The walls seem to repair themselves")
        println("and a large turret overlooks the front gate. After losing several cargo vessels to the turret when")
        println("trying to fly over the walls, the team comes up with a plan to deploy an army of mechanized units")
        println("along with a single siege unit (code-named Catapult) to take down the front wall and consequently")
        println("knock down the turret. Reluctant to proceed until a sound strategy is in place, the team has")
        println("contracted you to build a simulated environment where they can input various battle parameters")
        println("and determine the expected outcome.")
    }

    fun inputIntro() {
        println("- One or more battles will be submitted as input")
        println("- Each battle will be represented by a comma-delimited line")
        println("- All input arguments will be integers")
        println("- Inputs will be listed in the order that they are described below :")
        println()
        println("\t- Wall Defense")
        println("\t\t- Total amount of damage the wall can take before falling")
        println("\t- Army Size")
        println("\t\t- Number of units")
        println("\t- Unit Strength")
        println("\t\t- Damage each unit will contribute against the wall")
        println("\t- Turret Strength")
        println("\t\t- Number of army units removed when the turret fires")
        println("\t- Offense Tokens *")
        println("\t\t- Each offense token prevents the walls from repairing once and is consumed afterward")
        println("\t- Defense Tokens *")
        println("\t\t- Each defense token prevents the turret from firing at the army once and is consumed afterward")
        println()
        println(" * There can only be a total of 4 tokens between offense/defense. For example, you can have 2 offense")
        println("and 2 defense or 4 offense and 0 defense.  If the combined input quantities exceed a total of 4")
        println("tokens they will each default to 2.")
        println()
        print("Enter your game input: ")
    }
}
