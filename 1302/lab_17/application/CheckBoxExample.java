package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class CheckBoxExample extends Application {
	
	protected CheckBox ckbBurger, ckbDrink, ckbFries;
	protected TextArea txaMessage;
	
	private class ProcessEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			double cost = 0.0;
			String order = "Order:\n";
			
			if(ckbBurger.isSelected()) {
				cost += 5.99;
				order += "Burger";
			}
			if(ckbDrink.isSelected()) {
				cost += 1.99;
				order += ", Drink";
			}
			if(ckbFries.isSelected()) {
				cost += 5.99;
				order += ", Fries";
			}
			String totCost = String.format("\nTotal: $%,.2f\n", cost);
			order += totCost;
			txaMessage.setText(order);
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
		GridPane grdRootPane = buildGui();
		Scene scene = new Scene(grdRootPane,275,225);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());		
		primaryStage.setScene(scene);
		primaryStage.setTitle("CheckBox Example");
		primaryStage.show();
	}
	
	private GridPane buildGui() {
		GridPane grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setPadding(new Insets(25, 25, 25, 25));
	
		grid.add(buildFoodSelection(), 0, 0);
	
		Button btnProcess = new Button("Process");
		btnProcess.setOnAction(new ProcessEventHandler());
		grid.add(btnProcess, 0, 1);
	
	    txaMessage = new TextArea();
	    txaMessage.setEditable(false);
	    txaMessage.setPrefColumnCount(10);
	    txaMessage.setPrefRowCount(4);
	    grid.add(txaMessage, 0, 2);
		
	    return grid;				
	}
	
	private Pane buildFoodSelection() {
		ckbBurger = new CheckBox("Burger");
		ckbDrink = new CheckBox("Drink");
		ckbFries = new CheckBox("Fries");
	
		HBox hbxFood = new HBox();
		hbxFood.getStyleClass().add("h_or_v_box");			
		hbxFood.getChildren().addAll(ckbBurger,ckbDrink,ckbFries);
	
		return hbxFood;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
