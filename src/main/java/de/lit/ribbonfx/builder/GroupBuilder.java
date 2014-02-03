package de.lit.ribbonfx.builder;

import de.lit.ribbonfx.model.ButtonData;
import de.lit.ribbonfx.model.GroupData;

/**
 * @author aliebelt
 */
public class GroupBuilder {

	GroupData groupData;

	/**
	 * Hidden constructor
	 */
	GroupBuilder() {
		this.groupData = new GroupData();
	}

	public static GroupBuilder create() {
		return new GroupBuilder();
	}

	public GroupBuilder title(String title) {
		this.groupData.title().set(title);
		return this;
	}

	public GroupBuilder buttons(ButtonData... buttons) {
		this.groupData.buttonDataList().addAll(buttons);
		return this;
	}

	public GroupData build() {
		return this.groupData;
	}

}
