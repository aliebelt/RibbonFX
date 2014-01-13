package de.lit.ribbonfx;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import de.lit.ribbonfx.presentation.ribbontoolbar.RibbonToolBarView;

/**
 * @author aliebelt
 */
public class RibbonBuilder {

	Ribbon ribbon;

	/**
	 * Hidden constructor
	 */
	RibbonBuilder() {
		this.ribbon = new Ribbon();
	}

	public static RibbonBuilder create() {
		return new RibbonBuilder();
	}

	public RibbonBuilder applicationTab(RibbonAppTab applicationTab) {
		// TODO
		return this;
	}

	public RibbonBuilder tabs(RibbonTab... tabs) {
		for (RibbonTab iRibbonTab : tabs) {
			// Initialize Tab
			Tab iTab = new Tab();
			iTab.setClosable(false);
			RibbonToolBarView ribbonToolBarView = new RibbonToolBarView();
			iTab.setContent(ribbonToolBarView.getView());
			// Customize Tag
			iTab.textProperty().bind(iRibbonTab.title());
			// Add Tab
			this.ribbon.getRibbon().getTabs().add(iTab);
		}
		return this;
	}

	public TabPane build() {
		return this.ribbon.getRibbon();
	}

}
