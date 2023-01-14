package huffman.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import huffman.application.HuffmanEncode;
import huffman.application.HuffmanTree;
import huffman.presentation.CompressScene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
/*
 *	Create a Controller class for The ready compressed file  
 */
public class CompressControl {
	//Fields
	private CompressScene compressScene;
	private BrowseFileControl scene;
	private ShowTableControl scene1;
	private Button download;
	private Button main;
	private Button table;
	
	public CompressControl(Stage stage, File file ) {
		initialize(stage,file);
	}

	private void initialize(Stage stage, File file) {
		setCompressScene(new CompressScene(stage));
		setDownload(getCompressScene().getBtdown());
		setTable(getCompressScene().getTable());
		setMain(compressScene.getMain());
		
		int[] freq= null;
		try {
			freq = readFrequencies(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		HuffmanTree tree= new HuffmanTree(freq);

		handle_download(download, file,tree,freq);
		handle_main(stage, main);
		handle_table(tree.getCodes(), table);
	}

	/*
	 *  Read the specified file and count the frequency of all characters in the file 
	 *	and shrink then array
	 */
	private int[] readFrequencies(File file) throws IOException {
		int[] freqs = new int[256];
		try (InputStream input = new FileInputStream(file)) {
			int b;
			while ((b = input.read()) != -1) {
				freqs[b]++;
			}
		}

		// Count the number of non-zero frequency values
		int count = 0;
		for (int i = 0; i < freqs.length; i++) {
			if (freqs[i] > 0) {
				count++;
			}
		}

		// Create a new array of the appropriate size and copy the non-zero frequency values
		int[] shrunkFreqs = new int[count];
		int index = 0;
		for (int i = 0; i < freqs.length; i++) {
			if (freqs[i] > 0) {
				shrunkFreqs[index++] = freqs[i];
			}
		}

		return freqs;
	}
	
	private void handle_download(Button download, File file, HuffmanTree tree,int []frequencies) {
		// Method to download the compressed Huffman file
		download.setOnAction(e -> {
			try {
				// Set the base file path and name
				String basePath = "C:/Users/SS/Downloads/new.huffman";
				
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
				
				HuffmanEncode encoder = new HuffmanEncode(tree.getCodes());
				encoder.compress(file.getAbsolutePath(), filePath.toString(), tree.getCodes(),frequencies);

				AlertBoxCtrl a = new AlertBoxCtrl("Find your file on dowloads","Successfully downloaded");
				a.show();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		});
	}
	/*
	 * Handlers
	 */
	private void handle_main(Stage stage, Button main2) {
		//Method to handle the main
		main2.setOnAction(e->{
			setScene(new BrowseFileControl(stage));
		});
	}
	
	private void handle_table( String[] codes,Button button) {
		button.setOnAction(e->{
			setScene1(new ShowTableControl(codes));
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
	public CompressScene getCompressScene() {
		return compressScene;
	}
	public void setCompressScene(CompressScene compressScene) {
		this.compressScene = compressScene;
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
	public Button getTable() {
		return table;
	}
	public void setTable(Button table) {
		this.table = table;
	}
	public ShowTableControl getScene1() {
		return scene1;
	}
	public void setScene1(ShowTableControl scene1) {
		this.scene1 = scene1;
	}	
}