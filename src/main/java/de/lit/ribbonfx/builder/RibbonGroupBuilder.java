package de.lit.ribbonfx.builder;

import de.lit.ribbonfx.model.GroupData;

/**
 * @author aliebelt
 */
public class RibbonGroupBuilder {

	GroupData groupData;

	/**
	 * Hidden constructor
	 */
	RibbonGroupBuilder() {
		this.groupData = new GroupData();
	}

	public static RibbonGroupBuilder create() {
		return new RibbonGroupBuilder();
	}

	public RibbonGroupBuilder title(String title) {
		this.groupData.title().set(title);
		return this;
	}

	public GroupData build() {
		return this.groupData;
	}

}
