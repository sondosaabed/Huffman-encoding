package huffman.application;

import huffman.control.MainControl;
import javafx.application.Application;
import javafx.stage.Stage;
/*
 * Shows the Browsing scene
 */
public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}
		
	@Override
	public void start(Stage stage) {
		MainControl mainCtrl = new MainControl();
		mainCtrl.showBrowseScene(stage);
	}
}