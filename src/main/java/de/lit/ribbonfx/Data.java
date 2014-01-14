package de.lit.ribbonfx;

import javafx.scene.control.TabPane;
import de.lit.ribbonfx.presentation.container.ContainerView;

public class Data {

	TabPane ribbon;

	/**
	 * Hidden constructor
	 */
	Data() {
		TabPane ribbon = (TabPane) new ContainerView().getView();
		this.ribbon = ribbon;
	}

	public TabPane getRibbon() {
		return this.ribbon;
	}

}
