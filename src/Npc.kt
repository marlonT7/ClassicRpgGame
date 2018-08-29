class Npc(    //Creates the NPC items to sell
        private val itemsToSell: ArrayList<Item> = arrayListOf(
                Item(name = "Apple", healPointRestore = 20, price = 5),
                Item(name = "Green potion", healPointRestore = 40, price = 10),
                Item(name = "Yellow potion", healPointRestore = 60, price = 15),
                Item(name = "Red potion", healPointRestore = 80, price = 20))) {


    //Talk whit a NPC
    fun menu(): Item {
        var item = Item(name = "void", healPointRestore = 0, price = 0)
        println("Hello, can I help you?")
        println("1-----------Buy")
        println("2-----------Talk")
        println("Any other---Good bye")
        val menu: String = readLine().toString()
        when (menu) {
            //If select buy Item in the menu, return the selected item
            //else return "void"
            "1" -> item = sellItem()
            "2" -> chat()
            else -> println("Good bye")
        }
        return item
    }

    //Sell an item
    private fun sellItem(): Item {
        var selectedItem: Int
        println("What would you buy?")
        println("Select an item")
        //Displays the items in the NPC storage
        itemsToSell.forEach {
            println(itemsToSell.indexOf(it).toString() + " " + it.name + " Restores: " + it.healPointRestore + " HP Price: " + it.price)
        }
        do {
            println("Item not found")
            println("Please select an item in the inventory")
            selectedItem = try {
                readLine()?.toInt() ?: -1
            } catch (e: NumberFormatException) {
                -1
            }
        } while (selectedItem > itemsToSell.size - 1 || selectedItem < 0)
        return itemsToSell[selectedItem]
    }

    //Chat with the NPC
    private fun chat() {
        println("What you want to know")
        println("1-------------How can I defeat any enemy?")
        println("2-------------When I win?")
        println("Any other-----Good bye")
        val menu: String = readLine().toString()
        //Options menu for chat

        when (menu) {
            "1" -> println("Attack him until his is 0")
            "2" -> println("When you reaches level 5")
            else -> println()
        }
    }
}