package de.lit.ribbonfx.builder;

import de.lit.ribbonfx.model.AbstractTabData;
import javafx.scene.Node;

/**
 * @author aliebelt
 */
public abstract class AbstractTabBuilder<T> {

	protected AbstractTabData tabData;

	@SuppressWarnings("unchecked")
	public T title(String title) {
		this.tabData.title().set(title);
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	public T disabled(boolean disabled) {
		this.tabData.disabled().set(disabled);
		return (T) this;
	}

	@SuppressWarnings("unchecked")
	public T content(Node content) {
		this.tabData.content().set(content);
		return (T) this;
	}

}
