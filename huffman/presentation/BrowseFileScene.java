package huffman.presentation;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
/*
 * Create a scene that lets the user browse through the files to chose one
 */
public class BrowseFileScene {
	//fields
    private GridPane pane;
	private Image img;//Background Image
    private Label label;//Greeting User
    private	Button run;//User button to run the program
    private Button browse;//User Button to browse file
	private Button cancel;
  		
    public BrowseFileScene(Stage stage) {
      initialize(stage);
    }
    
    //initialization of objects
    public void initialize(Stage stage) {
    	pane = new GridPane();
    	pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(80,80,80,80));
		pane.setHgap(10.5);
		pane.setVgap(10.5); 
		
		img = new Image("images/key.png");
		BackgroundImage bImg = new BackgroundImage(img,
				BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT);
		Background bGround = new Background(bImg);
		pane.setBackground(bGround); 
		
		label = new Label("			       Hello user, Browse your file...");
		label.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(label, 1,0);
		
		run = new Button("Run");
		run.setTextFill(Color.WHITE);
		run.setPrefSize(100, 30);
		run.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		run.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#4C91D4;");
		
		browse = new Button("Browse"); 
		browse.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#4C91D4;");
		browse.setTextFill(Color.WHITE);
		browse.setPrefSize(100, 30);
		browse.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(browse , 2,2);
		
		//User button to exit
		cancel = new Button("Cancel");
		cancel.setFont(Font.font(14)); 
		cancel.setPrefSize(100, 30);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#4C91D4;");
		cancel.setTextFill(Color.WHITE);
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(cancel,3,2); 
		
		//Create Scene
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setTitle("Huffman Encoding program");
		stage.getIcons().add(new Image("images/icon.png"));
		stage.show();
    }
    /*
     * Getters and Setters
     */
    public GridPane getPane() {
		return pane;
	}

	public void setPane(GridPane pane) {
		this.pane = pane;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public Label getLabel() {
		return label;
	}

	public void setLabel(Label label) {
		this.label = label;
	}

	public Button getRun() {
		return run;
	}

	public void setRun(Button run) {
		this.run = run;
	}

	public Button getBrowse() {
		return browse;
	}

	public void setBrowse(Button browse) {
		this.browse = browse;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
}
