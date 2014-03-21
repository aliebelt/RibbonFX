package de.lit.ribbonfx.builder;

import javafx.scene.Node;
import de.lit.ribbonfx.model.SubSelectionData;

public class SubSelectionBuilder {

	SubSelectionData subSelectionData;

	/**
	 * Hidden constructor
	 */
	SubSelectionBuilder() {
		this.subSelectionData = new SubSelectionData();
	}

	public static SubSelectionBuilder create() {
		return new SubSelectionBuilder();
	}

	public SubSelectionBuilder title(String title) {
		this.subSelectionData.title().set(title);
		return this;
	}

	public SubSelectionBuilder disabled(boolean disabled) {
		this.subSelectionData.disabled().set(disabled);
		return this;
	}

	public SubSelectionBuilder content(Node content) {
		this.subSelectionData.content().set(content);
		return this;
	}

	public SubSelectionData build() {
		return this.subSelectionData;
	}

}
