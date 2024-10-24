/**
 * ------------------------------------------------------------------------
 * PROJECT: Two-player game programming Task
 * Level 2 programming project
 *
 * by
 *
 * This project is a two-player game where the aim is to win by being the player who removes the gold coin.
 * A number of coins are placed at random positions on a one-dimensional, square grid.
 * One of the coins is a gold coin.
 * ------------------------------------------------------------------------
 */

// Global variables
var player1: String = ""
var player2: String = ""
var currentPlayer: Int = 1
var gameState: MutableMap<String, Int> = mutableMapOf()

fun main() {
    val coin = mutableListOf<String>()
    // Initialize the game board with coins
    coin.add("")
    coin.add("\uD83D\uDFE1") // Gold coin
    coin.add("\uD83E\uDE99") // Other coin
    coin.add("\uD83D\uDFE1") // Gold coin
    coin.add("")
    coin.add("")
    coin.add("\uD83D\uDFE1") // Gold coin
    coin.add("")
    coin.add("")
    coin.add("\uD83D\uDFE1") // Gold coin

    // Setup players and game
    setupGame()
    while (true) {
        showGameState(coin)
        if (getPlayerMove(coin)) break // Check if the game is over after the move
    }
}

// Function to setup the game
fun setupGame() {
    println("Enter Player 1 name:")
    player1 = readLine() ?: "Player 1"
    println("Enter Player 2 name:")
    player2 = readLine() ?: "Player 2"
}

// Function to show the current game state
fun showGameState(coin: MutableList<String>) {
    println("Current Game State:")
    showPetsAsHorizontalTable(coin)
}

// Function to get the player's move
fun getPlayerMove(coin: MutableList<String>): Boolean {
    val currentPlayerName = if (currentPlayer == 1) player1 else player2
    println("$currentPlayerName, enter the position (0-${coin.size - 1}) to remove a coin:")

    val position = readLine()?.toIntOrNull()
    if (position != null && position in coin.indices) {
        if (coin[position] == "\uD83D\uDFE1") { // Check if the selected coin is the gold coin
            println("$currentPlayerName has removed the gold coin! $currentPlayerName wins!")
            return true // Game over
        } else {
            println("$currentPlayerName removed a regular coin.")
            coin[position] = "" // Remove the coin
        }
    } else {
        println("Invalid position. Please try again.")
    }

    // Switch to the next player
    currentPlayer = if (currentPlayer == 1) 2 else 1
    return false // Game continues
}

// Function to display the game board
fun showPetsAsHorizontalTable(petList: MutableList<String>) {
    // Build the top
    print("+----------".repeat(petList.size))
    println("+")

    // Show the pets
    for (pet in petList) {
        print("| %-8s ".format(pet))
    }
    println("|")

    // Build the bottom
    print("+----------".repeat(petList.size))
    println("+")
}
