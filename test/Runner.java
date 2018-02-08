import java.lang.*;
import java.util.*;

public class Runner 
{
    public static void main(String[] args)
    {
        Test.Case("word found works as expected", () -> 
        {   
            String input = "terminal";
            ArrayList<String> guessedLetters = new ArrayList<String>();
            guessedLetters.add("t");
            guessedLetters.add("e");
            guessedLetters.add("r");
            guessedLetters.add("m");
            
            boolean wordFound = Gallows.wordFoundTest(input, guessedLetters);
            Test.AreEqual(false, wordFound, "The word shouldn't be found yet");
            
            guessedLetters.add("i");
            guessedLetters.add("n");
            guessedLetters.add("a");
            guessedLetters.add("l");

            wordFound = Gallows.wordFoundTest(input, guessedLetters);
            Test.AreEqual(true, wordFound, "The word should be now found");
        });

        Test.Case("Gallows.wordFound still works when guessed letters are empty", () ->
        {
            String input = "terminal";
            ArrayList<String> guessedLetters = new ArrayList<String>();
            boolean found = Gallows.wordFoundTest(input, guessedLetters);

            Test.AreEqual(false, found, "Word shoudn't be found");
        });


        Test.Case("Gallows: player wins if he/she guesses correctly", () -> 
        {
            Gallows game = new Gallows("terminal");

            String[] guesses = { "t", "e", "r", "m", "i", "n", "a", "l" };

            for(String guess : guesses) 
            {
                game.guess(guess);
            }

            boolean playerWon = game.playerWon();

            Test.AreEqual(true, playerWon);
        });

        Test.Case("Gallows: player loses if he/she guesses too many times incorrectly", () -> 
        {
            Gallows game = new Gallows("terminal");

            String[] guesses = { "t", "e", "r", "m", "i", "n", "a", "o", "b", "q", "z", "y" };

            for(String guess : guesses) 
            {
                game.guess(guess);
            }

            boolean playerWon = game.playerWon();

            Test.AreEqual(false, playerWon);
        });

        Test.Report();
    }
}