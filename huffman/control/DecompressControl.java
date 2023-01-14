package huffman.control;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import huffman.application.HuffmanDecode;
import huffman.presentation.DecompressScene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/*
 * Create a controller class that shows the ready decompressed file
 */
public class DecompressControl {
	//feilds
	private DecompressScene DecompressScene;
	private BrowseFileControl scene;
	private BrowseFileControl scene1;
	private Button download;
	private Button main;

	public DecompressControl(Stage stage,File file) throws IOException {
		initialize(stage,file);
	}

	private void initialize(Stage stage,File file) throws IOException {
		DecompressScene = new DecompressScene(stage);
		setDownload(this.DecompressScene.getBtdown());
		setMain(DecompressScene.getMain());
		HuffmanDecode decoder = new HuffmanDecode(file.getPath());
		decoder.decompress(file.getPath(), "C:\\Users\\SS\\Downloads\\new.txt");
		handle_download(download,file);
		handle_main(main, stage);
	}

	private void handle_download(Button download, File file) {
		// Method to download the decompressed Huffman file
		download.setOnAction(e -> {
			try {
				// Set the base file path and name
				String basePath = "C:/Users/SS/Downloads/new.huff";
				// Check if the file already exists
				Path filePath = Paths.get(basePath);
				int i = 1;
				while (Files.exists(filePath)) {
					// If the file already exists, append a number to the file name
					String newPath = basePath.substring(0, basePath.lastIndexOf('.')) + "(" + i + ")" + basePath.substring(basePath.lastIndexOf('.'));
					filePath = Paths.get(newPath);
					i++;
				}
				// Copy the file to the local file system
				Files.copy(file.toPath(), filePath);

				AlertBoxCtrl a = new AlertBoxCtrl("Find your file on dowloads","Successfully downloaded");
				a.show();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
	}
	
	private void handle_main(Button main, Stage stage) {
		//Method to hanlde back to main
		main.setOnAction(j -> {
			setScene(new BrowseFileControl(stage));
		});
	}
	/*
	 * Getters and Setters
	 */
	public Button getDownload() {
		return download;
	}

	public void setDownload(Button download) {
		this.download = download;
	}

	public BrowseFileControl getScene1() {
		return scene1;
	}

	public void setScene1(BrowseFileControl scene1) {
		this.scene1 = scene1;
	}

	public Button getMain() {
		return main;
	}

	public void setMain(Button main) {
		this.main = main;
	}

	public BrowseFileControl getScene() {
		return scene;
	}

	public void setScene(BrowseFileControl scene) {
		this.scene = scene;
	}
}