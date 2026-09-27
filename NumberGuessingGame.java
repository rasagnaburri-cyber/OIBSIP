import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int round = 1;
        int totalRounds = 0;
        int totalAttempts = 0;

        System.out.println("======================================");
        System.out.println("        NUMBER GUESSING GAME");
        System.out.println("======================================");

        boolean playAgain = true;

        while (playAgain) {

            System.out.println("\n---------- ROUND " + round + " ----------");

            // Difficulty selection
            System.out.println("\nChoose Difficulty:");
            System.out.println("1. Easy   (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 7 attempts)");
            System.out.println("3. Hard   (1-200, 5 attempts)");

            int difficulty;

            while (true) {
                System.out.print("Enter your choice (1-3): ");

                if (scanner.hasNextInt()) {
                    difficulty = scanner.nextInt();

                    if (difficulty >= 1 && difficulty <= 3) {
                        break;
                    } else {
                        System.out.println("Please enter 1, 2, or 3.");
                    }

                } else {
                    System.out.println("Invalid input! Enter a number.");
                    scanner.next();
                }
            }

            int maxNumber;
            int maxAttempts;
            String difficultyName;

            if (difficulty == 1) {
                maxNumber = 50;
                maxAttempts = 10;
                difficultyName = "Easy";

            } else if (difficulty == 2) {
                maxNumber = 100;
                maxAttempts = 7;
                difficultyName = "Medium";

            } else {
                maxNumber = 200;
                maxAttempts = 5;
                difficultyName = "Hard";
            }

            // Generate random number
            int secretNumber = random.nextInt(maxNumber) + 1;

            System.out.println("\nDifficulty: " + difficultyName);
            System.out.println("Guess a number between 1 and " + maxNumber);
            System.out.println("You have " + maxAttempts + " attempts.");

            int attempts = 0;
            boolean guessedCorrectly = false;

            // Guessing loop
            while (attempts < maxAttempts) {

                System.out.print("\nEnter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input! Please enter a number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();

                // Validate range
                if (guess < 1 || guess > maxNumber) {
                    System.out.println(
                            "Please enter a number between 1 and " + maxNumber + "."
                    );
                    continue;
                }

                attempts++;

                System.out.println("Attempt " + attempts + " of " + maxAttempts);

                if (guess > secretNumber) {

                    System.out.println("Too High!");

                } else if (guess < secretNumber) {

                    System.out.println("Too Low!");

                } else {

                    System.out.println("\n🎉 Correct!");
                    System.out.println("You guessed the number in "
                            + attempts + " attempts.");

                    guessedCorrectly = true;
                    break;
                }
            }

            // Lost condition
            if (!guessedCorrectly) {

                System.out.println("\n❌ You Lost!");
                System.out.println("You used all " + maxAttempts + " attempts.");
                System.out.println("The correct number was: " + secretNumber);
            }

            // Round summary
            totalRounds++;
            totalAttempts += attempts;

            System.out.println("\n======================================");
            System.out.println("ROUND " + round + " SUMMARY");
            System.out.println("Difficulty : " + difficultyName);
            System.out.println("Attempts   : " + attempts);

            if (guessedCorrectly) {
                System.out.println("Result     : WON");
            } else {
                System.out.println("Result     : LOST");
            }

            System.out.println("======================================");

            // Play again
            System.out.print("\nDo you want to play again? (yes/no): ");

            String answer = scanner.next();

            if (answer.equalsIgnoreCase("yes")
                    || answer.equalsIgnoreCase("y")) {

                playAgain = true;
                round++;

            } else {

                playAgain = false;
            }
        }

        // Final statistics
        System.out.println("\n======================================");
        System.out.println("           GAME STATISTICS");
        System.out.println("======================================");

        System.out.println("Total Rounds Played : " + totalRounds);
        System.out.println("Total Attempts      : " + totalAttempts);

        if (totalRounds > 0) {
            double averageAttempts =
                    (double) totalAttempts / totalRounds;

            System.out.printf("Average Attempts    : %.2f%n",
                    averageAttempts);
        }

        System.out.println("\nThank you for playing!");
        System.out.println("Goodbye 👋");

        scanner.close();
    }
}