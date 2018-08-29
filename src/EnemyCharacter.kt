data class EnemyCharacter(var name: String,
                          val experienceToGive: Int = (Math.random() * 100).toInt(),
                          val goldToGive: Int = (Math.random() * 80).toInt()) : Character(attack = 5, healPoints = 40, maxHealPoints = 40) {
    override fun toString(): String {
        return super.toString() + "name='$name', experience to give=$experienceToGive, gold to give=$goldToGive"
    }
}