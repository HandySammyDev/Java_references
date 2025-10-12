package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
//import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


public class Main1 extends Application {
	
	protected Label lbl;
	protected TextField txfName;
	protected TextArea txaMessage;
	protected Button btnHelloWorld;
	
	private class HelloWorldButtonEventHandler
			implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e) {
			String name = txfName.getText();
			txaMessage.setText(name + ", Hello World!");
		}
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = buildGui();
			Scene scene = new Scene(root,300,250);
			primaryStage.setTitle("Hello World");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private Pane buildGui() {
		GridPane grid = new GridPane();
		grid.add(buildNameEntry(), 0, 0);

		btnHelloWorld = new Button("Hello World");
		btnHelloWorld.setOnAction(new HelloWorldButtonEventHandler());
		grid.add(btnHelloWorld, 0, 1);

		txaMessage = new TextArea();
		txaMessage.setPrefHeight(100);
		txaMessage.setPrefWidth(200);
		grid.add(txaMessage, 0, 2);

		return grid;
	}
	
	public Pane buildNameEntry() {
		HBox hBox = new HBox();
		lbl = new Label("Name");
		txfName = new TextField();
		hBox.getStyleClass().add("h_or_v_box");			
		hBox.getChildren().addAll(lbl, txfName);
		return hBox;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
