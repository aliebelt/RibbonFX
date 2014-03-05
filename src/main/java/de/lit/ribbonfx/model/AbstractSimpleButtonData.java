package de.lit.ribbonfx.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

public abstract class AbstractSimpleButtonData {

	ObjectProperty<Image> image;
	StringProperty text;
	BooleanProperty disabled;

	public AbstractSimpleButtonData() {
		this.image = new SimpleObjectProperty<Image>();
		this.text = new SimpleStringProperty("");
		this.disabled = new SimpleBooleanProperty(false);
	}

	public ObjectProperty<Image> image() {
		return this.image;
	}

	public StringProperty text() {
		return this.text;
	}

	public BooleanProperty disabled() {
		return this.disabled;
	}

}
