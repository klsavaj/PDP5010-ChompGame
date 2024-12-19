/**
 * Why this class?
 * Answer:
 * The WelcomeScreen class represents the initial screen of the Chomp game.
 * It allows the user to dynamically input the dimensions (rows and columns) 
 * for the chocolate bar grid, providing a simple and interactive setup before
 * starting the game.

 * This class enhances the user experience by:
 * 1. Allowing users to customize the game board dimensions.
 * 2. Providing clear error messages if invalid input is entered, ensuring the user can easily correct mistakes.
 * 3. Dynamically launching the game with the specified dimensions after input validation.

 * By implementing this class, the user is able to personalize the game setup, making the experience more engaging and interactive.
 */

package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents the welcome screen for the Chomp game.
 * Allows the user to input the dimensions of the chocolate bar (rows and columns).
 */
public class WelcomeScreen extends JFrame {
    private JTextField rowsField; // Text field for entering the number of rows
    private JTextField columnsField; // Text field for entering the number of columns
    private JLabel errorLabel; // Label to display error messages

    /**
     * Constructs a WelcomeScreen for the Chomp game.
     * Initializes the GUI components and sets up input validation.
     */
    public WelcomeScreen() {
        setTitle("Chomp Game - Enter Dimensions");
        setSize(300, 200);
        setLayout(new GridLayout(4, 1));

        // Instruction label
        JLabel instructionLabel = new JLabel("Enter Board Dimensions (m x n):", SwingConstants.CENTER);
        add(instructionLabel);

        // Input panel for rows and columns
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1, 4));

        rowsField = new JTextField();
        columnsField = new JTextField();
        inputPanel.add(new JLabel("Rows: "));
        inputPanel.add(rowsField);
        inputPanel.add(new JLabel("Columns: "));
        inputPanel.add(columnsField);

        add(inputPanel);

        // Start button
        JButton startButton = new JButton("Start Game");
        add(startButton);

        // Error label
        errorLabel = new JLabel("", SwingConstants.CENTER);
        errorLabel.setForeground(Color.RED);
        add(errorLabel);

        // Add ActionListener to the Start button
        startButton.addActionListener(new ActionListener() {
            /**
             * Handles the action performed when the Start Game button is clicked.
             * Validates the input and starts the game if valid dimensions are provided.
             *
             * @param e the action event triggered by the Start button
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int rows = Integer.parseInt(rowsField.getText().trim());
                    int columns = Integer.parseInt(columnsField.getText().trim());

                    if (rows <= 0 || columns <= 0) {
                        errorLabel.setText("Rows and columns must be positive integers.");
                        return;
                    }

                    dispose(); // Close the welcome screen and start the game
                    new ChompGameGUI(rows, columns);
                } catch (NumberFormatException ex) {
                    errorLabel.setText("Invalid input. Please enter integers.");
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
