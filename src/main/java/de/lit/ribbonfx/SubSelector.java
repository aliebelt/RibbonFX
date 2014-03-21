package de.lit.ribbonfx;

import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;
import de.lit.ribbonfx.presentation.subselector.SubSelectorPresenter;
import de.lit.ribbonfx.presentation.subselector.SubSelectorView;

public class SubSelector extends AnchorPane {

	TabPane subSelector;
	SubSelectorPresenter subSelectorPresenter;

	/**
	 * Hidden constructor
	 */
	public SubSelector() {
		setBackground(new Background((BackgroundFill) null));
		SubSelectorView subSelectorView = new SubSelectorView();
		this.subSelector = (TabPane) subSelectorView.getView();
		this.subSelectorPresenter = (SubSelectorPresenter) subSelectorView.getPresenter();

		getChildren().add(this.subSelector);
		AnchorPane.setBottomAnchor(this.subSelector, 0.0);
		AnchorPane.setLeftAnchor(this.subSelector, 0.0);
		AnchorPane.setRightAnchor(this.subSelector, 0.0);
		AnchorPane.setTopAnchor(this.subSelector, 0.0);
	}

	public void setAccent(Paint accent) {
		this.subSelectorPresenter.setAccent(accent);
	}

	public TabPane getTabPane() {
		return this.subSelector;
	}

}
