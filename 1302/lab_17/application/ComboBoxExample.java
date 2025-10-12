package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class ComboBoxExample extends Application {
	
	protected TextField txfBalance;
	protected TextArea txaMessage;	
	protected ComboBox<String> cmbInterestRate;	
	
	private class CalculateInterestEventHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			
			String strIntRate = cmbInterestRate.getValue();
	     		// Remove "%" from the end
			strIntRate = strIntRate.substring(0,strIntRate.length()-1);
			
			double intRate = (Double.parseDouble(strIntRate))/100.0;
			double balance = Double.parseDouble(txfBalance.getText());
			double interest = balance*intRate;
			double newBalance = balance + interest;
	    		String message = String.format("Old balance=$%,.2f\n" + 
			    "Interest=$%,.2f\nNewBalance=$%,.2f", balance, interest, newBalance);
	        txaMessage.setText(message);
		}

	}
	
	@Override
	public void start(Stage primaryStage) {
		Pane root = buildGui();
		Scene scene = new Scene(root,400, 350);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("ComboBox Example");
		primaryStage.show();
	}
	
	private Pane buildGui() {
		GridPane grid = new GridPane();
		grid.add(new Label("Interest Rate"), 0, 0);
		cmbInterestRate = new ComboBox<>();
		cmbInterestRate.getItems().addAll("3.0%", "3.5%", "4.0%", "4.5%", "5.0%");
		cmbInterestRate.setValue("4.0%");
		grid.add(cmbInterestRate, 1, 0);
		grid.add(new Label("Balance"), 0, 1);
		txfBalance = new TextField();
		grid.add(txfBalance, 1, 1);
	
		Button btnCalcInterest = new Button("Calculate Interest");
		btnCalcInterest.setOnAction(new CalculateInterestEventHandler());
		grid.add(btnCalcInterest, 1, 3);
	
	    txaMessage = new TextArea();
	    txaMessage.setPrefColumnCount(15);
	    txaMessage.setPrefRowCount(6);
	    grid.add(txaMessage, 1, 4);
		
	    return grid;				
	}

	public static void main(String[] args) {
		launch(args);
	}
}
