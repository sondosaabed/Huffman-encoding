package huffman.control;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;

import huffman.presentation.RunScene;
/*
 * Create the Controller of the Run scene in which the user choses to either compress or decompress file
 */
public class RunControl {
	//Fields
	private RunScene RunScene;
	private DecompressControl scene2;
	private CompressControl scene1;
	private BrowseFileControl scene;
	private Button compress;
	private Button decompress;
	private Button cancel;
	
	public RunControl(Stage stage, File file) {
		initialize(stage,file);
	}
	
	private void initialize(Stage stage, File file) {
		this.RunScene = new RunScene(stage);
		this.setCompress(RunScene.getCompress());
		this.setDecompress(RunScene.getDecompress());
		this.cancel = RunScene.getCancel();
		
		handle_cancel(stage,cancel);
		handle_decompress(stage,decompress,file);
		handle_compress(stage, compress,file);
	}

	private void handle_decompress(Stage stage,Button compress2, File file) {
		//Method that handles dexompress
		/*
		 * Create the decompreede file and pass it 
		 */
		compress2.setOnAction(e->{
			try {
				setScene2(new DecompressControl(stage,file));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

	private void handle_compress(Stage stage,Button decompress2, File file) {
		//Method that handles compress
		decompress2.setOnAction(e->{
			setScene1(new CompressControl(stage,file));
		});
	}

	private void handle_cancel(Stage stage, Button cancel2) {
		//Method that handles cancel
		cancel2.setOnAction(e->{
			setScene(new BrowseFileControl(stage));
		});
	}
	/*
	 * Getters and Setters
	 */
	public Button getCompress() {
		return compress;
	}

	public void setCompress(Button compress) {
		this.compress = compress;
	}

	public Button getDecompress() {
		return decompress;
	}

	public void setDecompress(Button decompress) {
		this.decompress = decompress;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}

	public DecompressControl getScene2() {
		return scene2;
	}

	public void setScene2(DecompressControl scene2) {
		this.scene2 = scene2;
	}

	public CompressControl getScene1() {
		return scene1;
	}

	public void setScene1(CompressControl scene1) {
		this.scene1 = scene1;
	}

	public BrowseFileControl getScene() {
		return scene;
	}

	public void setScene(BrowseFileControl scene) {
		this.scene = scene;
	}
}