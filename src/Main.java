/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		NumberGame game = new ShootGame(upperBound);
//		GameConsole ui = new GameConsole( );
//		int solution = ui.play( game );
		/* Uncomment to use gamesolver */
		GameSolver gs = new GameSolver(); 
		int solution = gs.play(game);
		System.out.println("The secret number is " + solution + ".");
		System.out.println("You use " + game.getCount() + " times for guessing.");
	}
}
