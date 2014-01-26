package de.lit.ribbonfx.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public class SimpleButtonData implements ButtonData {

	ObjectProperty<Image> image;
	StringProperty text;

	/**
	 * Hidden constructor
	 */
	public SimpleButtonData() {
		this.image = new SimpleObjectProperty<Image>();
		this.text = new SimpleStringProperty("unnamed");
	}

	public ObjectProperty<Image> image() {
		return this.image;
	}

	public StringProperty text() {
		return this.text;
	}

}
