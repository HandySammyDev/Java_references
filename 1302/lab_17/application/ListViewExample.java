package application;

import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ListViewExample extends Application {
	
	protected TextArea txaMessage;
	protected ListView<String> lvwInterests = new ListView<>();
	
	private class ProcessEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			String interests = "";
			List<String> allItems = lvwInterests.getSelectionModel().getSelectedItems();
			for(String interest : allItems) {
				interests += interest + ", ";
			}
			txaMessage.setText(interests);
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		GridPane grdRootPane = buildGui();
		Scene scene = new Scene(grdRootPane,320,350);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("ListBox Example");
		primaryStage.show();
	}
	
	private GridPane buildGui() {
		GridPane grid = new GridPane();
	
		grid.add(buildInterestsEntry(), 0, 0);
		
		Button btnProcess = new Button("Process");
		btnProcess.setOnAction(new ProcessEventHandler());
		grid.add(btnProcess, 0, 1);
	
	    txaMessage = new TextArea();
	    txaMessage.setEditable(false);
	    txaMessage.setPrefColumnCount(10);
	    txaMessage.setPrefRowCount(4);
	    txaMessage.setWrapText(true);
	    grid.add(txaMessage, 0, 2);
		
	    return grid;				
	}
	
	private Pane buildInterestsEntry() {
		lvwInterests.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		lvwInterests.getItems().addAll("Music", "Dance", "Disc Golf", "Theater", "Reading");
		lvwInterests.setPrefHeight(150);
		lvwInterests.setPrefWidth(120);
		HBox hBox = new HBox();
		hBox.getStyleClass().add("h_or_v_box");			
		hBox.getChildren().add(new Label("Interests\nSelect all that apply"));
		hBox.getChildren().add(lvwInterests);
		return hBox;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
