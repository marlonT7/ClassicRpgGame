data class MainCharacter(private var level: Int = 0,
                         private var experience: Int = 0,
                         private var experienceToNextLevel: Int = 100,
                         var myStorage: MutableList<Item> = arrayListOf(),
                         private var gold: Int = 0) : Character() {

    // Calls level up method from the super class, adds 1 to the level,
    // set the experience 0 and increase the experience to the next level in 10%
    private fun levelUp(experience: Int) {
        super.levelUp2()
        this.level++
        this.experience = experience
        this.experienceToNextLevel = (this.experienceToNextLevel * 1.1).toInt()
    }

    fun isPlaying(): Boolean {
        return this.isAlive() && this.level < 5
    }

    // Adds the item's heal point restore to the character's heal points,
    // if the heal points reaches the maximum limit, then the heal points
    // set equal to max heal points
    // remove the item from my storage item list
    private fun applyItem(item: Item) {
        super.healPoints += super.healPoints + item.healPointRestore
        if (super.healPoints > super.maxHealPoints) {
            super.healPoints = super.maxHealPoints
        }
        this.myStorage.remove(item)
    }

    // Adds the gained experience to the character's experience
    // if the character's experience reaches the experience to the next level
    // then calls the level up method with the difference of the experience
    // and the experience to the next level as arg
    fun gainExperience(experience: Int) {
        this.experience += experience
        if (this.experience > this.experienceToNextLevel) {
            this.levelUp(experience = (this.experience - this.experienceToNextLevel))
        }
    }

    fun gainGold(gold: Int) {
        this.gold += gold
    }

    // If the character's gold reaches the item's price,
    // adds item to my storage item list
    fun buyItem(item: Item) {
        if (item.price > this.gold) {
            println("You don't have enough gold")
        } else {
            this.myStorage.add(item)
            this.gold - item.price
            println(item.name + " has been added to my storage")
        }
    }

    override fun toString(): String {
        return super.toString() + "level=$level, experience=$experience, experience to next level=$experienceToNextLevel, gold=$gold"
    }

    fun useItem() {
        var selectedItem: Int
        //Show my storage item list as a menu
        println("Do you want use an item?")
        this.myStorage.forEach { item ->
            println(this.myStorage.indexOf(item).toString() + " " + item.name + " " + item.healPointRestore.toString())
        }

        //Validate selected item
        if (this.myStorage.isEmpty()) {
            println("You don't have items")
        } else {
            do {
                println("Select an item in your storage")
                selectedItem = readLine()?.toInt() ?: -1
            } while (selectedItem > this.myStorage.size - 1 || selectedItem < 0)
            //uses the item
            this.applyItem(this.myStorage[selectedItem])
        }
    }


}