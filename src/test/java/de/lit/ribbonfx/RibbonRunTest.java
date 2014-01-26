package de.lit.ribbonfx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import de.lit.ribbonfx.builder.RibbonAppTabBuilder;
import de.lit.ribbonfx.builder.RibbonBuilder;
import de.lit.ribbonfx.builder.RibbonGroupBuilder;
import de.lit.ribbonfx.builder.RibbonSimpleButtonBuilder;
import de.lit.ribbonfx.builder.RibbonTabBuilder;
import de.lit.ribbonfx.model.AppTabData;
import de.lit.ribbonfx.model.GroupData;
import de.lit.ribbonfx.model.SimpleButtonData;
import de.lit.ribbonfx.model.TabData;

public class RibbonRunTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		AppTabData appTab = RibbonAppTabBuilder.create().title("Datei").build();
		GroupData groupData11 = RibbonGroupBuilder.create().title("Zwischenablage").build();
		GroupData groupData12 = RibbonGroupBuilder.create().title("Schriftart").build();
		Label labelTab1 = new Label("Content of Tab 1");
		TabData tab1 = RibbonTabBuilder.create().title("Start").groups(groupData11, groupData12).content(labelTab1).build();
		GroupData groupData21 = RibbonGroupBuilder.create().title("Tabellen").build();
		GroupData groupData22 = RibbonGroupBuilder.create().title("Illustrationen").build();
		GroupData groupData23 = RibbonGroupBuilder.create().title("Diagramme").build();
		GroupData groupData24 = RibbonGroupBuilder.create().title("Sparklines").build();
		SimpleButtonData simpleButtonData251 = RibbonSimpleButtonBuilder.create().image(new Image(getClass().getResource("data-cutting.png").toExternalForm()))
				.text("Datenschn.").build();
		GroupData groupData25 = RibbonGroupBuilder.create().title("Filter").buttons(simpleButtonData251).build();
		Label labelTab23 = new Label("Common content of Tab 2 and 3");
		TabData tab2 = RibbonTabBuilder.create().title("Einfügen").groups(groupData21, groupData22, groupData23, groupData24, groupData25).content(labelTab23)
				.build();
		TabData tab3 = RibbonTabBuilder.create().title("Seitenlayout").content(labelTab23).build();
		Ribbon ribbon = RibbonBuilder.create().appTab(appTab).tabs(tab1, tab2, tab3).build();
		primaryStage.setScene(new Scene(ribbon, 650, 350, Color.TRANSPARENT));
		primaryStage.initStyle(StageStyle.UNIFIED);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch((String[]) null);
	}

}
