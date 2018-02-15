import java.util.*;

 /**
  * This class describes a student and the basic property he/she has. 
  * @author Zaid Ajaj - s4807561
  * @author Luna-Elise Schernthaner - s4703928
  */
public class Program
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello to our great Hangman game!");

        Gallows game = new Gallows();

        while(!game.finished())
        {
            int guessesLeft = game.getGuessesLeft();
            String guessedSoFar = game.partialWordGuessedSoFar();
            
            System.out.println("You have " + guessesLeft + " guesses left");
            System.out.println("Word guessed so far: " + guessedSoFar);

            if (scanner.hasNextLine())
            {
                String nextGuess = scanner.nextLine();
                game.guess(nextGuess);
            }
        }

        if (game.playerWon())
        {
            String foundWord = game.partialWordGuessedSoFar();
            System.out.println("You have won! congrats. You found the word: " + foundWord);
        }
        else
        {
            System.out.println("Computer has won, you have not been able to guess the word.");
        }

        scanner.close();
    }
}