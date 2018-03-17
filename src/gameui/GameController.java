package gameui;

import game.NumberGame;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Controller for the GuessingGame user interface.
 * @author Patiphan Srisook
 *
 */
public class GameController {

	@FXML
	private TextField textfield;
	@FXML
	private Button Guess;
	@FXML
	private Button giveUp;
	@FXML
	private Label hint;
	@FXML
	private Label count;
	/** The Numbergame that we want to handle. */
	private NumberGame game;
	
	public void setGuessingGame(NumberGame game) {
		this.game = game;
	}
	
	public void guessButtonHandler() {
		int guess = 0;
		try {
			guess = Integer.parseInt(textfield.getText().trim());
			boolean correct = game.guess(guess);
			hint.setStyle("-fx-text-fill : black");
			if(correct) {
				hint.setStyle("-fx-text-fill : green");
				hint.setText(String.format("%s The secret number is %d.", game.getMessage(),guess));
				count.setText(String.format("You use %d times for guessing.", game.getCount()));
				textfield.clear();
				textfield.setDisable(true);
				Guess.setDisable(true);
				giveUp.setDisable(true);
			}
			else { 
				hint.setText(game.getMessage()); 
				textfield.clear();
			}
			
		} catch (Exception e) {
			hint.setStyle("-fx-text-fill : red");
			hint.setText("Number Only");
			textfield.clear();
		}
	}
	
	public void giveUpButtonHandler() {
		hint.setText("Try again later");
		textfield.setDisable(true);
		Guess.setDisable(true);
		giveUp.setDisable(true);
	}
	
	public void convertOnEnter(KeyEvent event) {
		if(event.getCode().equals(KeyCode.ENTER)) {
			guessButtonHandler();
		}
	}
}
