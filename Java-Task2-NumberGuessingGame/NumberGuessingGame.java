import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int MAX_ATTEMPTS = 7;

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    // Keeps track of each completed round's summary
    private static final List<String> scoreBoard = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println(" WELCOME TO THE NUMBER GUESSING GAME ");
        System.out.println("=====================================");

        int round = 1;
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Round " + round);
            playRound(round);
            round++;

            playAgain = askYesNo("Play again? (yes/no): ");
        }

        printFinalScoreboard();
        System.out.println("Thanks for playing! Goodbye.");
        scanner.close();
    }

    private static void playRound(int round) {
        int secretNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + 1) + LOWER_BOUND;

        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("\nI'm thinking of a number between " + LOWER_BOUND + " and " + UPPER_BOUND + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts. Good luck!\n");

        while (attempts < MAX_ATTEMPTS) {
            int guess = readIntInRange("Attempt " + (attempts + 1) + "/" + MAX_ATTEMPTS
                    + " — Enter your guess: ", LOWER_BOUND, UPPER_BOUND);
            attempts++;

            if (guess == secretNumber) {
                System.out.println("Correct! You guessed it in " + attempts + " attempt(s).");
                guessedCorrectly = true;
                break;
            } else if (guess < secretNumber) {
                System.out.println("Too Low!");
            } else {
                System.out.println("Too High!");
            }

            int remaining = MAX_ATTEMPTS - attempts;
            if (remaining > 0) {
                System.out.println("Attempts remaining: " + remaining);
            }
        }

        if (!guessedCorrectly) {
            System.out.println("\nYou Lost! The number was: " + secretNumber);
        }

        String summary = "Round " + round + " — "
                + (guessedCorrectly ? "guessed in " + attempts + " attempts" : "not guessed, revealed " + secretNumber);
        scoreBoard.add(summary);

        System.out.println("Summary: " + summary);
    }

    private static int readIntInRange(String prompt, int lower, int upper) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(line);
                if (value < lower || value > upper) {
                    System.out.println("Please enter a number between " + lower + " and " + upper + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid number. Try again.");
            }
        }
    }

    private static boolean askYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("no") || input.equals("n")) {
                return false;
            } else {
                System.out.println("Please answer 'yes' or 'no'.");
            }
        }
    }

    private static void printFinalScoreboard() {
        System.out.println("\n========== FINAL SCOREBOARD ==========");
        if (scoreBoard.isEmpty()) {
            System.out.println("No rounds played.");
        } else {
            for (String entry : scoreBoard) {
                System.out.println(entry);
            }
        }
        System.out.println("=======================================");
    }
}
