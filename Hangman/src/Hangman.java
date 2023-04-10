public class Hangman {
    private static int guessesRemaining = 7;

    public static void addFailedGuess(){
        guessesRemaining--;
    }

    public static int getGuessesRemaining(){
        return guessesRemaining;
    }

    public static void resetGuesses(){
        guessesRemaining = 7;
    }

    public static void showHangman(){
        if (guessesRemaining == 6) {
            System.out.println("     / \\");
            System.out.println("Sorry that's incorrect!");
            System.out.println("You have " + guessesRemaining + " guesses remaining!");
        } else if (guessesRemaining == 5) {
            System.out.println("/ \\   |");
            System.out.println("     / \\");
            System.out.println("Sorry that's incorrect!");
            System.out.println("You have " + guessesRemaining + " guesses remaining!");
        } else if (guessesRemaining == 4) {
            System.out.println(" |    |");
            System.out.println("/ \\   |");
            System.out.println("     / \\");
            System.out.println("Sorry that's incorrect!");
            System.out.println("You have " + guessesRemaining + " guesses remaining!");
        } else if (guessesRemaining == 3) {
            System.out.println("/|\\   |");
            System.out.println(" |    |");
            System.out.println("/ \\   |");
            System.out.println("     / \\");
            System.out.println("Sorry that's incorrect!");
            System.out.println("You have " + guessesRemaining + " guesses remaining!");
        } else if (guessesRemaining == 2) {
            System.out.println(" o    |");
            System.out.println("/|\\   |");
            System.out.println(" |    |");
            System.out.println("/ \\   |");
            System.out.println("     / \\");
            System.out.println("Sorry that's incorrect!");
            System.out.println("You have " + guessesRemaining + " guesses remaining!");
        } else if (guessesRemaining == 1) {
            System.out.println(" |    |");
            System.out.println(" o    |");
            System.out.println("/|\\   |");
            System.out.println(" |    |");
            System.out.println("/ \\   |");
            System.out.println("     / \\");
            System.out.println("Sorry that's incorrect!");
            System.out.println("You have " + guessesRemaining + " guesses remaining!");
        } else if (guessesRemaining == 0) {
            System.out.println("  ____");
            System.out.println(" |    |");
            System.out.println(" o    |");
            System.out.println("/|\\   |");
            System.out.println(" |    |");
            System.out.println("/ \\   |");
            System.out.println("     / \\");
            System.out.println("Sorry that's incorrect!");
            System.out.println("You are out of guesses!");
            System.out.println("You lose!");
        }
    }
}
