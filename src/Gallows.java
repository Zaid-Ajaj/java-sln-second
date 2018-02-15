import java.util.*;
import java.lang.*;

 /**
  * This class describes a student and the basic property he/she has. 
  * @author Zaid Ajaj - s4807561
  * @author Luna-Elise Schernthaner - s4703928
  */
public class Gallows
{
    private String wordToGuess;
    private ArrayList<String> guessedLetters = new ArrayList<String>();
    private int guessesLeft = 10;

    public Gallows(String wordToGuess)
    {
        this.wordToGuess = wordToGuess;
    }

    /** Creates an instance of the class with a random word to guess chosen from file */
    public Gallows()
    {
        WordReader reader = new WordReader("words.txt");
        this.wordToGuess = reader.getWord();
    }

    /** Returns whether or not the player has won  */
    public boolean playerWon()
    {
        return guessesLeft > 0 && finished();
    }

    /** Checkes that the guessed letters match the letters in the word to be guessed  */
    public boolean wordFound(String wordToGuess, ArrayList<String> guessedLetters)
    {
        int wordLength = wordToGuess.length();
        char[] wordToBeGuessedLetters = wordToGuess.toCharArray();

        for(int i = 0; i < wordLength; i++)
        {
            boolean letterFound = false;
 
            for(int j = 0; j < guessedLetters.size() ; j++)
            {
                char currentLetter = wordToBeGuessedLetters[i];
                String currentGuessedLetter = guessedLetters.get(j);
                if(currentLetter == currentGuessedLetter.charAt(0))
                {
                    letterFound = true;
                    continue;
                }
            }

            if (!letterFound)
            {
                return false;
            }
        }

        return true;
    }

    /** Returns whether the game has finished or not: either the player used up all his/her guessed or the player found the word */
    public boolean finished()
    {
        return guessesLeft == 0 || wordFound(wordToGuess, guessedLetters);
    }

    /** Returns how many guesses the player has left before he/she loses */
    public int getGuessesLeft()
    {
        return guessesLeft;
    }

    public String partialWordGuessedSoFar()
    {
        StringBuilder builder = new StringBuilder();
        int length = wordToGuess.length();
        for(int i = 0; i < length; i++)
        {
            boolean letterGuessed = false;
            char currentLetter = wordToGuess.charAt(i);
            for(String letter : guessedLetters) 
            {
                // letter has length >= 1, so
                char guessedLetter = letter.charAt(0);
                if (currentLetter == guessedLetter)
                {
                    letterGuessed = true;
                    break;
                }
            }

            if (letterGuessed)
            {
                builder.append(currentLetter);
            }
            else
            {
                builder.append('.');
            }
        }

        return builder.toString();
    }

    public void guess(String letter)
    {
        boolean correctlyGuessed = wordToGuess.contains(letter);
        
        if (!letter.isEmpty())
        {
            guessedLetters.add(letter);
            guessesLeft = guessesLeft - 1;
        }
    
        if (!correctlyGuessed)
        {
            guessesLeft = guessesLeft - 1;
        }
    }
}