package de.lit.ribbonfx.builder;

import de.lit.ribbonfx.model.GroupData;
import de.lit.ribbonfx.model.TabData;

/**
 * @author aliebelt
 */
public class TabBuilder extends AbstractTabBuilder<TabBuilder> {

	/**
	 * Hidden constructor
	 */
	TabBuilder() {
		super.tabData = new TabData();
	}

	public static TabBuilder create() {
		return new TabBuilder();
	}

	public TabBuilder groups(GroupData... groups) {
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
