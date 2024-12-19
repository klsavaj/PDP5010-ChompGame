package model;

/**
 * Represents the possible states of the Chomp game.
 * Used to track the progress and outcome of the game.
 * Deviation Note:
 * `GAME_OVER` was removed to avoid redundancy and ambiguity, as 
 * specific win states (`PLAYER_1_WIN`, `PLAYER_2_WIN`) inherently 
 * indicate the game is over, simplifying the game logic.
 */
public enum GameState {
    /**
     * The game is currently ongoing, and no player has won yet.
     */
    ONGOING,

    /**
     * Player 1 has won the game.
     */
    PLAYER_1_WIN,

    /**
     * Player 2 has won the game.
     */
    PLAYER_2_WIN
}
