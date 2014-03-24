package de.lit.ribbonfx.builder;

import javafx.scene.Node;
import de.lit.ribbonfx.model.CommonTabData;

public class SubSelectionBuilder {

	CommonTabData subSelectionData;

	/**
	 * Hidden constructor
	 */
	SubSelectionBuilder() {
		this.subSelectionData = new CommonTabData();
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

	public CommonTabData build() {
		return this.subSelectionData;
	}

}
