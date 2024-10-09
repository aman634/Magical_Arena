# Magical Arena

Magical Arena is a simple implementation of a combat system where players fight against each other until one's health reaches zero. The game simulates turns of attack and defense between two players, where each player has attributes such as health, strength, and attack.

## Problem Statement

Design a Magical Arena where players fight against each other. Each player has attributes such as health, strength, and attack, and they take turns attacking and defending. The game ends when one player's health reaches zero.

## Technologies Used

The solution is implemented using Java.

## Running the Code

1.Compile the code using the following command:
    
    javac -d out src/main/java/org/arenaGame/*.java

2.Run the code using the following command:

    java -cp out org.arenaGame.MainClass

3.Run the tests using the following command:
    
    mvn test


## Project Structure

The project structure is organized as follows:

- `src/main/java/org/arenaGame/`: Contains the main source code files.
    - `Player.java`: Represents a player in the Magical Arena.
    - `Arena.java`: Represents the arena where players fight.
    - `Main.java`: Main entry point of the program.
- `src/test/java/`: Contains the test source code files.
    - `PlayerTest.java`: Test cases for the `Player` class.
    - `ArenaTest.java`: Test cases for the `Arena` class.

## Evaluation Criteria

The project is evaluated based on the following criteria:

- Simple design and readability of the code.
- Adequate documentation (Javadoc comments).
- Unit test coverage and effectiveness.
- Correct implementation of game logic.

