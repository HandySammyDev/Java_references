module HW_5a {
	requires javafx.controls;
	requires javafx.graphics;
	requires martianmanager;
	requires javafx.base;
	
	opens application to javafx.graphics, javafx.fxml;
}
