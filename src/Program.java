import java.util.*;

public class Program
{
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Hello to our great great. 'GREAT' Hangman game!");

        Gallows game = new Gallows("terminal");

        while(!game.finished())
        {
            int guessesLeft = game.getGuessesLeft();
            String wordGuessedSoFar = game.wordGuessedSoFar();
            
            if (scanner.hasNextLine())
            {
                String input = scanner.nextLine();
                game.guess(input);
            }
        }

        if (game.playerWon())
        {
            System.out.println("You have won! congrats");
        }
        else
        {
            System.out.println("Computer has won, you have not been able to guess the word correctly");
        }
    }
}