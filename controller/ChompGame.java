package controller;

import model.*;

/**
 * Represents the core logic of the Chomp game.
 * Manages the state of the chocolate bar, players, and game status.
 * 
 * Deviations from the requirements:
 * - The `currentPlayerIndex` is used to track the current player's turn.
 *   While the requirement specifies tracking turns, this attribute also facilitates easy player switching.
 * - The `gameState` is more detailed than expected. It tracks not only whether the game is ongoing but also stores the specific winner states.
 *   This was added for more precise game management.
 */
public class ChompGame {
    private ChocolateBar chocolateBar; // The chocolate bar being played on
    private Player[] players; // The players participating in the game
    private int currentPlayerIndex; // Index of the current active player
    private GameState gameState; // Current state of the game (e.g., ongoing, win, etc.)

    /**
     * Constructs a new ChompGame with the specified number of rows and columns for the chocolate bar.
     * Initializes players, the chocolate bar, and the game state.
     *
     * @param rows    the number of rows in the chocolate bar
     * @param columns the number of columns in the chocolate bar
     */
    public ChompGame(int rows, int columns) {
        this.chocolateBar = new ChocolateBar(rows, columns);
        this.players = new Player[] { new Player("Player 1"), new Player("Player 2") };
        this.currentPlayerIndex = 0;
        this.gameState = GameState.ONGOING;
        players[0].setActive(true);  // Player 1 starts as active
        players[1].setActive(false); // Player 2 starts as inactive
    }

    /**
     * Initializes or resets the game to its default state.
     * Resets the chocolate bar and player states, and sets the game state to ongoing.
     */
    public void initializeGame() {
        chocolateBar.reset();
        players[0].setActive(true);
        players[1].setActive(false);
        gameState = GameState.ONGOING;
    }

    /**
     * Handles a move made by the current player at the specified position on the chocolate bar.
     * Updates the game state based on the move.
     *
     * @param row the row of the selected square
     * @param col the column of the selected square
     * @return true if the move is valid and processed; false otherwise
     */
    public boolean handleMove(int row, int col) {
        if (!chocolateBar.isSquareUneaten(row, col)) return false;

        chocolateBar.markSquaresAsEaten(row, col);

        // Check if the game is over
        if (chocolateBar.isOnlyPoisonSquareLeft()) {
            gameState = currentPlayerIndex == 0 ? GameState.PLAYER_2_WIN : GameState.PLAYER_1_WIN;
            return true; // Skip switching players
        }

        if (row == chocolateBar.getRows() - 1 && col == 0) {
            gameState = currentPlayerIndex == 0 ? GameState.PLAYER_2_WIN : GameState.PLAYER_1_WIN;
        } else {
            switchPlayer(); // Ensure this is correctly called
        }
        return true;
    }

    /**
     * Switches the current player to the other player.
     * Updates the active and inactive states for the players.
     */
    public void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % 2;
    }

    /**
     * Checks if the game is over.
     *
     * @return true if the game has ended; false otherwise
     */
    public boolean isGameOver() {
        return gameState != GameState.ONGOING;
    }

    /**
     * Gets the current state of the game.
     *
     * @return the current {@link GameState}
     */
    public GameState getGameState() {
        return gameState;
    }

    /**
     * Gets the current active player.
     *
     * @return the {@link Player} whose turn it is
     */
    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    /**
     * Gets the chocolate bar being used in the game.
     *
     * @return the {@link ChocolateBar} object representing the game board
     */
    public ChocolateBar getChocolateBar() {
        return chocolateBar;
    }
}
