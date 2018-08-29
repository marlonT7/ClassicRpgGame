open class Character(var attack: Int = 20, var healPoints: Int = 80, var maxHealPoints: Int = 80) {

  //Adds between 0 and 5 to the max heal points and attack
  fun levelUp2() {
    maxHealPoints += increaseStatus()
    attack += increaseStatus()
  }

  //Generates a random number between 0 and 5
  private fun increaseStatus(): Int {
    return (Math.random() * 5).toInt()
  }

  //Decreases the character's heal points in enemy attack points
  fun takeDamage(enemy: Character) {
    this.healPoints -= enemy.attack
    println("has taken ${enemy.attack} damage points")
  }

  fun isAlive(): Boolean {
    return healPoints > 0
  }

  override fun toString(): String {
    return "Character(healPoints=$healPoints, maxHealPoints=$maxHealPoints, attack=$attack)"
  }
  //Copies a Character object to this object
  fun copy(attack: Int, healPoints: Int, maxHealPoints: Int) {
    this.attack = attack
    this.healPoints = healPoints
    this.maxHealPoints = maxHealPoints
  }
}
