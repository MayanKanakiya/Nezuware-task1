package codetech;
import java.util.Random;
import java.util.Scanner;

public class Codetech_task3 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int min = 1;
        int max = 100;
        int randomNumber = random.nextInt(max - min + 1) + min;
        int attemptLimit = 5;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess the number between " + min + " and " + max + ". You have " + attemptLimit + " attempts.");

        for (int attempt = 1; attempt <= attemptLimit; attempt++) {
            System.out.print("Attempt " + attempt + ": Enter your guess: ");
            int userGuess;

            try {
                userGuess = scanner.nextInt();

                if (userGuess < min || userGuess > max) {
                    System.out.println("Error: Please guess a number between " + min + " and " + max + ".");
                    attempt--;  // Do not count invalid attempts
                    continue;
                }

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    return;
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low.");
                } else {
                    System.out.println("Your guess is too high.");
                }

            } catch (Exception e) {
                System.out.println("Error: Invalid input. Please enter a valid number.");
                scanner.next();  // Clear invalid input
                attempt--;  // Do not count invalid attempts
            }
        }

        System.out.println("Sorry, you've exceeded the attempt limit. The correct number was " + randomNumber + ".");
        scanner.close();
    }
}
