/**
 * ------------------------------------------------------------------------
 * PROJECT: Two-player game programing Task
 * Level 2 programming project
 *
 * by Phanumat Piasupan
 *
 * This project is a two player game where the aim is to win by being the player who removes the gold coin.
 * A number of coins are placed at random positions on a one-dimensional, square grid.
 * One of the coins is a gold coin.
 * ------------------------------------------------------------------------
 */


/**
 * Program entry point
 */

fun main() {
    val coin = mutableListOf<String>()
    val nums = mutableListOf<String>()
    val player = mutableListOf<String>()
    coin.add("")
    coin.add("")
    coin.add("\uD83E\uDE99")
    coin.add("\uD83D\uDFE1")
    coin.add("")
    coin.add("")
    coin.add("\uD83D\uDFE1")
    coin.add("")
    coin.add("")
    coin.add("\uD83D\uDFE1")

    player.add("player 1")
    player.add("player 2")

    SetupGame(coin)
    showGameState(coin)
    getPlayerMove(coin)

    showPetsAsHorizontalTable(coin)
}



fun SetupGame(coin: MutableList<String>) {


}
fun showGameState(coin: MutableList<String>) {

}
fun getPlayerMove(coin: MutableList<String>) {

}

// very basic horizontal output

//A vertical table of our pets

fun showPetsAsHorizontalTable(petList:MutableList<String>) {
    //build the top
    print("+----------".repeat(petList.size))
    println("+")

    //show the pets
    for (pet in petList) {
        print("| %-8s ".format(pet) )
    }
    println("|")
    //build the bottom
    print("+----------".repeat(petList.size))
    println("+")
}
