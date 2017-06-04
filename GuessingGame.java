import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

	public static void main(String[] args) {
		// Makes objects to use
		Random rand = new Random();
		Scanner user_input = new Scanner(System.in);
		// Initializes numbers
		int range = 100;
		int rng = rand.nextInt(range + 1);
		// Asks for input
		PrintClass.println("How many tries would you like?");
		int tries = user_input.nextInt();
		PrintClass.print("Enter a guess");
		int userGuess = user_input.nextInt();
		if (userGuess > range || userGuess < 0){
			PrintClass.println("That number isn't in the range. Please try again!");
		}
		else {
		// Calculates what needs to be done
			// Displays a different message if it gets guessed correctly on the first try
			if(guessCheck(userGuess, rng)=="You got it!"){
				PrintClass.println("You are very lucky!  You got it on the first try");
			}
			else {
				PrintClass.println(guessCheck(userGuess, rng));
				tries--;

			}
			// Tells user to guess again.
		while (userGuess != rng){
			if(tries == 0){
				PrintClass.println("You ran out of tries!  You lose!  The correct number was " + rng + "." );
				break;
			}
			PrintClass.println("You have " + tries + " tries remaining.  Please enter another number!");
			userGuess = user_input.nextInt();
			PrintClass.print(guessCheck(userGuess, rng));
			tries--;
		}
		if (tries == 0) {
		}
		user_input.close();
		}
	}
		// Method which takes a guess
		private static String guessCheck(int userGuess, int rng){
			String result;
			if(userGuess == rng){
				result = "You got it";
			}
			else if(Math.abs(userGuess - rng) > 50){
				if(userGuess > rng){
					result = "Way too high!";
				}
				else {
					result = "Way too low!";
				}
			}
			else if(userGuess > rng){
				result = "Just a bit too high!";
			}
			else {
				result = "Ooh, too low!";
			}
			
			return result;
			}
		
		}

		


