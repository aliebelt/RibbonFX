package de.lit.ribbonfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RibbonRunTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AppTabData appTab = RibbonAppTabBuilder.create().title("Datei").build();
		TabData tab1 = RibbonTabBuilder.create().title("Start").build();
		TabData tab2 = RibbonTabBuilder.create().title("Einfügen").build();
		Ribbon ribbon = RibbonBuilder.create().appTab(appTab).tabs(tab1, tab2).build();

		primaryStage.setScene(new Scene(ribbon, 650, 350, Color.TRANSPARENT));
		primaryStage.initStyle(StageStyle.UNIFIED);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch((String[]) null);
	}

}
