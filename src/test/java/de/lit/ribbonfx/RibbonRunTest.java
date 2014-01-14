package de.lit.ribbonfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RibbonRunTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		TabData ribbonTab1 = RibbonTabBuilder.create().title("Start").build();
		TabData ribbonTab2 = RibbonTabBuilder.create().title("Einfügen").build();
		Control ribbon = RibbonBuilder.create().tabs(ribbonTab1, ribbonTab2).build();

		primaryStage.setScene(new Scene(ribbon, 650, 350, Color.TRANSPARENT));
		primaryStage.initStyle(StageStyle.UNIFIED);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch((String[]) null);
	}

}
