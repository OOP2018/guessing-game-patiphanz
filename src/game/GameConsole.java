package game;
import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {

	/**
	 * The play method plays a game using input from a user.
	 * @param game is the NumberGame user want to play.
	 * @return guess solution.
	 */
	public int play(NumberGame game) {
		boolean retry = true;
		int guess = 0;
		Scanner console = new Scanner(System.in);
		
		// describe the game
		System.out.println( game.toString() );
		
		// Give the question to user.
		while(retry) {
			System.out.println( game.getMessage() );
			System.out.print("Your guess? ");
			guess = console.nextInt();
			// Check user answer.
			boolean correct = game.guess(guess);
//			System.out.println( game.getMessage() );
			if(correct) {
				System.out.print( game.getMessage() );
				retry = false;
			}
		}
		return guess;
	}
	
}
