package huffman.control;

import huffman.presentation.ShowTableScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ShowTableControl {
	//Fields
	private Stage stage;
	private ShowTableScene scene;
	private Label message;
	private Button cancel;
	
	public ShowTableControl(String[] codes) {
		initialize(codes);
	}
	
	private void initialize(String[] codes) {
		setScene(new ShowTableScene(codes));
		setStage(getScene().getStage());
		setCancel(getScene().getCancel());
		setMessage(getScene().getMessage());
		handle_cancel(cancel);
	}
	/*
	 * Handlers
	 */
	private void handle_cancel(Button cancel) {
		cancel.setOnAction(e->{
			stage.close();
		});
	}
	/*
	 * Getters and setters
	 */
	public ShowTableScene getScene() {
		return scene;
	}
	public void setScene(ShowTableScene scene) {
		this.scene = scene;
	}
	public Label getMessage() {
		return message;
	}
	public void setMessage(Label message) {
		this.message = message;
	}
	public Button getCancel() {
		return cancel;
	}
	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
	public Stage getStage() {
		return stage;
	}
	public void setStage(Stage stage) {
		this.stage = stage;
	}
}