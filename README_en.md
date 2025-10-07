# ♟️ Java Chess Game

-----

### [🇬🇧/🇺🇸 English Version](https://github.com/xopxee/Chess-Game/blob/main/README_en.md)

-----

This is a project for a classic chess game developed in Java. The goal is to create a functional chess engine with all the standard rules, initially operating via console and, in the future, with a graphical interface.

> **Attention:** This project is currently in the development phase. Some features are being built, and the current version does not yet represent the complete game.

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

The project is in the final stages of development. It is fully operational in the terminal, and only the implementation of the graphical interface is missing for it to be complete.

## ✨ Current Features

* **Board Structure:** Complete representation of an 8x8 chessboard.
* **Object-Oriented Design:** Each piece (Pawn, Rook, Knight, Bishop, Queen, King) is modeled as a distinct class, inheriting from a base class `Piece`, which promotes code reuse and maintainability.
* **Complete Movement:** Movement and capture logic for all pieces, according to their fundamental rules.
* * **Complex Rules:** The game features advanced rules such as en passant, castling, check, and pinned pieces.
* **Win or Draw Conditions:** Checkmate, Stalemate, Loss by resignation.
* **Console Interface:** Displays the current board state on the terminal to view the game.

## 🗺️ Roadmap and Next Steps

The list below details the critical features planned for future releases.

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
│ │ └── Rook.java
│ └── Main.java
├── .gitignore
├── ChessGame.iml
├── LICENSE
├── README.md
└── README_en.md
```

### [📂Diagram UML](https://lucid.app/lucidchart/95e617d8-9ed0-4962-9897-b22b88b38569/edit?beaconFlowId=1853CEFB36C7CF9A&invitationId=inv_1e47aab7-1f42-41f4-a381-2b2e6b5ff430&page=HWEp-vi-RSFO#)

## 📄 License

This project is licensed under the [MIT License](https://en.wikipedia.org/wiki/MIT_License). See the file for more details.

-----
