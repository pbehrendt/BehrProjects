module module6 {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires junit;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
}
