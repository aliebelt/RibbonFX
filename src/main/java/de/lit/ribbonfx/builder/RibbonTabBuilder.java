package de.lit.ribbonfx.builder;

import de.lit.ribbonfx.model.GroupData;
import de.lit.ribbonfx.model.TabData;

/**
 * @author aliebelt
 */
public class RibbonTabBuilder extends AbstractTabBuilder<RibbonTabBuilder> {

	/**
	 * Hidden constructor
	 */
	RibbonTabBuilder() {
		super.tabData = new TabData();
	}

	public static RibbonTabBuilder create() {
		return new RibbonTabBuilder();
	}

	public RibbonTabBuilder groups(GroupData... groups) {
		getTabData().groupDataList().addAll(groups);
		return this;
	}

	public TabData build() {
		return getTabData();
	}

	private TabData getTabData() {
		return (TabData) super.tabData;
	}

}
