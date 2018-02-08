import java.util.*;
import java.lang.*;

public class Gallows
{
    private String wordToGuess;
    private ArrayList<String> guessedLetters;
    private int guessesLeft;

    public Gallows(String wordToGuess)
    {
        this.wordToGuess = wordToGuess;
        guessesLeft = 10;
        guessedLetters = new ArrayList<String>();
    }

    public boolean playerWon()
    {
        return guessesLeft > 0 && finished();
    }

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

    public boolean finished()
    {
        return guessesLeft == 0 || wordFound(wordToGuess, guessedLetters);
    }

    public int getGuessesLeft()
    {
        return guessesLeft;
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