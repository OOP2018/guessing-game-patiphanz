/**
 * Automatically find the secret to any NumberGame.
 * @author Patiphan Srisook
 *
 */
public class GameSolver {
	/**
	 * 
	 * @param game is the NumberGame to solve
	 * @return 
	 */
	public int play(NumberGame game) {
		
		// describe the game
		System.out.println(game.toString());
		boolean play = true;
		int guess = 0;
		System.out.println(game.getMessage());
		
		// loop until solver correct.
		while(play) {
			guess++;
			boolean correct = game.guess(guess);
			if(correct==true) { play = false; }
		}
		return guess;
	}
}
