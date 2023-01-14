package huffman.control;

import huffman.presentation.AlertBoxScene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
/*
 * Creates a controller for the Alert window, 
 * In which it shows a message and sets a title
 */
public class AlertBoxCtrl {
	//Attributes
	private AlertBoxScene scene;
	private Label message;
	private Button cancel;
	
	public AlertBoxCtrl(String meassage,String title) {
		initialize(meassage,title);
	}

	private void initialize(String meassage, String title) {
		setScene(new AlertBoxScene());
		setMessage(getScene().getMessage());
		setCancel(getScene().getCance());
		
		getScene().getWindow().setTitle(title);
		getMessage().setText(meassage);
		
		handle_cancel(cancel);
	}
	
	public void show() {
		getScene().getWindow().show();
	}

	private void handle_cancel(Button cancel2) {
		//Method that handles cancel
		cancel2.setOnAction(e->{
			getScene().getWindow().close();
		});
	}
	/*
	 * Getters and Setters
	 */
	public AlertBoxScene getScene() {
		return scene;
	}

	public void setScene(AlertBoxScene scene) {
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
}