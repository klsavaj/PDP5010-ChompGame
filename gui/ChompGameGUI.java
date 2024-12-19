package gui;

import javax.swing.*;

import controller.ChompGame;

import java.awt.*;

/**
 * GUI representation of the Chomp Game. Manages the game state and player
 * interactions through a graphical interface.
 * Deviation Note:
 * - The `game` attribute is directly instantiated in this class instead of
 * being passed as a parameter,
 * simplifying initialization and ensuring independence from external game
 * instances.
 * - The `setupGUI` method initializes components and adds listeners in one step
 * to ensure consistency
 * across different GUI parts and reduce repetitive code.
 */
public class ChompGameGUI extends JFrame {
    private ChompGame game; // Manages the game state and player turns
    private ChocolateBarPanel chocolateBarPanel; // Custom panel for displaying the chocolate grid
    private JLabel statusLabel; // Label for showing the current player's turn

    /**
     * Constructs the ChompGameGUI with the specified grid dimensions.
     *
     * @param rows    the number of rows in the chocolate grid
     * @param columns the number of columns in the chocolate grid
     */
    public ChompGameGUI(int rows, int columns) {
        game = new ChompGame(rows, columns); // Directly instantiate the game object
        setupGUI(rows, columns);
    }

    /**
     * Sets up the GUI components, including the chocolate grid panel and status
     * label.
     * Also adds listeners for user interactions such as restarting the game.
     */
    private void setupGUI(int rows, int columns) {
        setTitle("Chomp Game");
        setLayout(new BorderLayout());

        // Status label at the top
        statusLabel = new JLabel("Player 1's Turn", SwingConstants.CENTER);
        add(statusLabel, BorderLayout.NORTH);

        // Chocolate grid panel
        chocolateBarPanel = new ChocolateBarPanel(game, this);
        add(chocolateBarPanel, BorderLayout.CENTER);

        // Restart button at the bottom
        JButton restartButton = new JButton("Restart Game");
        restartButton.addActionListener(e -> restartGame());
        add(restartButton, BorderLayout.SOUTH);

        // Final JFrame settings
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /**
     * Updates the display, including the status label and chocolate grid.
     * <p>
     * Deviation Note:
     * - Instead of directly calling `paintComponent`, this method calls `repaint`
     * on the grid panel,
     * which is the preferred approach in Swing to ensure consistency and avoid UI
     * bugs.
     */
    public void updateDisplay() {
        String currentPlayer = game.getCurrentPlayer().getName();
        statusLabel.setText(currentPlayer + "'s Turn");
        chocolateBarPanel.repaint(); // Refresh the grid
    }

    /**
     * Resets the game and updates the display to start a new session.
     * This method calls the {@link ChocolateBarPanel#resetGrid()} method to reset
     * the game board to its initial state. It also
     * updates the status label to indicate that it's Player 1's turn, signaling the
     * start of a new game.
     * This approach ensures that both the game state and the user interface are
     * correctly reset, offering the user a fresh start
     * when they choose to restart the game.
     */
    private void restartGame() {
        chocolateBarPanel.resetGrid();
        statusLabel.setText("Player 1's Turn");
    }
}
