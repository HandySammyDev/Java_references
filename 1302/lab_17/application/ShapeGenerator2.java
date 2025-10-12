package application;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class ShapeGenerator2 extends Application {
	
	protected ArrayList<GeometricObject> shapes = new ArrayList<>();
	protected TextField txfParameters;
	protected TextArea txaMessage;
	protected Label lbl, lblExample, lblExample2;
	protected Button btnCreateShape, btnShowAll, btnReset;	
	protected ToggleGroup tGrpShapeChoice = new ToggleGroup();

	@Override
	public void start(Stage primaryStage) {
		Pane grdRootPane = buildGui();
		Scene scene = new Scene(grdRootPane,500, 375);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());		
		primaryStage.setScene(scene);
		primaryStage.setTitle("Shape Generator");
		primaryStage.show();
	}
	
	private Pane buildGui() {
		GridPane root = new GridPane();
		root.add(buildDataEntryRow(), 0, 0);
		root.add(buildButtonRow(), 0, 1);
		root.add(buildDisplayRow(), 0, 2);
        return root;				
	}
	
	private Pane buildDataEntryRow() {
		HBox hBox = new HBox();
		hBox.getStyleClass().add("h_or_v_box");			
		hBox.getChildren().addAll(
				buildShapeChoice(),
				buildShapeParameterEntry(), 
				buildExample());
		return hBox;
	}
	private Pane buildShapeChoice() {
		// Put shape choice radio buttons in a VBox
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");			
	
		Label lblSelectShape = new Label("Select Shape");
		vBox.getChildren().add(lblSelectShape);

		RadioButton rbTriangle = new RadioButton("Triangle");
		rbTriangle.setToggleGroup(tGrpShapeChoice);
		rbTriangle.setSelected(true);
		vBox.getChildren().add(rbTriangle);

		RadioButton rbRectangle = new RadioButton("Rectangle");
		rbRectangle.setToggleGroup(tGrpShapeChoice);
		vBox.getChildren().add(rbRectangle);
		 
		RadioButton rbCircle = new RadioButton("Circle");
		rbCircle.setToggleGroup(tGrpShapeChoice);		
		vBox.getChildren().add(rbCircle);
		return vBox;
	}
	
	private Pane buildShapeParameterEntry() {
		// Put shape choice radio buttons in a VBox
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		
		String msg = "Enter shape parameters\nseparated by a space";
		lbl = new Label(msg);
		txfParameters = new TextField("2.4 3.5 4.6");
		vBox.getChildren().addAll(lbl, txfParameters);
		return vBox;
	}

	private Pane buildExample() {
		// Put shape choice radio buttons in a VBox
		VBox vBox = new VBox();
		vBox.getStyleClass().add("h_or_v_box");
		
		String msg = "Examples";
		
		String msg2 = "Circle: 3.4\n" +
		             "Rectangle: 4.0 5.5\n" + 
				     "Triangle: 2.0 3.0 2.0";
		
		lblExample = new Label(msg);
		lblExample.setStyle("-fx-font-weight: bold");
		lblExample2 = new Label(msg2);
		vBox.getChildren().addAll(lblExample, lblExample2);
		return vBox;
	}

	private Pane buildButtonRow() {
		HBox hBox = new HBox();
		hBox.getStyleClass().add("h_or_v_box");
		hBox.setAlignment(Pos.CENTER);
		btnCreateShape = new Button("Create Shape");
		hBox.getChildren().add(btnCreateShape);
		btnShowAll = new Button("Show All");
		hBox.getChildren().add(btnShowAll);
		btnReset = new Button("Show All");
		hBox.getChildren().add(btnReset);
		
        // Create button event handlers
        CreateShapeEventHandler btnEventHandler = new CreateShapeEventHandler();
        btnCreateShape.setOnAction(btnEventHandler );

        ShowAllEventHandler btnShowAllEventHandler = new ShowAllEventHandler();
        btnShowAll.setOnAction(btnShowAllEventHandler );

        btnReset.setOnAction(new ResetEventHandler() );

		return hBox;
	}

	private Pane buildDisplayRow() {
		// Put message area in HBox. This is third row of gui.
		HBox hBox = new HBox();
		hBox.getStyleClass().add("h_or_v_box");
        txaMessage = new TextArea();
        txaMessage.setEditable(false);
        //txaMessage.setPrefColumnCount(22);
        txaMessage.setPrefRowCount(6);
        hBox.getChildren().add(txaMessage);
        return hBox;
	}

	private class CreateShapeEventHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			RadioButton rad = (RadioButton)tGrpShapeChoice.getSelectedToggle();
         	String strShape = rad.getText();
         	GeometricObject shape = null;
			
			String input = txfParameters.getText();
			
			String[] parameters = input.split("[,\\s]+");
         	
         	switch( strShape ) {
	         	case "Triangle":
	         		System.out.println("Creating a Triangle");
	         		double[] sides = new double[3];
	         		int i=0;
	         		for(String p : parameters) {
	         			sides[i++] = Double.parseDouble(p);
	         		}
	            	shape = new Triangle(sides[0], sides[1], sides[2]);
	         		break;
	         	case "Rectangle":
	         		System.out.println("Creating a Rectangle");
	            	double width = Double.parseDouble(parameters[0]);
	            	double height = Double.parseDouble(parameters[1]);
	            	shape = new Rectangle(width, height);
	        		break;
	         	case "Circle":
	         		System.out.println("Creating a Circle");
	            	double radius = Double.parseDouble(parameters[0]);
	            	shape = new Circle(radius);
	         		break;
	         	}
         // Add to collection
         	shapes.add(shape);

        	// Build message to display
        	StringBuilder message = new StringBuilder();
        	message.append("Shape:\n");
        	message.append(shape.toString() + "\n");
        	String temp = String.format("%15s = %4.1f\n", "Area", shape.getArea());
        	message.append(temp);
        	temp = String.format("%12s = %4.1f\n", "Perimeter", shape.getPerimeter());
        	message.append(temp);

        	// Put message in display area
            txaMessage.setText(message.toString());
            // Erase fields
            txfParameters.setText(null);
		}
    	
    }
    
    private class ShowAllEventHandler implements EventHandler<ActionEvent> {
 		@Override
 		public void handle(ActionEvent event) {
 			String msg = "All Shapes:\n";

 			int i=1;
 			for(GeometricObject shape : shapes) {
 				msg += String.format("%4d. %s\n", i++, shape);
 			}
 			txaMessage.setText(msg);
 			// Erase fields
 			txfParameters.setText(null);

 		}
     }

    private class ResetEventHandler implements EventHandler<ActionEvent> {
  		@Override
  		public void handle(ActionEvent event) {
  			shapes.clear();
  			txaMessage.setText("All shapes have been removed");
  		}
      }

	public static void main(String[] args) {
		launch(args);
	}
}
