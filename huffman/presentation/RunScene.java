package huffman.presentation;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
/*
 * Create the Scene in which shows the options of what to do with the file
 */
public class RunScene {
	//feilds
	private GridPane pane;
	private Label label;
	private Image img;
	private Image img1;
	private Button compress;
	private Button decompress;
	private Button cancel;
	
	public RunScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		setPane(new GridPane());
		pane.setPadding( new Insets(40,150,40,150)); 
	    pane.setAlignment(Pos.CENTER); 
		pane.setHgap(5);
		pane.setVgap(5); 
		BackgroundFill bGroundb1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background bGround1 = new Background(bGroundb1);
		pane.setBackground(bGround1); 
		
		setLabel(new Label("What do you want to do with your file?"));
		label.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(label, 0,0);
		
		setImg(new Image("images/compress.png"));
    	ImageView v0=new ImageView(img);
    	v0.setFitWidth(250);
    	v0.setFitHeight(250);
    	
		setCompress(new Button("")); 
		compress.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		compress.setStyle("-fx-background-color: transparent;");
		compress.setPrefSize(250, 250); 
		compress.setGraphic(v0);
		pane.add(compress, 0,1);
		
    	setImg1(new Image("images/decompress.png"));
    	ImageView v1=new ImageView(img1);
    	v1.setFitWidth(250);
    	v1.setFitHeight(250);

		setDecompress(new Button()); 
		decompress.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		decompress.setGraphic(v1);
		decompress.setStyle("-fx-background-color: transparent;");
		decompress.setPrefSize(250, 250); 
		pane.add(decompress , 1,1);

		//User button to exit
		cancel = new Button("Back");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		cancel.setPrefSize(80, 20);
		cancel.setTextFill(Color.WHITE);
		GridPane.setHalignment(cancel,HPos.RIGHT);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#4C91D4;");
		pane.add(cancel,1,0); 

		//Scene setting
    	stage.setTitle("Choices of Huffman");
		stage.getIcons().add(new Image("images/icon.png"));
		stage.setScene(new Scene(pane));  
    	stage.show(); 
	}
	/*
	 * Getters and Setters
	 */
	private void setCompress(Button button) {
		this.compress=button;
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

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public Button getDecompress() {
		return decompress;
	}

	public void setDecompress(Button decompress) {
		this.decompress = decompress;
	}
	
	public Image getImg1() {
		return img1;
	}

	public void setImg1(Image img1) {
		this.img1 = img1;
	}

	public Button getCompress() {
		return compress;
	}

	public Button getCancel() {
		return cancel;
	}

	public void setCancel(Button cancel) {
		this.cancel = cancel;
	}
}