package huffman.control;

import java.io.File;
import huffman.presentation.BrowseFileScene;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/*
 * Create a Controller for the file browsing scene
 */
public class BrowseFileControl {
	//Attributes
	private FileChooser fileChooser;
	private File file;
	private BrowseFileScene BrowseScene;
	private RunControl scene2;
	private GridPane pane;
	private Label label;
	private Button run;
	private Button browse;
	private Button cancel;

	public BrowseFileControl(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		BrowseScene = new BrowseFileScene(stage);
		setPane(BrowseScene.getPane());
		setLabel(BrowseScene.getLabel());
		run = BrowseScene.getRun();
		cancel= BrowseScene.getCancel();
		this.fileChooser = new FileChooser();
		browse= BrowseScene.getBrowse();
		handle_browse(browse,stage);
		handle_run(run,stage);
		handle_cancel(cancel);
	}

	private void handle_cancel(Button cancel2) {
		//Method to handle cancel button
		cancel2.setOnAction(a->{
			Platform.exit();
		});	
	}

	private void handle_run(Button run2, Stage stage) {
		//Method to handle run button
		run2.setOnAction(a->{
			setScene2(new RunControl(stage,file));
		});		
	}

	private void handle_browse( Button browse, Stage stage) {
		//Method to handle browse button
		browse.setOnAction(e->{
			this.file=fileChooser.showOpenDialog(stage); 
			if(file==(null)) {
				AlertBoxCtrl a = new AlertBoxCtrl("You haven't chose a file yet!", "No file");
				a.show();
			} else {
				GridPane.setHalignment(run,HPos.CENTER);
				pane.add(run, 2, 2);
				label.setText("             Reday to Process...");
			}
		});
	}
	/*
	 * Getters and Setters
	 */
	public FileChooser getFileChooser() {
		return fileChooser;
	}

	public void setFileChooser(FileChooser fileChooser) {
		this.fileChooser = fileChooser;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Button getRun() {
		return run;
	}

	public void setRun(Button run) {
		this.run = run;
	}

	public ButtonBase getCancel() {
		return cancel;
	}

	public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public RunControl getScene2() {
		return scene2;
	}

	public void setScene2(RunControl scene2) {
		this.scene2 = scene2;
	}
}