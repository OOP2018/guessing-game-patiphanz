import java.util.Random;

/**
 * Game of guessing a secret number.
 * @author Patiphan Srisook
 */
public class ShootGame extends NumberGame{
	
	/* upper bound for secret number */
	private int upperBound;
	/* the solution to the game */
	private int secret;
	/* count how many guesses the user makes */
	private int count;
	
	/* Initialize a default game */
	public ShootGame() {
		this(100);
	}
	
	/**
	 * Initialize a new game.
	 * @param upperBound is the max value for the secret number (>1).
	 */
	public ShootGame(int upperBound) {
		this.upperBound = upperBound;
		// initial counter
		this.count = 0;
		// create a secret number
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		this.secret = rand.nextInt(this.upperBound) + 1;
		setMessage("I'm thinking of a number between 1 and " + upperBound + ".");
	}
	
	/**
	 * Evaluate a user's guess.
	 * @param number is user's guess.
	 * @return true if guess is correct. Otherwise false.
	 */
	public boolean guess(int number) {
		this.count++;
		if(number == secret) {
			setMessage("Right! ");
			return true;
		}
		if(number > secret) {
			setMessage("Sorry, too large");
		}
		else /* if(number < secret) */ {
			setMessage("Sorry, too small");
		}
		return false;
	}
	
	/**
	 * Get the upperBound for the solution to this game.
	 * @return upperBound for the solution to this game.
	 */
	public int getUpperBound() {
		return this.upperBound;
	}
	
	/**
	 * Get count times that user guesses the answer.
	 * @return count times that user guesses the answer.
	 */
	public int getCount() {
		return this.count;
	}
	
	/** Describe the game*/
	public String toString() {
		return "Guess a secret number 1 to " + this.upperBound + ".";
	}
}
