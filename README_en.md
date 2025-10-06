# ♟️ Java Chess Game

-----

### [Portuguese Version 🇵🇹/🇧🇷](https://github.com/xopxee/Chess-Game/blob/main/README.md)

-----

This is a classic chess game project developed in Java. The goal is to create a functional chess engine with all the standard rules, initially operating via console and, in the future, with a graphical interface.

> **Please note:** This project is currently in the development phase. Some features are being built, and the current version does not yet represent the complete game.

-----

## 📜 Summary

* Project Status
* Current Features
* Roadmap and Next Steps
* Technologies Used
* How to Run the Project
* Project Structure
* License

-----

## 🚧 Project Status

The project is in the final stages of development. It is fully operational in the terminal, and only the pinned piece mechanic and the graphical interface remain to be programmed. However, it is playable as long as a pinned piece does not move, leaving its king in check.

## ✨ Current Features

* **Board Structure:** Complete representation of an 8x8 chessboard.
* **Object-Oriented Design:** Each piece (Pawn, Rook, Knight, Bishop, Queen, King) is modeled as a distinct class, inheriting from a base `Piece` class, which promotes code reuse and maintainability.
* **Basic Movement:** Implementation of movement and capture logic for all pieces, according to their fundamental rules.
* **Console Interface:** Display of the current board state in the terminal for game preview.

## 🗺️ Roadmap and Next Steps

The list below details the critical features planned for future releases.

- [ ] **Check Rules:** Program movement restrictions for pinned pieces, meaning they cannot move because they would leave your king in check.
- [ ] **Graphical User Interface (GUI):** Develop a visually interactive user interface using the JavaFX library to replace the current console view.

## 🛠️ Technologies Used

Language: Java

Platform: JDK (Java Development Kit) 11 or higher

UI Framework (Planned): JavaFX

## 🚀 How to Run the Project

To compile and run this project locally, follow the steps below.

### Prerequisites

Before you begin, make sure you have the **Java Development Kit (JDK)** (version 11 or higher) installed on your machine.

### Steps to Execution

1. **Clone the repository:**

    ```bash
    git clone https://github.com/xopxee/Chess-Game.git
    ```

2. **Navigate to the project directory:**

    ```bash
    cd Chess-Game
    ```

3. **Compile the `.java` files from the project root:**
   The command below will compile all necessary classes, respecting the package structure.

    ```bash
    javac src/**/*.java
    ```

4. **Run the application:**
   After successful compilation, run the main class to start the game in the console.

    ```bash
    java src/Main
    ```

## 📂 Project Structure

The source code is organized to separate responsibilities, making it easier to understand and maintain.

```
Chess-Game/
├── .idea/
├── src/
│ ├── Board/
│ │ ├── House.java
│ │ └── Board.java
│ ├── Pieces/
│ │ ├── Bishop.java
│ │ ├── Knight.java
│ │ ├── Pawn.java
│ │ ├── Piece.java
│ │ ├── Queen.java
│ │ ├── King.java
│ │ └── Tower.java
│ └── Main.java
├── .gitignore
├── LICENSE
├── ChessGame.iml
└── README.md
```

## 📄 License

This project is licensed under the [MIT License](https://en.wikipedia.org/wiki/MIT_License). See the file for more details.

-----