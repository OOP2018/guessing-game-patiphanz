import java.util.Random;

/**
 * ShootGame is a game of guessing a secret number.
 * 
 * @author Patiphan Srisook
 * @version 1.0
 *
 */
public class ShootGame extends NumberGame {
	/** upper bound for secret number */
	private int upperbound;
	/** the solution to the game*/
	private int secret;
	/** count amount of time user use for guessing*/
	private int count;
	
	/** Initialize a new default game*/
	public ShootGame() {
		this(100);
	}
	
	public ShootGame(int upperbound) {
		this.count = 0;
		this.upperbound = upperbound;
		// create the secret number
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		this.secret = rand.nextInt(upperbound) + 1;
		super.setMessage("I'm thinking of a number between 1 and " + upperbound + ".");
	}
	
	/**
	 * Evaluate a user's guess.
	 * @param number is the user's guess.
	 * @return true if guess is correct, false otherwise.
	 */
	@Override
	public boolean guess(int number) {
		count++;
		if(number == secret) {
			setMessage("Correct!");
			return true;
		}
		if(number < secret) {
			setMessage("Your answer is too small.");
		}
		else /*if(number > secret)*/{
			setMessage("Your answer is too large.");
		}
		return false;
	}
	
	/**
	 * @return upper bound for the solution to this game. 
	 * Should be positive Integer.
	 */
	@Override
	public int getUpperBound() {
		return this.upperbound;
	}
	
	/**
	 * Describe the game.
	 * @return general description of this game.
	 */
	@Override
	public String toString() {
		return "Guess a secret number.";
	}
	
	public int getCount() {
		return this.count;
	}
}
