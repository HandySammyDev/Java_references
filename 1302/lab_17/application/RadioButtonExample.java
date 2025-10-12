package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class RadioButtonExample extends Application {
	
	protected TextArea txaMessage;
	protected RadioButton rbDineIn, rbTakeOut, rbDelivery;
	protected ToggleGroup tGrpDiningChoice;
	
	private class ProcessEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			RadioButton rad = (RadioButton)tGrpDiningChoice.getSelectedToggle();
			String choice = rad.getText();
			String message = "";
			switch(choice) {
				case "Dine In": message = "Glad you are dining in with us";
					break;
				case "Take Out": message = "Meet you at the window";
					break;
				case "Delivery": message = "We will have it there shortly";
			}
			txaMessage.setText(message);
		}
	}

	@Override
	public void start(Stage primaryStage) {
		GridPane grdRootPane = buildGui();
		Scene scene = new Scene(grdRootPane,400,225);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("RadioButton Example");
		primaryStage.show();
	}
	
	private GridPane buildGui() {
		GridPane grid = new GridPane();
	
		grid.add(buildDiningChoice(), 0, 0);
	
	    txaMessage = new TextArea();
	    txaMessage.setEditable(false);
	    txaMessage.setPrefColumnCount(15);
	    txaMessage.setPrefRowCount(3);
	    grid.add(txaMessage, 1, 0);
		
	    return grid;				
	}
	
	private Pane buildDiningChoice() {
		tGrpDiningChoice = new ToggleGroup();
		rbDineIn = new RadioButton("Dine In");
		rbDineIn.setSelected(true);
		rbDineIn.setToggleGroup(tGrpDiningChoice);
		rbTakeOut = new RadioButton("Take Out");
		rbTakeOut.setToggleGroup(tGrpDiningChoice);
		rbDelivery = new RadioButton("Delivery");
		rbDelivery.setToggleGroup(tGrpDiningChoice);
	
		Button btnProcess = new Button("Process");
		btnProcess.setOnAction(new ProcessEventHandler());
	
		VBox vbxDiningChoice = new VBox();
		vbxDiningChoice.getStyleClass().add("h_or_v_box");			
		vbxDiningChoice.getChildren().addAll(rbDineIn,rbTakeOut,rbDelivery,btnProcess);
	
		return vbxDiningChoice;
	}

	
	public static void main(String[] args) {
		launch(args);
	}
}
