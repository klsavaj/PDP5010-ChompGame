package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.ChompGame;

import java.awt.Color;
/**
 * Listener for handling button clicks on the chocolate grid.
 * Communicates with the game logic to update the state and refresh the display.
 * <p>
 * Deviation Note:
 * - A reference to the button itself was included in the constructor to enable direct color updates.
 *   This avoids unnecessary UI component lookups and improves performance.
 */
public class ButtonClickListener implements ActionListener {
    private final int row;  // Row index of the button
    private final int col;  // Column index of the button
    private final ChompGame game;  // Game instance for handling moves
    private final ChocolateBarPanel chocolateBarPanel;  // Panel for updating the chocolate grid
    private final ChompGameGUI gui;  // GUI instance for refreshing the display
    private final JButton button;  // Reference to the clicked button

    /**
     * Constructs a ButtonClickListener for a specific square in the chocolate grid.
     *
     * @param row                the row index of the square
     * @param col                the column index of the square
     * @param game               the game instance
     * @param chocolateBarPanel  the panel managing the chocolate grid
     * @param gui                the GUI instance
     * @param button             the button associated with this listener
     */
    public ButtonClickListener(int row, int col, ChompGame game, ChocolateBarPanel chocolateBarPanel, ChompGameGUI gui, JButton button) {
        this.row = row;
        this.col = col;
        this.game = game;
        this.chocolateBarPanel = chocolateBarPanel;
        this.gui = gui;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.handleMove(row, col)) {
            button.setBackground(Color.DARK_GRAY);  // Mark the clicked square as eaten
            chocolateBarPanel.eatSquares(row, col);  // Update the chocolate grid
            gui.updateDisplay();  // Refresh the display

            if (game.isGameOver()) {
                JOptionPane.showMessageDialog(null, "Game Over! Winner: " + game.getCurrentPlayer().getName());
            }
        }
    }
}