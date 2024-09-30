# The Battleship Game 🎯

## Overview
This project is a classic implementation of the **Battleship** game in Java. The game allows players to strategically place their ships on a grid and try to sink the opponent’s fleet by guessing the positions of their ships. It features a simple text-based interface, focusing on the core mechanics of the game.

## Features
- **Player vs. Computer**: Battle against a computer-controlled opponent.
- **Ship Placement**: Players can place ships on a 10x10 grid with predefined ship sizes.
- **Turn-based Gameplay**: Players take turns guessing the position of the opponent's ships.
- **Game Logic**: Comprehensive logic for managing turns, validating moves, and handling ship hits and misses.
- **Win/Loss Conditions**: The game ends when all ships of one player have been sunk.

## Project Structure
- **Main.java**: Entry point of the game, initializing the game and starting the game loop.
- **Game.java**: Contains the core game logic, including validation of moves, hit detection, turn management, and win/loss conditions.
- **GameController.java**: Manages the flow of the game by coordinating user input and invoking game logic from `Game.java`.

## How to Play
1. **Clone the repository**:
   ```bash
   git clone https://github.com/kawsar96/The-Battleship-Game
   
2. **Compile and run the game**:   
Open the project in Eclipse or any Java IDE, or use the terminal:
   ```bash
   javac Main.java
   java Main

3. **Follow the prompts** to place your ships and take turns attacking the opponent's grid.
   
## Technologies Used

- **Java**: Core programming language for the game.
- **Eclipse IDE**: Used for development.
- **Git**: Version control.

## Authors

- Kawsar Ahmed
- Ishmam Raiyan Rouf
