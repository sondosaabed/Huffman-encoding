package huffman.control;
import javafx.stage.Stage;
/*
 * create main controller to show the first scene
 */
public class MainControl {
	//Attribute
	private Stage window;
	private BrowseFileControl BrowseFileControl;
	
	public void showBrowseScene(Stage stage) {
		this.window= stage;
		setBrowseFileControl(new BrowseFileControl(window));
	}
	/*
	 * Getters and setters
	 */
	public BrowseFileControl getBrowseFileControl() {
		return BrowseFileControl;
	}
	public void setBrowseFileControl(BrowseFileControl browseFileControl) {
		BrowseFileControl = browseFileControl;
	}
}