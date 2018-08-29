fun main(args: Array<String>) {
    //Creates enemies list
    val enemies: ArrayList<EnemyCharacter> = arrayListOf(
            EnemyCharacter(name = "Bat"),
            EnemyCharacter(name = "Skeleton"),
            EnemyCharacter(name = "Dragon"),
            EnemyCharacter(name = "Snake"),
            EnemyCharacter(name = "Ghost"),
            EnemyCharacter(name = "Mouse"))
    val mainCharacter = MainCharacter()
    var randomNumber: Int
    var enemy: EnemyCharacter
    var menu: String
    val npc = Npc()
    var itemToBuy: Item
    //Begins the game
    do {
        //Fight with 3 enemies
        repeat(3) {
            //Generate a random number between 0 and list size
            randomNumber = ((Math.random() * (enemies.size))).toInt()
            //Copies an enemy from the list to enemy, this the enemy to fight
            enemy = enemies[randomNumber].copy()

            //Fight
            while (mainCharacter.isAlive() && enemy.isAlive()) {
                println("\nYour stats")
                println(mainCharacter.toString())
                println("\n${enemy.name} stats")
                println(enemy.toString())

                //Battle menu
                println("\nWhat do you want to do")
                println("1----Attack")
                println("2----Use an item")
                menu = readLine().toString()
                //Select an option
                if (menu == "1") {
                    //Randomly select the first character attacking
                    //If the attacked character is alive, this responds by attacking
                    //If the enemy dies, gives experience and gold
                    if (Math.random() > 0.5f) {
                        //The main character attacks first
                        print(enemy.name + " ")
                        enemy.takeDamage(mainCharacter)
                        if (enemy.isAlive()) {
                            print("\nYou ")
                            mainCharacter.takeDamage(enemy)
                        }
                    } else {
                        //The enemy attacks first
                        print("\nYou ")
                        mainCharacter.takeDamage(enemy)
                        if (mainCharacter.isAlive()) {
                            print(enemy.name + " ")
                            enemy.takeDamage(mainCharacter)
                        }
                    }
                    //If the enemy dies, gives experience and gold
                    if (!enemy.isAlive()) {
                        println("The enemy, has died")
                        mainCharacter.gainGold(enemy.goldToGive)
                        mainCharacter.gainExperience(enemy.experienceToGive)
                    }

                } else if (menu == "2") {
                    //Use an item
                    mainCharacter.useItem()
                    //The enemy attacks you
                    print("You ")
                    mainCharacter.takeDamage(enemy)
                } else {
                    println("Invalid option")
                }
            }
        }

        println("Your stats")
        println(mainCharacter.toString())

        //Shows the NPC menu, if buy an item,
        // return the item and calls main characters buy item function
        if (mainCharacter.isPlaying()) {
            itemToBuy = npc.menu()
            //If item not is "void", then buys an item
            if (itemToBuy.name != "void") {
                mainCharacter.buyItem(itemToBuy)
            }
        }

    } while (mainCharacter.isPlaying())
    //If the main character lives, then he wins
    if (mainCharacter.isAlive()) {
        println("You win")
    } else {
        println("You lose")
    }
}