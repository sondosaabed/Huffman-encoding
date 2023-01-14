package huffman.presentation;

import java.util.ArrayList;

import huffman.application.Code;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
 * Create a scene that shows the table of Huffman tree encodings
 */
public class ShowTableScene {
	//Fields
	private Stage stage;
	private GridPane pane;
	private Label message;
	private Button cancel;
	private ArrayList<Code> codes1;

	public ShowTableScene(String[] codes) {
		initialize(codes);
	}

	@SuppressWarnings("unchecked")
	private void initialize(String[] codes) {
		BackgroundFill c1 = new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(c1);
		codes1 = new ArrayList<>();

		pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(100, 100, 100, 100));
		pane.setHgap(15);
		pane.setVgap(15);
		pane.setBackground(background);

		Image img = new Image("images/icon.png");
		ImageView v = new ImageView(img);
		v.setFitWidth(50);
		v.setFitHeight(50);

		Button logo = new Button();
		logo.setPrefSize(50, 50);
		logo.setGraphic(v);
		logo.setStyle("-fx-border-color: transparent;-fx-border-width: 0;-fx-background-radius: 0;-fx-background-color: transparent;");
		GridPane.setHalignment(logo, HPos.CENTER);
		pane.add(logo, 0, 0);
		
		message=new Label("The generated Huffman encodings");
		message.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 20));
		message.setTextFill(Color.BLACK);
		pane.add(message, 0, 1);

		//User button to exit
		cancel = new Button("Cancel");
		cancel.setFont(Font.font("Lucida Sans Unicode", FontWeight.BOLD, FontPosture.REGULAR, 16));
		cancel.setPrefSize(80, 20);
		cancel.setTextFill(Color.WHITE);
		GridPane.setHalignment(cancel,HPos.CENTER);
		cancel.setStyle("-fx-background-radius: 18, 7;-fx-background-color:#4C91D4;");
		pane.add(cancel,0,3); 

		for (int i = 0; i < codes.length; i++) {
			if(codes[i]!=null) {
				Code code = new Code((char)codes[i].charAt(0),codes[i].substring(3));
				codes1.add(code);		
			}
		}
        // Create a table view and add encodings
        TableView<Code> table = new TableView<>();
        ObservableList<Code> data = FXCollections.observableArrayList(codes1);
        table.setItems(data);
        TableColumn<Code, Character> firstNameColumn = new TableColumn<>("Charachter");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("c"));
        TableColumn<Code, String> lastNameColumn = new TableColumn<>("Encoding");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        table.getColumns().addAll(firstNameColumn, lastNameColumn);
        table.setStyle("-fx-font-size: 14pt; -fx-font-family: 'Lucida Sans Unicode';");
        table.setPrefSize(400, 400);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setCenterShape(true);
        pane.add(table, 0, 2);

		Scene scene = new Scene(pane);
		stage=new Stage();
		stage.setScene(scene);
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

	public ArrayList<Code> getCodes1() {
		return codes1;
	}

	public void setCodes1(ArrayList<Code> codes1) {
		this.codes1 = codes1;
	}
}