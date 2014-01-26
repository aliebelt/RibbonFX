package de.lit.ribbonfx;

import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Region;
import javafx.scene.paint.Paint;
import de.lit.ribbonfx.presentation.container.ContainerPresenter;
import de.lit.ribbonfx.presentation.container.ContainerView;

public class Ribbon extends Region {

	TabPane tabPane;
	ContainerPresenter tabPanePresenter;

	/**
	 * Hidden constructor
	 */
	public Ribbon() {
		setBackground(new Background((BackgroundFill) null));
		ContainerView tabPaneView = new ContainerView();
		this.tabPane = (TabPane) tabPaneView.getView();
		this.tabPanePresenter = (ContainerPresenter) tabPaneView.getPresenter();

		getChildren().add(this.tabPane);
		this.tabPane.prefWidthProperty().bind(widthProperty());
		this.tabPane.prefHeightProperty().bind(heightProperty());
	}

	public void setAccent(Paint accent) {
		this.tabPanePresenter.setAccent(accent);
	}

	public TabPane getTabPane() {
		return this.tabPane;
	}

}
