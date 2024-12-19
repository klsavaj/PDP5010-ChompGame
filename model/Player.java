package model;

/**
 * Represents a player in the Chomp game.
 * Each player has a name and an active status to indicate whose turn it is.
 */
public class Player {
    private String name;
    private boolean isActive;

    /**
     * Constructs a new player with the specified name.
     * The player is initially inactive.
     *
     * @param name the name of the player
     */
    public Player(String name) {
        this.name = name;
        this.isActive = false; // Default: player is inactive
    }

    /**
     * Sets the active status of the player.
     *
     * @param active {@code true} if the player is active, {@code false} otherwise
     */
    public void setActive(boolean active) {
        this.isActive = active;
    }

    /**
     * Checks if the player is currently active.
     *
     * @return {@code true} if the player is active, {@code false} otherwise
     */
    public boolean isActive() {
        return isActive;
    }

    /**
     * Gets the name of the player.
     *
     * @return the name of the player
     */
    public String getName() {
        return name;
    }
}
