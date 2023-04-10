import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Interface {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String selectedCategoryId = null;
        ArrayList<Character> incorrectLetters = new ArrayList<>();
        boolean playAgain = true;
        boolean validCategoryId;
        char[] currentWordStateArray;
        boolean alreadyGuessed;
        boolean gameEnd;
        char guess;
        boolean correctGuess;
        boolean validPlayAgain;
        Categories selectedCategory;
        SelectedWord word;
        String currentWordState;

        System.out.println("Hello and welcome to hangman!");

        while (playAgain) {
            validCategoryId = false;
            Hangman.resetGuesses();
            incorrectLetters.clear();
            String wantsToPlayAgain = "";
            System.out.println("Please select which category you would like to play.");

            //Takes category selection and makes sure it's valid.
            while (!validCategoryId) {
                System.out.println("Your options are:");
                System.out.println("1) Animals");
                System.out.println("2) Countries");
                System.out.println("3) Capital Cities");
                selectedCategoryId = input.next();
                if (!selectedCategoryId.equals("1") &&
                        !selectedCategoryId.equals("2") &&
                        !selectedCategoryId.equals("3") &&
                        !selectedCategoryId.equalsIgnoreCase("Animals") &&
                        !selectedCategoryId.equalsIgnoreCase("Countries") &&
                        !selectedCategoryId.equalsIgnoreCase("Capital Cities")) {
                    System.out.println("Invalid input");
                    System.out.println("Please try again");
                } else {
                    validCategoryId = true;
                }
            }
            selectedCategory = new Categories(selectedCategoryId);
            word = new SelectedWord(selectedCategory);
            currentWordState = "";
            for (int i = 0; i < word.getSelectedWord().length(); i++) {
                currentWordState = currentWordState + "_";
            }
            currentWordStateArray = currentWordState.toCharArray();
            System.out.println("You selected the " + selectedCategory.getCategoryName() + " category.");
            System.out.println("Your chosen word is " + word.getSelectedWord().length() + " characters long.");
            System.out.println(currentWordState);
//            System.out.println(word.getSelectedWord());
            System.out.println("Please make your first guess.");

            //Takes asks for a guess then checks if it's correct
            alreadyGuessed = false;
            gameEnd = false;
            while (Hangman.getGuessesRemaining() >= 0 && !gameEnd) {
                guess = input.next().charAt(0);
                correctGuess = false;
                for (Character incorrectLetter : incorrectLetters) {
                    if (guess == incorrectLetter) {
                        alreadyGuessed = true;
                        break;
                    }
                }
                if (alreadyGuessed) {
                    System.out.println("Sorry you cant guess a letter more than once");
                    System.out.println("Please try again");
                    alreadyGuessed = false;
                } else {
                    for (int i = 0; i < word.getSelectedWord().length(); i++) {
                        if (i == 0 && Character.toLowerCase(word.getSelectedWord().toCharArray()[i]) == guess) {
                            currentWordStateArray[i] = Character.toUpperCase(guess);
                            correctGuess = true;
                        } else if (word.getSelectedWord().toCharArray()[i] == guess) {
                            currentWordStateArray[i] = guess;
                            correctGuess = true;
                        }
                    }
                    //Adds a failed attempt if the guess is wrong
                    if (!correctGuess) {
                        Hangman.addFailedGuess();
                        Hangman.showHangman();
                        incorrectLetters.add(guess);
                        if (Hangman.getGuessesRemaining() != 0) {
                            System.out.println("Incorrect guesses so far: " + incorrectLetters);
                            System.out.println(currentWordState);
                        }
                    }
                    currentWordState = Arrays.toString(currentWordStateArray);
                    currentWordState = currentWordState.replace("[", "");
                    currentWordState = currentWordState.replace("]", "");
                    currentWordState = currentWordState.replace(",", "");
                    currentWordState = currentWordState.replace(" ", "");
                    //Checks if player has won or lost
                    if (Hangman.getGuessesRemaining() == 0) {
                        gameEnd = true;
                        System.out.println("The word was " + word.getSelectedWord() + ".");
                        System.out.println("Would you like to play again?");
                        System.out.println("yes/no");
                        wantsToPlayAgain = input.next();
                    } else if (currentWordState.equals(word.getSelectedWord())) {
                        gameEnd = true;
                        System.out.println("Congratulations!");
                        System.out.println("You win!");
                        System.out.println("Would you like to play again?");
                        System.out.println("yes/no");
                        wantsToPlayAgain = input.next();
                    } else if (correctGuess){
                        System.out.println("Correct, guess your next letter");
                        if (!incorrectLetters.isEmpty()) {
                            System.out.println("Incorrect guesses so far: " + incorrectLetters);
                        }
                        System.out.println(currentWordState);
                    }
                    validPlayAgain = false;
                    while (!validPlayAgain && !wantsToPlayAgain.equals("")) {
                        if (wantsToPlayAgain.equalsIgnoreCase("n") ||
                                wantsToPlayAgain.equalsIgnoreCase("no")) {
                            validPlayAgain = true;
                            playAgain = false;
                        } else if (!wantsToPlayAgain.equalsIgnoreCase("y") &&
                                !wantsToPlayAgain.equalsIgnoreCase("yes")) {
                            System.out.println("Sorry, that's not a recognised answer");
                            System.out.println("Please try again");
                            wantsToPlayAgain = input.next();
                        } else {
                            validPlayAgain = true;
                        }
                    }
                }
            }
        }
    }
}
