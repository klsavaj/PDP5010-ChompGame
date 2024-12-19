package model;

/**
 * Represents a chocolate bar for the Chomp game.
 * The bar is modeled as a grid where each square is either "uneaten" or
 * "eaten."
 * Provides functionality to manipulate and query the state of the chocolate
 * bar.
 */
public class ChocolateBar {
    private boolean[][] grid;
    private final int rows;
    private final int columns;

    /**
     * Constructs a ChocolateBar with the specified number of rows and columns.
     * Initializes all squares as uneaten.
     *
     * @param rows    the number of rows in the chocolate bar
     * @param columns the number of columns in the chocolate bar
     */
    public ChocolateBar(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new boolean[rows][columns];
        reset();
    }

    /**
     * Marks all squares to the right and above the specified square as eaten.
     *
     * @param row the row of the square selected
     * @param col the column of the square selected
     */
    public void markSquaresAsEaten(int row, int col) {
        for (int r = row; r >= 0; r--) {
            for (int c = col; c < columns; c++) {
                grid[r][c] = false;
            }
        }
    }

    /**
     * Checks whether the specified square is uneaten.
     *
     * @param row the row of the square to check
     * @param col the column of the square to check
     * @return true if the square is uneaten, false otherwise
     */
    public boolean isSquareUneaten(int row, int col) {
        return grid[row][col];
    }

    /**
     * Resets the chocolate bar, marking all squares as uneaten.
     */
    public void reset() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = true;
            }
        }
    }

    /**
     * Returns the grid representing the chocolate bar's current state.
     *
     * @return a 2D boolean array where true indicates uneaten squares
     */
    public boolean[][] getGrid() {
        return grid;
    }

    /**
     * Returns the number of rows in the chocolate bar.
     * This method was added to provide controlled access to the number of rows,
     * which is needed for tasks such as rendering the grid, validating input,
     * or adapting the game UI dynamically.
     * 
     * @return the number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Returns the number of columns in the chocolate bar.
     * This method was added for the same reasons as `getRows()`, to provide
     * controlled access to the number of columns for tasks like rendering
     * and validation.
     * 
     * @return the number of columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * Added Method: Checks if only the poison square (bottom-left corner) remains
     * uneaten.
     * Added this method to simplify the game's win condition logic.
     * While not specified, it ensures better separation of concerns between game
     * logic and the model.
     * 
     * @return true if only the poison square is left uneaten, false otherwise
     */
    public boolean isOnlyPoisonSquareLeft() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] && !(i == rows - 1 && j == 0)) {
                    return false;
                }
            }
        }
        return true;
    }
}
