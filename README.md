# Chomp Game

This project is a Java-based implementation of the **Chomp Game**, designed using the **Model-View-Controller (MVC)** architecture. The Chomp Game is a strategic two-player game played on a grid, where players take turns selecting a square and "eating" that square and all squares below and to the right. The objective is to avoid being forced to eat the "poisoned" square in the top-left corner.

## Table of Contents

- [Overview](#overview)
- [Main Functionalities](#main-functionalities)
- [Focus on MVC Architecture](#focus-on-mvc-architecture)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Project](#running-the-project)
- [License](#license)

## Overview

The Chomp Game is implemented with Java Swing for its graphical user interface, providing an interactive experience for users. The project emphasizes a modular and maintainable structure by adhering to the **MVC** design pattern.

## Main Functionalities

- **Grid Initialization**: Dynamically create a grid of customizable size.
- **Player Turns**: Allow two players to take turns selecting squares.
- **Game Rules Enforcement**: Automatically update the grid after each move, removing selected squares and enforcing game rules.
- **Winner Determination**: Identify and announce the winner at the end of the game.
- **Replay Option**: Restart the game with a new grid.

## Focus on MVC Architecture

This project adheres to the MVC design pattern, ensuring a clean separation of concerns:

1. **Model**:
   - Represents the game state and enforces game rules.
   - Key file:
     - `ChompModel.java`: Manages the grid state, player turns, and game logic.

2. **View**:
   - Provides the graphical interface for the game.
   - Displays the grid and player actions in an interactive manner.
   - Key file:
     - `ChompView.java`: Renders the grid and updates the display based on user interactions.

3. **Controller**:
   - Handles user input and updates the model and view accordingly.
   - Key file:
     - `ChompController.java`: Processes user actions, such as square selection, and coordinates updates to the model and view.

## Prerequisites

- **Java Development Kit (JDK)**: Version 8 or higher. Download from [Oracle's official website](https://www.oracle.com/java/technologies/javase-downloads.html).
- **Integrated Development Environment (IDE)**: Such as [Eclipse](https://www.eclipse.org/downloads/) or [IntelliJ IDEA](https://www.jetbrains.com/idea/download/).

## Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/klsavaj/PDP5010-ChompGame.git
   cd PDP5010-ChompGame
   ```

2. **Open the Project in Your IDE**:

   - Import the project into your preferred Java IDE.

## Running the Project

1. **Compile and Run**:

   - Locate the `Main.java` file.
   - Compile and execute the `Main.java` file to launch the application.

2. **Gameplay**:

   - Follow the on-screen instructions to play the game.
   - Players take turns selecting squares on the grid.
   - The player forced to select the top-left square loses the game.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.
