package de.lit.ribbonfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import org.controlsfx.dialog.Dialogs;

import de.lit.ribbonfx.actions.ButtonAction;
import de.lit.ribbonfx.builder.AppTabBuilder;
import de.lit.ribbonfx.builder.FooterBuilder;
import de.lit.ribbonfx.builder.GroupBuilder;
import de.lit.ribbonfx.builder.RibbonBuilder;
import de.lit.ribbonfx.builder.SimpleButtonBuilder;
import de.lit.ribbonfx.builder.SimpleFooterButtonBuilder;
import de.lit.ribbonfx.builder.SubSelectionBuilder;
import de.lit.ribbonfx.builder.SubSelectorBuilder;
import de.lit.ribbonfx.builder.SubSelectorButtonBuilder;
import de.lit.ribbonfx.builder.TabBuilder;
import de.lit.ribbonfx.model.AppTabData;
import de.lit.ribbonfx.model.CommonTabData;
import de.lit.ribbonfx.model.FooterData;
import de.lit.ribbonfx.model.GroupData;
import de.lit.ribbonfx.model.SimpleButtonData;
import de.lit.ribbonfx.model.SimpleFooterButtonData;
import de.lit.ribbonfx.model.SubSelectorButtonData;
import de.lit.ribbonfx.model.TabData;

public class RibbonRunTest extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		SubSelectorButtonData subSelectorTopButtonData1 = SubSelectorButtonBuilder.create().image(new Image("/images/save.png")).text("Speichern").build();
		CommonTabData subSelectionData1 = SubSelectionBuilder.create().title("Informationen").content(new Label("TODO 1")).build();
		CommonTabData subSelectionData2 = SubSelectionBuilder.create().title("Zuletzt\nverwendet").content(new Label("TODO 2")).build();
		SubSelectorButtonData subSelectorBottomButtonData1 = SubSelectorButtonBuilder.create().text("Optionen").build();
		SubSelector appTabSubSelector = SubSelectorBuilder.create().accent(Color.RED).topButtons(subSelectorTopButtonData1)
				.subSelections(subSelectionData1, subSelectionData2).bottomButtons(subSelectorBottomButtonData1).build();
		AppTabData appTab = AppTabBuilder.create().title("Datei").content(appTabSubSelector).build();
		GroupData groupData11 = GroupBuilder.create().title("Zwischenablage").build();
		GroupData groupData12 = GroupBuilder.create().title("Schriftart").build();
		Label labelTab1 = new Label("Content of Tab 1");
		SimpleFooterButtonData simpleFooterButtonData1 = SimpleFooterButtonBuilder.create().text("Seite: 1 von 1").build();
		SimpleFooterButtonData simpleFooterButtonData2 = SimpleFooterButtonBuilder.create().image(new Image("/images/no-macro-recording.png")).text("Macro")
				.build();
		SimpleFooterButtonData simpleFooterButtonData3 = SimpleFooterButtonBuilder.create().image(new Image("/images/no-macro-recording.png")).build();
		FooterData footer = FooterBuilder.create().leftButtons(simpleFooterButtonData1, simpleFooterButtonData2).rightButtons(simpleFooterButtonData3).build();
		TabData tab1 = TabBuilder.create().title("Start").groups(groupData11, groupData12).content(labelTab1).footer(footer).build();
		GroupData groupData21 = GroupBuilder.create().title("Tabellen").build();
		GroupData groupData22 = GroupBuilder.create().title("Illustrationen").build();
		GroupData groupData23 = GroupBuilder.create().title("Diagramme").build();
		GroupData groupData24 = GroupBuilder.create().title("Sparklines").build();
		SimpleButtonData simpleButtonData251 = SimpleButtonBuilder.create().image(new Image("/images/data-cutting.png")).text("Datenschn.").build();
		GroupData groupData25 = GroupBuilder.create().title("Filter").buttons(simpleButtonData251).build();
		Label labelTab23 = new Label("Common content of Tab 2 and 3");
		TabData tab2 = TabBuilder.create().title("Einfügen").groups(groupData21, groupData22, groupData23, groupData24, groupData25).content(labelTab23)
				.footer(footer).build();
		TabData tab3 = TabBuilder.create().title("Seitenlayout").content(labelTab23).footer(footer).build();
		Ribbon ribbon = RibbonBuilder.create().appTab(appTab).tabs(tab1, tab2, tab3).build();

		ribbon.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				ButtonAction buttonAction = (ButtonAction) event;
				if (simpleButtonData251.equals(buttonAction.getButtonData())) {
					Dialogs.create().title("ButtonAction").message("Button \"" + simpleButtonData251.text().get() + "\" fired...").showInformation();
				}
			}
		});

		primaryStage.setScene(new Scene(ribbon, 650, 350, Color.TRANSPARENT));
		primaryStage.initStyle(StageStyle.UNIFIED);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch((String[]) null);
	}

}
