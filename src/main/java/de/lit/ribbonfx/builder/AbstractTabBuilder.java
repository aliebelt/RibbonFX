package de.lit.ribbonfx.builder;

import javafx.scene.Node;
import de.lit.ribbonfx.model.AbstractRibbonTabData;
import de.lit.ribbonfx.model.FooterData;

/**
 * @author aliebelt
 * @param <T>
 *            The type parameter.
 */
public abstract class AbstractTabBuilder<T> {

	protected AbstractRibbonTabData tabData;

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

	@SuppressWarnings("unchecked")
	public T footer(FooterData footer) {
		this.tabData.footer().set(footer);
		return (T) this;
	}

}
