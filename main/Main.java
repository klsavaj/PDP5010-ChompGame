package main;

import gui.WelcomeScreen;

/**
 * Main class to launch the Chomp Game application.
 * Initializes the GUI by displaying the WelcomeScreen, which allows the user to input
 * the dimensions of the chocolate bar and start the game.
 */
public class Main {

    /**
     * The entry point of the application.
     * Purpose: Initializes the GUI and starts the game by displaying the welcome screen.
     *
     * @param args command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        new WelcomeScreen(); // Launch the welcome screen for user input
    }
}
