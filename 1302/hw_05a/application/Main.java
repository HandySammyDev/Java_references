package application;
	
import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import mm.GreenMartian;
import mm.Martian;
import mm.MartianManager;
import mm.RedMartian;
import mm.Teleporter;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	protected Pane hPaneCreateAndDisplay, paneCreate, paneDisplay, paneResults;
	protected Button btnCreate, btnResetAll, btnDisplay, btnTeleport;
	protected RadioButton rbCreateGreen, rbCreateRed, rbDisplayGreen, rbDisplayRed, rbDisplayAll, rbDisplaySorted;
	protected Label lbId, lbVolume, lbTenacity, lbDestination, lbResults;
	protected TextField txfId, txfVolume, txfTenacity, txfDestination;
	protected TextArea taResults;
	protected ToggleGroup tGrpCreateChoice, tGrpDisplayChoice;
	
	protected MartianManager mm = new MartianManager();
	
	private class CreateButtonEventHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			Martian m = null;
			String msg = "";
			
			if (rbCreateGreen.isSelected()) {
				if (!txfVolume.getText().equals("")) {
					m = new GreenMartian(getId(), getVolume());
				} 
				else {
					m = new GreenMartian(getId());
				}
			} 
			else if (rbCreateRed.isSelected()) {
				if (!txfVolume.getText().equals("")) {
					m = new RedMartian(getId(), getVolume(), getTenacity());
				} 
				else {
					m = new RedMartian(getId(), getTenacity());
				}
			}
			
			boolean b = mm.addMartian(m);
			if(!b) {
				msg += "***Martian not added. \nMartian with id=" + getId() + " already exists";
			}
			else {
				msg += "Martian created: \n" + m;
			}
			clearTextFields();
			taResults.setText(msg);
		}
	}
	
	private class ResetButtonEventHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			mm = new MartianManager();
		}
	}
	
	private class DisplayButtonEventHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			String msg = "";
			if(rbDisplayAll.isSelected()) {
				msg = "All Martians\n---------------\n";
				for(int i=0; i<mm.getNumMartians(); i++) {
					msg += mm.getMartianAt(i).toString() + "\n";
				}
			}
			
			if(rbDisplayGreen.isSelected()) {
				msg = "Green Martians\n---------------\n";
				for(int i=0; i<mm.getNumMartians(); i++) {
					Martian m = mm.getMartianAt(i);
					if(m instanceof GreenMartian gm) {
						msg += gm + "\n";
					}
				}
			}
			
			if(rbDisplayRed.isSelected()) {
				msg = "Red Martians\n---------------\n";
				for(int i=0; i<mm.getNumMartians(); i++) {
					Martian m = mm.getMartianAt(i);
					if(m instanceof RedMartian rm) {
						msg += rm + "\n";
					}
				}
			}
			
			if(rbDisplaySorted.isSelected()) {
				msg = "Sorted Martians\n---------------\n";
				
				ArrayList<Martian> am = mm.getSortedMartians();
				
				for(int i=0; i<am.size(); i++) {
					msg += am.get(i).toString() + "\n";
				}
			}
			taResults.setText(msg);
		}
	}
	
	private class TeleportButtonEventHandler implements EventHandler<ActionEvent>{

		@Override
		public void handle(ActionEvent e) {
			String msg = "Teleporting\n---------------\n";
			
			for(int i=0; i<mm.getNumMartians(); i++) {
				Martian m = mm.getMartianAt(i);
				if(m instanceof Teleporter) {
					if(!txfDestination.getText().equals("")) {
						String des = txfDestination.getText();
						msg += "id=" + m.getId() + " teleporting to " + des + "\n";
					}
					else {
						msg = "Enter a destination.";
					}
				}
			}
			
			taResults.setText(msg);
		}
	}
	
	@Override
	public void start(Stage primaryStage) {
	    try {
	    	HBox hbx = new HBox();
	    	hbx.getStyleClass().add("HBox");
	    	hbx.getChildren().addAll(buildCreate(), buildDisplay());
	        Scene scene = buildGui();
	        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Martian App");
	        primaryStage.show();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	private Scene buildGui() {
		VBox vbxGui = new VBox();
		
		HBox topHbx = new HBox();
		topHbx.getStyleClass().add("HBox");
		topHbx.getChildren().addAll(buildCreate(), buildDisplay());
    	
		vbxGui.getChildren().addAll(topHbx, buildLabel(), buildTextArea());
    	
        Scene scene = new Scene(vbxGui, 750, 400);
        
        return scene;
	}

	private Pane buildCreate() {
		// ToggleGroup
		tGrpCreateChoice = new ToggleGroup();
		
		//RadioButton
		rbCreateGreen = new RadioButton("Green");
		rbCreateGreen.setSelected(true);
		rbCreateGreen.setToggleGroup(tGrpCreateChoice);
		rbCreateRed = new RadioButton("Red");
		rbCreateRed.setSelected(true);
		rbCreateRed.setToggleGroup(tGrpCreateChoice);
		
	    // Buttons
	    btnCreate = new Button("Create");
	    btnCreate.setOnAction(new CreateButtonEventHandler());
	    btnResetAll = new Button("Reset All");
	    btnResetAll.setOnAction(new ResetButtonEventHandler());

	    // First HBox
	    HBox hbxCreate1 = new HBox(10);
	    hbxCreate1.getStyleClass().addAll("HBox");
	    hbxCreate1.getChildren().addAll(btnCreate, rbCreateGreen, rbCreateRed, btnResetAll);

	    // Labels
	    lbId = new Label("Id");
	    lbVolume = new Label("Volume");
	    lbTenacity = new Label("Tenacity");
	    
	    // TextFields
	    txfId = new TextField();
	    txfVolume = new TextField();
	    txfTenacity = new TextField();
	    txfId.setPrefColumnCount(5);
	    txfVolume.setPrefColumnCount(5);
	    txfTenacity.setPrefColumnCount(5);
	    
	    // Second HBox
	    HBox hbxCreate2 = new HBox(10);
	    hbxCreate2.getStyleClass().addAll("HBox");
	    hbxCreate2.getChildren().addAll(lbId, txfId, lbVolume, txfVolume, lbTenacity, txfTenacity);

	    // VBox that holds both HBoxes
	    VBox vbxCreate = new VBox(15);
	    vbxCreate.getStyleClass().add("VBox");
	    vbxCreate.getChildren().addAll(hbxCreate1, hbxCreate2);

	    return vbxCreate;
	}
	
	private Pane buildDisplay() {
		// Buttons
		btnDisplay = new Button("Display");
		btnDisplay.setOnAction(new DisplayButtonEventHandler());
		btnTeleport = new Button("Teleport");
		btnTeleport.setOnAction(new TeleportButtonEventHandler());
		
		// ToggleGroup
		tGrpDisplayChoice = new ToggleGroup();
		
		// RadioButton
		rbDisplayGreen = new RadioButton("Green");
		rbDisplayGreen.setSelected(true);
		rbDisplayGreen.setToggleGroup(tGrpDisplayChoice);
		rbDisplayRed = new RadioButton("Red");
		rbDisplayRed.setSelected(true);
		rbDisplayRed.setToggleGroup(tGrpDisplayChoice);
		rbDisplayAll = new RadioButton("All");
		rbDisplayAll.setSelected(true);
		rbDisplayAll.setToggleGroup(tGrpDisplayChoice);
		rbDisplaySorted = new RadioButton("Sorted");
		rbDisplaySorted.setSelected(true);
		rbDisplaySorted.setToggleGroup(tGrpDisplayChoice);

		// First HBox
	    HBox hbxCreate1 = new HBox(10);
	    hbxCreate1.getStyleClass().addAll("HBox");
	    hbxCreate1.getChildren().addAll(btnDisplay, rbDisplayGreen, rbDisplayRed, rbDisplayAll, rbDisplaySorted);
		
		// Label
		lbDestination = new Label("destination");
		
		// TextField
		txfDestination = new TextField();
		
		// Second HBox
	    HBox hbxCreate2 = new HBox(10);
	    hbxCreate2.getStyleClass().addAll("HBox");
	    hbxCreate2.getChildren().addAll(btnTeleport, lbDestination, txfDestination);
	    
	    // VBox that holds both HBoxes
	    VBox vbxCreate = new VBox(15);
	    vbxCreate.getStyleClass().add("VBox");
	    vbxCreate.getChildren().addAll(hbxCreate1, hbxCreate2);

	    return vbxCreate;
	}

	private Label buildLabel() {
	    lbResults = new Label("Results");
	    return lbResults;
	}

	private TextArea buildTextArea() {
		taResults = new TextArea();
		return taResults;
	}
	
	private int getId() {
		return Integer.parseInt(txfId.getText());
	}
	
	private int getVolume() {
		return Integer.parseInt(txfVolume.getText());
	}
	
	private int getTenacity() {
		return Integer.parseInt(txfTenacity.getText());
	}
	
	private void clearTextFields() {
		txfId.clear();
		txfVolume.clear();
		txfTenacity.clear();
		txfDestination.clear();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}