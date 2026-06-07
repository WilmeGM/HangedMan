import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {

        // initializating variables
        Scanner scn = new Scanner(System.in);
        String wordToGuess = "java";
        char[] lettersGuessed = new char[wordToGuess.length()];
        boolean guessed = false;
        boolean contains = false;
        int tries = wordToGuess.length() + 3;
        int missingLetters = wordToGuess.length();
        StringBuilder lettersSelected = new StringBuilder();

        Utils.HideCharArray(lettersGuessed);

        while (tries > 0) {
            Utils.ClearConsole();
            System.out.print("Hidden word: ");
            Utils.ShowCharArray(lettersGuessed);

            System.out.println();
            System.out.println("Tries missing: " + tries);
            System.out.print("Try to guess: ");
            char inputLetter = scn.next().charAt(0);

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (inputLetter == wordToGuess.charAt(i)) {
                    lettersGuessed[i] = inputLetter;
                    contains = true;
                    missingLetters--;
                }
            }

            System.out.println();

            if (contains) {
                if (lettersSelected.toString().contains(Character.toString(inputLetter))) {
                    System.out.println("Already selected. Worry about your tries.");
                } else {
                    System.out.println("Yes!");
                }
            } else {
                System.out.println("Nope!");
            }

            contains = false;
            lettersSelected.append(inputLetter);

            tries--;
            TimeUnit.SECONDS.sleep(2);

            if (missingLetters == 0) {
                guessed = true;
                break;
            }
        }

        if (guessed) {
            Utils.ClearConsole();
            System.out.println("The word was " + wordToGuess);
            System.out.println("You won.");
        } else {
            Utils.ClearConsole();
            System.out.println("The word was " + wordToGuess);
            System.out.println("You lost.");
            
        }

        TimeUnit.SECONDS.sleep(3);
        Utils.ClearConsole();

        scn.close();
    }
}