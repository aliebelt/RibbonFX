package de.lit.ribbonfx;

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

}
