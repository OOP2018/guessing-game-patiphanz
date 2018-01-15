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
		boolean retry = true;
		int max = game.getUpperBound();
		int range = 0;
		int min = 1;
		int guess = 0;
		
		System.out.println( game.toString() );
		System.out.println( game.getMessage() );
		// loop until solver is correct
		while(retry) {
			range = max - min + 1;
			guess = (int) ((Math.random()*range) + min);
			boolean correct = game.guess(guess);
			if(correct) {
				retry = false;
			}
			if(game.getMessage().contains("small")) min = guess;
			else max = guess;
		}
		return guess;
	}
}
