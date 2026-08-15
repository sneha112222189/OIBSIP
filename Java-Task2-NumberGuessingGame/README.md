# Number Guessing Game

A console-based Java game where the system generates a random number and the player tries to guess it, receiving "Too High!" OR "Too Low!" hints until they get it right or run out of attempts.

## Objective

Build a console game where the computer picks a random number and the user guesses it, with real-time feedback, an attempt limit, replayability, and score tracking across rounds.

## Tech Stack

- Java 
- Core concepts used: 'java.util.Random', 'Scanner', 'while' loops, 'if-else'

## Features

- Random number generated fresh at the start of every round
- User guesses via console input, with input validation
- Feedback after every guess: 'Too High!', 'Too Low!', or 'Correct!'
- Live attempt counter shown before each guess
- Maximum attempt limit — game ends with 'You Lost!' and reveals the number
  if the limit is reached
- "Play again?" (yes/no) prompt after every round
- Score tracking across rounds — final scoreboard summary:
  'Round X — guessed in Y attempts'

## How to Run

javac NumberGuessingGame.java
java NumberGuessingGame

## How to Play

1. Enter a guess when prompted.
2. Read the hint ('Too High!' / 'Too Low!') and guess again.
3. Keep going until you guess correctly or run out of attempts.
4. Choose whether to play another round — a full scoreboard prints at the end.

## Project Structure

NumberGuessingGame.java   # Complete game logic (single file)
README.md                 # This file
screenshots/              # Sample gameplay output (add your own screenshots here)

## Sample Output
```
=====================================
 WELCOME TO THE NUMBER GUESSING GAME
=====================================

----- Round 1 -----

I'm thinking of a number between 1 and 100.
You have 7 attempts. Good luck!

Attempt 1/7 — Enter your guess: 50
Too Low!
Attempts remaining: 6
Attempt 2/7 — Enter your guess: 75
Correct! 🎉 You guessed it in 2 attempt(s).

Summary: Round 1 — guessed in 2 attempts

Play again? (yes/no): no

========== FINAL SCOREBOARD ==========
Round 1 — guessed in 2 attempts
=======================================

Thanks for playing! Goodbye.
```

## Author

Built as part of the Oasis Infobyte Summer Internship Program (OIBSIP).
