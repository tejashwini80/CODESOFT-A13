import java.util.Random;
import java.util.Scanner;

public class numbergame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1; // Minimum value
        int maxRange = 100; // Maximum value 
        int numberOfTries = 5; // Number of tries

       
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + minRange + " and " + maxRange + ". Try to guess it!");

        for (int i = 0; i < numberOfTries; i++) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the correct number.");
                break;
            } else {
                System.out.println("Wrong guess. " + (numberOfTries - i - 1) + " tries remaining.");

                if (userGuess < randomNumber) {
                    System.out.println("Hint: The correct number is greater than your guess.");
                } else {
                    System.out.println("Hint: The correct number is smaller than your guess.");
                }
            }

            if (i == numberOfTries - 1) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }
        }

        scanner.close();
    }
}

