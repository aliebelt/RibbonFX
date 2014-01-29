package de.lit.ribbonfx.builder;

import javafx.scene.image.Image;
import de.lit.ribbonfx.model.SimpleButtonData;

/**
 * @author aliebelt
 */
public class RibbonSimpleButtonBuilder {

	SimpleButtonData simpleButtonData;

	/**
	 * Hidden constructor
	 */
	RibbonSimpleButtonBuilder() {
		this.simpleButtonData = new SimpleButtonData();
	}

	public static RibbonSimpleButtonBuilder create() {
		return new RibbonSimpleButtonBuilder();
	}

	public RibbonSimpleButtonBuilder image(Image image) {
		this.simpleButtonData.image().set(image);
		return this;
	}

	public RibbonSimpleButtonBuilder text(String text) {
		this.simpleButtonData.text().set(text);
		return this;
	}

	public RibbonSimpleButtonBuilder disabled(boolean disabled) {
		this.simpleButtonData.disabled().set(disabled);
		return this;
	}

	public SimpleButtonData build() {
		return this.simpleButtonData;
	}

}
