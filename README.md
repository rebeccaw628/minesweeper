# Minesweeper

## Description

A command-line implementation of the classic Minesweeper game built in Java.

## Table of Contents

- [Screenshots](#screenshots)
- [Goals](#goals)
- [Implementation](#implementation)
  - [MVP](#mvp)
  - [Plan](#plan)
  - [Challenges](#challenges)
  - [Learnings](#learnings)

## Screenshots

- to add after any code changes

## Goals

- Design a Minesweeper game in Java using OOP principles
- Break program into logical components, each represented by a class

## Implementation

### MVP

- Recreate a simplified version of the game Minesweeper to be played in the java console
- The game should be able to randomly generate 10 mines in a 10x10 grid
- The user will be able to enter a command that represents a coordinate to check a location for a mine
- The application will display a number from 0-8 depending on how many mines surround that location
- If the user selects a mine, the game will respond "boom!" and the game will be lost
- If every non-mine square has been revealed, the game is won
- Render the grid to the console after every user command

### Bonuses (optional)

- Allow for the user to configure number of mines and grid size via a configuration.
- (Difficult) Discovering an empty square should reveal all squares around it, and cascade into other nearby empty squares

### Plan

Classes Overview:

- Board: 2D array of cells, 10 x 10 with 10 mines
- Cell: A single cell in the game board with 3 attributes -> isMine (boolean), isRevealed (boolean), adjacentMines (an integer which counts number of neighbouring mines)
- InputHandler: Validates user input -> check whether input is a number between 1-10, give meaningful feedback for invalid user input

### Challenges

- Determining logic to count the number of adjacent mines for a cell -> created table to help:
  | [i-1][j-1] | [i-1][j] | [i-1][j+1] |
  | [i][j-1] | reference cell: [i][j] | [i][j+1] |
  | [i+1][j-1] | [i+1][j] | [i+1][j+1] |
- Determining logic to reveal neighbouring cells if an empty cell is revealed -> Researched about Java Recursion

### Learnings

- The difference between `break` and `continue` in Java
- Java recursion
