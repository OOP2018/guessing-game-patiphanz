/**
 * Automatically find the secret to any NumberGame.
 * @author Patiphan Srisook
 *
 */
public class GameSolver {
	/**
	 * 
	 * @param game is the NumberGame to solve
	 * @return guess that is the 
	 */
	public int play(NumberGame game) {
		int max = game.getUpperBound();
		int min = 1 ;
		int guess = 0;
		int range = 0;
		// describe the game
		System.out.println(game.toString());
		boolean play = true;
		
		System.out.println(game.getMessage());
		
		// loop until solver correct.
		while(play) {
			range = max - min + 1;
			guess = (int) ((Math.random()*range) + min);
			boolean correct = game.guess(guess);
			if(game.getMessage().contains("small")) {min = guess;}
			else if(game.getMessage().contains("large")) {max = guess;}
			if(correct==true) { play = false; }
			
		}
		return guess;
	}
}
