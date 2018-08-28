class MainCharacter() : Character() {
  var level = 0
  var experience = 0
  var experienceToNextLevel = 100
  var myStorage: MutableList<Item> = arrayListOf()
  var gold = 0

  //Calls level up method from the super class, adds 1 to the level,
  //set the experience 0 and increase the experience to the next level in 10%
  fun levelUp(experience: Int) {
    super.levelUp2()
    this.level++
    this.experience += experience
    this.experienceToNextLevel = (this.experienceToNextLevel * 1.1).toInt()
  }

  //Adds the item's heal point restore to the character's heal points,
  //if the heal points reaches the maximum limit, then the heal points
  // set equal to max heal points
  // remove the item from my storage item list
  fun useItem(item: Item) {
    super.healPoints += super.healPoints + item.healPointRestore
    if (super.healPoints > super.maxHealPoints) {
      super.healPoints = super.maxHealPoints
    }
    this.myStorage.remove(item)
  }

  //Adds the gained experience to the character's experience
  //if the character's experience reaches the experience to the next level
  //then calls the level up method with the difference of the experience
  //and the experience to the next level as arg
  fun gainExperience(experience: Int) {
    this.experience += experience
    if (this.experience > this.experienceToNextLevel) {
      this.levelUp(this.experience - this.experienceToNextLevel)
    }
  }

  fun gainGold(gold: Int) {
    this.gold += gold
  }

  //If the character's gold reaches the item's price,
  //adds item to my storage item list
  fun buyItem(item: Item) {
    if (item.price > this.gold) {
      println("You don't have enough gold")
    } else {
      this.myStorage.add(item)
      this.gold - item.price
      println(item.name + "has been added to my storage")
    }
  }

  override fun toString(): String {
    return super.toString() + "MainCharacter(level=$level, experience=$experience, experienceToNextLevel=$experienceToNextLevel, myStorage=$myStorage, gold=$gold)"
  }
}