# 50Stronghold

In the distant future, a team of treasure hunters discovers an old, seemingly abandoned fortress fabled to contain the treasures of a long lost civilization. When they arrive, they realize the fortress has been magically sealed and fortified with defenses.   The walls seem to repair themselves and a large turret overlooks the front gate.  After losing several cargo vessels to the turret when trying to fly over the walls, the team comes up with a plan to deploy an army of mechanized units along with a single siege unit (code-named Catapult) to take down the front wall and consequently knock down the turret.   Reluctant to proceed until a sound strategy is in place, the team has contracted you to build a simulated environment where they can input various battle parameters and determine the expected outcome.

## Input

- One or more battles will be submitted as input
- Each battle will be represented by a comma-delimited line
- All input arguments will be integers
- Inputs will be listed in the order that they are described below:

    - Wall Defense
        - Total amount of damage the wall can take before falling
    - Army Size
        - Number of units
    - Unit Strength
        - Damage each unit will contribute against the wall
    - Turret Strength
        - Number of army units removed when the turret fires
    - Offense Tokens *
        - Each offense token prevents the walls from repairing once and is consumed afterward
    - Defense Tokens *
        - Each defense token prevents the turret from firing at the army once and is consumed afterward

*There can only be a total of 4 tokens between offense/defense.   For example, you can have 2 offense and 2 defense or 4 offense and 0 defense.  If the combined input quantities exceed a total of 4 tokens they will each default to 2.

## Output
- For each battle input, the following output is required.  The output result of each battle needs to be followed by a blank line (See Sample Output).
    - Battle (Won/Lost) In X Minutes
    - Wall Defense Remaining: X
    - Army Remaining: X

## Rules
- The battle will be measured in “minutes”, where each minute is simply represented by an integer counter and not a real time minute.
- After 60 minutes, if the wall has not fallen the battle will be lost.
- Every ten minutes, the turret will double its strength and then fire upon the army, removing N number of soldiers from the field where N is the turret strength.
    - The turret will not fire if a defensive token is available
- The army’s catapult fires at the fortress once every ten minutes, inflicting damage to the wall equal to 100 times the strength of a single army unit.
- Every five minutes,  the fortress wall will repair itself for an amount equal to five times the total army strength (Army Size * Unit Strength)
    - The walls will not repair if an offensive token is available
- Once per minute,  the army will attack the walls for damage equal to the total army strength
- Once the fortress wall’s defense reaches zero the battle will be won if there are any units of the army remaining and the time limit is not reached.   
- Battle events take place in the following sequence:
    1. Catapult Fires
    2. Turret Strengthens
    3. Turret Fires
    4. Walls Repair
    5. Army attacks the walls

## Sample Input

50000,200,10,1,2,2

20000,100,20,1,2,2

## Sample Output

Battle Lost In 60 Minutes

Wall Defense Remaining: 19200

Army Remaining: 80

---
Battle Won In 10 Minutes

Wall Defense Remaining: 0

Army Remaining: 100
