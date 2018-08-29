fun main(args: Array<String>) {

  //Creates the NPC's items to sell
  val itemsToSell: ArrayList<Item> = arrayListOf(Item("Apple", 20, 5), Item("Green potion",
      40, 10), Item("Yellow potion", 60, 15), Item("Red potion", 80, 20))
  //Creates enemies list
  val enemies: ArrayList<EnemyCharacter> = arrayListOf(EnemyCharacter("Bat"), EnemyCharacter("Skeleton"), EnemyCharacter("Dragon"),
      EnemyCharacter("Snake"), EnemyCharacter("Ghost"), EnemyCharacter("Mouse"))
  val mainCharacter = MainCharacter()
  var randomNumber: Int
  val enemy = EnemyCharacter("")
  var menu: String
  var selectedItem: Int
  //Begins the game
  do {
    //Fight with 3 enemies
    repeat(3) {
      //Generate a random number between 0 and list size
      randomNumber = ((Math.random() * (enemies.size))).toInt()
      //Copies an enemy from the list to enemy, this the enemy to fight
      enemy.copy(enemies[randomNumber])
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
            mainCharacter.gainGold(enemy.getGold())
            mainCharacter.gainExperience(enemy.getExperience())
          }


        } else if (menu == "2") {


          //Show my storage item list as a menu
          println("Do you want use an item?")
          mainCharacter.myStorage.forEach { item ->
            println(mainCharacter.myStorage.indexOf(item).toString() + " " + item.name + " " + item.healPointRestore.toString())
          }
          //Validate selected item
          if (mainCharacter.myStorage.isEmpty()) {
            println("You don't have items")
          } else {
            do {
              println("Select an item in your storage")
              selectedItem = readLine()?.toInt() ?: -1
            } while (selectedItem > mainCharacter.myStorage.size || selectedItem < 0)
            //uses the item
            mainCharacter.useItem(mainCharacter.myStorage[selectedItem])
          }
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


    //Talk whit a NPC
    println("Hello, can I help you?")
    println("1-----------Buy")
    println("2-----------Talk")
    println("Any other---Good bye")
    menu = readLine().toString()
    when (menu) {
      "1" -> {
        println("What would you buy?")
        itemsToSell.forEach {
          println(itemsToSell.indexOf(it).toString() + " " + it.name + " Restores: " + it.healPointRestore + " HP Price: " + it.price)
        }
        do {
          println("Please select an item in the inventory")
          selectedItem = try {
            readLine()?.toInt() ?: -1
          } catch (e: NumberFormatException) {
            -1
          }

        } while (selectedItem > itemsToSell.size || selectedItem < 0)
        mainCharacter.buyItem(itemsToSell[selectedItem])
      }
      "2" -> {
        //Options menu for chat
        println("What you want to know")
        println("1-------------How can I defeat any enemy?")
        println("2-------------When I win?")
        println("Any other-----Good bye")
        menu = readLine().toString()
        when (menu) {
          "1" -> println("Attack him until his is 0")
          "2" -> println("When you reaches level 5")
          else -> println()
        }
      }
      else -> println("Good bye")
    }

  } while (mainCharacter.isAlive() && mainCharacter.getLevel() < 5)
  //If the main character lives, then he wins
  if (mainCharacter.isAlive()) {
    println("You win")
  } else {
    println("You lose")
  }
}
