package de.lit.ribbonfx.builder;

import javafx.scene.image.Image;
import de.lit.ribbonfx.model.AbstractSimpleButtonData;

/**
 * @author a.liebelt
 */
public abstract class AbstractSimpleButtonBuilder<T> {

	AbstractSimpleButtonData simpleButtonData;

	@SuppressWarnings("unchecked")
	public T image(Image image) {
		this.simpleButtonData.image().set(image);
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	public T text(String text) {
		this.simpleButtonData.text().set(text);
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	public T disabled(boolean disabled) {
		this.simpleButtonData.disabled().set(disabled);
		return (T) this;
	}

}
