package de.lit.ribbonfx.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Group;
import javafx.scene.Node;

public class SubSelectionData {

	StringProperty title;
	BooleanProperty disabled;
	ObjectProperty<Node> content;

	/**
	 * Hidden constructor
	 */
	public SubSelectionData() {
		this.title = new SimpleStringProperty("NO_TITLE");
		this.disabled = new SimpleBooleanProperty(false);
		this.content = new SimpleObjectProperty<>(new Group());
	}

	public StringProperty title() {
		return this.title;
	}

	public BooleanProperty disabled() {
		return this.disabled;
	}

	public ObjectProperty<Node> content() {
		return this.content;
	}

}
