open class Character {
  var healPoints = 80
  var maxHealPoints = 80
  var attack = 20

  //Adds between 0 and 5 to the max heal points and attack
  fun levelUp2() {
    maxHealPoints += increaseStatus()
    attack += increaseStatus()
  }

  //Generates a random number between 0 and 5
  private fun increaseStatus(): Int {
    return (Math.random() * 5).toInt()
  }

  //Reduces the heal points,
  fun takeDamage(enemy: Character) {
    this.healPoints -= enemy.attack
  }

  fun isAlive(): Boolean {
    return healPoints > 0
  }

  override fun toString(): String {
    return "Character(healPoints=$healPoints, maxHealPoints=$maxHealPoints, attack=$attack)"
  }
}
