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
 * Create a scene in which shows after choosing to compress the file
 */
public class CompressScene {
	//Fields
	private GridPane pane;
	private Button btdown;
	private Button main;
	private Button table;

	public CompressScene(Stage stage) {
		initialize(stage);
	}

	private void initialize(Stage stage) {
		BackgroundFill bGroundb1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background bGround1 = new Background(bGroundb1);

		pane = new GridPane();
		pane.setBackground(bGround1); 
		pane.setPadding( new Insets( 110,130, 110,130 )); 
	    pane.setAlignment(Pos.CENTER); 
		pane.setHgap(10);
		pane.setVgap(10); 
		pane.setBackground(bGround1);
		
		Image img = new Image("images/icon.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(100);
		v.setFitHeight(100);

		Button logo = new Button();
		logo.setPrefSize(100, 100);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);
		
		//Greeting User
		Label label2 = new Label("Your compressed file is ready to download...");
		label2.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		pane.add(label2, 0,1);

		//User button to download file 
		btdown = new Button("Download File");
		btdown.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#4C91D4;");
		btdown.setTextFill(Color.WHITE);
		btdown.setPrefSize(190, 30);
		btdown.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		GridPane.setHalignment(btdown, HPos.CENTER);
		pane.add(btdown, 0, 2);  
		
		//User button to download file 
		table = new Button("Show encodings");
		table.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#4C91D4;");
		table.setTextFill(Color.WHITE);
		table.setPrefSize(190, 30);
		table.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		GridPane.setHalignment(table, HPos.CENTER);
		pane.add(table, 0, 3);  
		
		//User button to back to main file 
		main = new Button("Back to Main");
		main.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#4C91D4;");
		main.setTextFill(Color.WHITE);
		main.setPrefSize(190, 30);
		main.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		GridPane.setHalignment(main, HPos.CENTER);
		pane.add(main, 0, 4);  

		//Scene setting
		Scene scene2 = new Scene(pane); 		
		stage.setTitle("Compress your file");
		stage.getIcons().add(new Image("images/icon.png"));
		stage.setScene(scene2);  
		stage.show(); 
	}
	/*
	 * Getters and Setters
	 */
	public Button getMain() {
		return main;
	}
	public void setMain(Button main) {
		this.main = main;
	}
	public GridPane getPane() {
		return pane;
	}
	public void setPane(GridPane pane) {
		this.pane = pane;
	}
	public Button getBtdown() {
		return btdown;
	}
	public void setBtdown(Button btdown) {
		this.btdown = btdown;
	}
	public Button getTable() {
		return table;
	}
	public void setTable(Button table) {
		this.table = table;
	}
}