package de.lit.ribbonfx;

import javafx.scene.control.Control;
import javafx.scene.control.Tab;
import de.lit.ribbonfx.presentation.ribbontabcontent.RibbonTabContentView;

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
			iTab.setId("ribbonTab");
			RibbonTabContentView ribbonToolBarView = new RibbonTabContentView();
			iTab.setContent(ribbonToolBarView.getView());
			// Customize Tag
			iTab.textProperty().bind(iRibbonTab.title());
			// Add Tab
			this.ribbon.getRibbon().getTabs().add(iTab);
		}
		return this;
	}

	public Control build() {
		return this.ribbon.getRibbon();
	}

}
