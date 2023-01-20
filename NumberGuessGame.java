import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String args[]) throws Exception {
        /*
       This block of code asks the player for a min and maximum number.
       It stores the min and max and asks the player to make their first guess 
       and try to guess a number between their min and max number
        */ 
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the minimum number");
        int min = sc.nextInt();
        System.out.println("Choose the maximum number");
        int max = sc.nextInt();
        int number = random.nextInt(min, max);
        System.out.println("Try to guess a random number between " + min + " - " + max);
        int numguesses = 1;
        ArrayList<Integer> guessList = new ArrayList();
        guess(sc, number, guessList, max, min);
    }

    public static void guess(Scanner sc, int number, ArrayList guessList, int max, int min) {
        if (sc.hasNextInt()) {
            int guess = sc.nextInt();

        /*
        This block of code is error checking.
        It ensures that if their guess is a number larger or smaller than their
        min and max respectivly, the code will print invalid guess, not count that guess in 
        their final score, and ask them for another guess.
         */
        if (min > guess || guess > max) {
            System.out.println("Invalid Input Try Again");
            guess(sc, number, guessList, max, min);

        } 
        
        /*
        This block of code is also error checking.
        It ensures that the user does not enter any words (strings) where they should
        guess a number (int).
        */
        else if (guessList.contains(guess)) {
            System.out.println("You already guessed this number, please guess again");
            guess(sc, number, guessList, max, min);
        }
        else if (number > guess) {
            System.out.println("guess higher");
            System.out.println("Guess Again");
            guessList.add(guess);
            guess(sc, number, guessList, max, min);
        }
        else if (number < guess) {
            System.out.println("guess lower");
            System.out.println("Guess Again");
            guessList.add(guess);
            guess(sc, number, guessList, max, min);
        }

        /* 
        If the user guesses the correct number the code will end the loop and print
        "You guessed correct" and print the amount of tries it took the player to guess the 
        magic number.
         */
        if (number == guess) {
            guessList.add(guess);
            System.out.println("You guessed correct!!!");
            System.out.println("It took you " + guessList.size() + " tries");
            System.exit(0);
        }
        }
        else {
            System.out.println("Invalid Input Try Again");
            sc.next(); // discard input
            guess(sc, number, guessList, max, min);
        }
        
        

    }

}
