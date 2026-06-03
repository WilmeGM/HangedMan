import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {
    public static void main(String[] args) throws Exception {

        // initializating variables
        Scanner scn = new Scanner(System.in);
        String wordToGuess = "java";
        char[] lettersGuessed = new char[wordToGuess.length()];
        boolean guessed = false;
        int tries = wordToGuess.length() + 3;

        Utils.HideCharArray(lettersGuessed);

        while (tries > 0) {
            Utils.ClearConsole();
            System.out.print("Hidden word: ");
            Utils.ShowCharArray(lettersGuessed);

            System.out.println();
            System.out.println("Tries missing: " + tries);
            System.out.print("Try to guess: ");
            char inputLetter = scn.next().charAt(0);

            if (wordToGuess.contains(String.valueOf(inputLetter))) { // when input is correct
                System.out.println();

                if (String.valueOf(lettersGuessed).contains(String.valueOf(inputLetter))) {
                    System.out.println("Already selected. Worry about your tries.");
                } else {
                    System.out.println("Yes!");
                    for (int i = 0; i < wordToGuess.length(); i++) {
                        if (inputLetter == wordToGuess.charAt(i)) {
                            lettersGuessed[i] = inputLetter;
                        }
                    }
                }

                tries--;
                TimeUnit.SECONDS.sleep(2);
            } else { // when input is incorrect
                System.out.println();
                System.out.println("Nope!");

                tries--;
                TimeUnit.SECONDS.sleep(2);
            }

            
            if (!String.valueOf(lettersGuessed).contains("_")) {
                guessed = true;
                break;
            }
        }

        if (guessed) {
            Utils.ClearConsole();
            System.out.println("The word was " + wordToGuess);
            System.out.println("You won.");
            TimeUnit.SECONDS.sleep(2);
        } else {
            Utils.ClearConsole();
            System.out.println("The word was " + wordToGuess);
            System.out.println("You lost.");
            TimeUnit.SECONDS.sleep(2);
        }

        scn.close();
    }
}