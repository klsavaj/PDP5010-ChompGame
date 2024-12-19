package gui;

import javax.swing.*;

import controller.ChompGame;

import java.awt.*;

/**
 * Panel for displaying the chocolate bar grid in the Chomp Game.
 * Manages the visual representation of the chocolate grid and interactions
 * Deviation Note:
 * - `paintComponent(Graphics g)` was not implemented since using buttons for
 * the grid provides
 * better interactivity (e.g., hover effects, click detection) compared to
 * manually drawing squares.
 * - A `squareSize` attribute was omitted to align with the grid layout's
 * natural resizing capability in Swing.
 */
public class ChocolateBarPanel extends JPanel {
    private ChompGame game; // Reference to the game logic
    private ChompGameGUI gui; // Reference to the main GUI

    /**
     * Constructs the ChocolateBarPanel with the specified game instance and GUI
     * reference.
     * Initializes the grid display based on the game's current state.
     *
     * @param game the game instance managing the state
     * @param gui  the main GUI instance
     */
    public ChocolateBarPanel(ChompGame game, ChompGameGUI gui) {
        this.game = game;
        this.gui = gui;
        setLayout(new GridLayout(game.getChocolateBar().getRows(), game.getChocolateBar().getColumns()));
        initializeGrid();
    }

    /**
     * Initializes the grid by creating buttons for each square and attaching action
     * listeners.
     * <p>
     * Deviation Note:
     * - Buttons were used instead of a custom `paintComponent` to simplify
     * interactivity
     * and leverage existing Swing features like borders and background color
     * changes.
     */
    private void initializeGrid() {
        boolean[][] grid = game.getChocolateBar().getGrid();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                JButton squareButton = new JButton();
                squareButton.setOpaque(true);
                squareButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                if (row == grid.length - 1 && col == 0) {
                    squareButton.setBackground(Color.BLACK); // Poison square
                } else {
                    squareButton.setBackground(Color.YELLOW); // Uneaten square
                }

                squareButton.addActionListener(new ButtonClickListener(row, col, game, this, gui, squareButton));
                add(squareButton);
            }
        }
    }

    /**
     * Marks all squares to the right and above the selected square as eaten.
     *
     * @param row the row index of the selected square
     * @param col the column index of the selected square
     */
    public void eatSquares(int row, int col) {
        for (int r = 0; r <= row; r++) {
            for (int c = col; c < game.getChocolateBar().getColumns(); c++) {
                JButton button = (JButton) getComponent(r * game.getChocolateBar().getColumns() + c);
                button.setBackground(Color.DARK_GRAY); // Mark as eaten
            }
        }
        repaint(); // Refresh the display
    }

    /**
     * Resets the chocolate grid to its initial uneaten state.
     * This method calls the {@link ChompGame#initializeGame()} method to reset the
     * game state and then updates the grid's visual
     * representation. All squares are reset to their uneaten state (yellow), and
     * the poison square is set back to black.
     * It finishes by calling {@link #repaint()} to visually update the grid.
     * The inclusion of this method ensures that the user interface accurately
     * reflects the reset game state, allowing the game
     * to be properly restarted.
     */
    public void resetGrid() {
        game.initializeGame();
        for (int i = 0; i < getComponentCount(); i++) {
            JButton button = (JButton) getComponent(i);
            button.setBackground(Color.YELLOW); // Reset all squares to yellow
        }
        JButton poisonButton = (JButton) getComponent(
                game.getChocolateBar().getRows() * game.getChocolateBar().getColumns()
                        - game.getChocolateBar().getColumns());
        poisonButton.setBackground(Color.BLACK); // Reset poison square
        repaint(); // Repaint to reflect changes
    }
}
