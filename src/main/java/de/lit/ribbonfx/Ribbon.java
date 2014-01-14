package de.lit.ribbonfx;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Region;
import de.lit.ribbonfx.presentation.container.ContainerView;

public class Ribbon extends Region {

	TabPane tabPane;
	ObjectProperty<Action> actionEvent;

	/**
	 * Hidden constructor
	 */
	Ribbon() {
		setBackground(new Background((BackgroundFill) null));
		TabPane ribbon = (TabPane) new ContainerView().getView();
		this.tabPane = ribbon;
		getChildren().add(this.tabPane);
		this.tabPane.prefWidthProperty().bind(widthProperty());
		this.tabPane.prefHeightProperty().bind(heightProperty());

		this.actionEvent = new SimpleObjectProperty<Action>();
	}

	public ReadOnlyObjectProperty<Action> actionEvent() {
		return this.actionEvent;
	}

	TabPane getTabPane() {
		return this.tabPane;
	}

}
