package gameui;
	
import java.net.URL;

import game.NumberGame;
import game.ShootGame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		NumberGame game = new ShootGame(100);
		
		try {
			URL url = getClass().getResource("GameUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: GameUI.fxml");
				Platform.exit();
			}
			// Load the FXML and get reference to the loader
			FXMLLoader loader = new FXMLLoader(url);
			// Create the UI. This will instantiate the controller object, too.
			Parent root = loader.load();
			// Now we can get the controller object from the FXMLloader.
			// This is interesting -- we don't need to use a cast!
			GameController controller = loader.getController();
			
			// Dependency Injection:
			// Set the Counter object we want the view to update.
			controller.setGuessingGame(game);

			// Build and show the scene
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.setTitle("Guessing Game");
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		CounterView view = new CounterView(game);
		game.addObserver(view);
		view.run();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
