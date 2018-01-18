/**
 * Automatically find the secret to any NumberGame.
 * @author Patiphan Srisook
 *
 */
public class GameSolver {

	/**
	 * Play a NumberGame and return the solution.
	 * The NumberGame object must provide message (getMessage)
	 * containing the phrase "too small" if a guess is too small
	 * and "too large" if a guess is too large, for efficient
	 * solution.
	 * 
	 * @param game is the NumberGame to solve
	 * @return guess is the solution
	 */
	public int play(NumberGame game) {
		boolean correct;
		int max = game.getUpperBound();
		int min = 1;
		int guess = 0;
		
		System.out.println( game.toString() );
		System.out.println( game.getMessage() );
		// loop until solver is correct
		do {
			guess = min + (max-min)/2;
			if (max-guess==1) {
				game.guess(guess);
				return guess;
			}
			correct = game.guess(guess);
			if(game.getMessage().contains("too small")) min = guess;
			else if (game.getMessage().contains("too large")) max = guess;
			
		} while(!correct);
		return guess;
	}
}
