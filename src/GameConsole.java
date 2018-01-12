import java.util.Scanner;

/** 
 *  Play guessing game on the console.
 */
public class GameConsole {
	
	/** The play method plays a game using input from a user.
	 * @param game is the NumberGame to solve.
	 *  @return guess is the guessed secret.
	 */
	public int play(NumberGame game) {
		Scanner console = new Scanner(System.in);
		
		// describe the game
		System.out.println(game.toString());
		boolean play = true;
		int guess = 0;
		System.out.println(game.getMessage());
		
		// loop until player correct.
		while(play) {
			System.out.print("Your answer? ");
			guess = console.nextInt();
			boolean correct = game.guess(guess);
			System.out.println(game.getMessage());
			if(correct==true) { play = false; }
		}
		console.close();
		return guess;
	}
	
}
