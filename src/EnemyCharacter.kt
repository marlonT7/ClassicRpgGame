class EnemyCharacter(var name: String): Character(5,40,40) {
  private var experienceToGive = (Math.random() * 100).toInt()
  private var goldToGive = (Math.random() * 80).toInt()


  fun getGold(): Int{
    return goldToGive
  }
  fun getExperience(): Int{
    return experienceToGive
  }

  override fun toString(): String {
    return super.toString()+"EnemyCharacter(name='$name', experienceToGive=$experienceToGive, goldToGive=$goldToGive)"
  }
  //Copies an EnemyCharacter object to this object
  fun copy(enemy: EnemyCharacter) {
    super.copy(enemy.attack, enemy.healPoints,enemy.maxHealPoints)
    this.name=enemy.name
    this.experienceToGive=enemy.experienceToGive
    this.goldToGive=enemy.goldToGive
  }
}