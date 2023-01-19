import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessGame {
    public static void main(String args[]) throws Exception {
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

        if (min > guess || guess > max) {
            System.out.println("Invalid Input Try Again");
            guess(sc, number, guessList, max, min);

        } 
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
