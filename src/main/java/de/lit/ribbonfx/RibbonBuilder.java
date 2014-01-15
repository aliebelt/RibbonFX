package de.lit.ribbonfx;

import javafx.scene.control.Tab;
import de.lit.ribbonfx.presentation.tabcontent.TabContentView;

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

	public RibbonBuilder applicationTab(AppTabData applicationTab) {
		// TODO
		return this;
	}

	public RibbonBuilder tabs(TabData... tabs) {
		for (TabData iRibbonTab : tabs) {
			// Initialize Tab
			Tab iTab = new Tab();
			iTab.setClosable(false);
			iTab.setId("ribbonTab");
			TabContentView ribbonToolBarView = new TabContentView();
			iTab.setContent(ribbonToolBarView.getView());
			// Customize Tag
			iTab.textProperty().bind(iRibbonTab.title());
			// Add Tab
			this.ribbon.getTabPane().getTabs().add(iTab);
		}
		return this;
	}

	public Ribbon build() {
		return this.ribbon;
	}

}
