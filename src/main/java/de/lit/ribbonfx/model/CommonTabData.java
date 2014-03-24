package de.lit.ribbonfx.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;

public class CommonTabData {

	StringProperty title;
	BooleanProperty disabled;
	ObjectProperty<Node> content;

	public CommonTabData() {
		this.title = new SimpleStringProperty("NO_TITLE");
		this.disabled = new SimpleBooleanProperty(false);
		this.content = new SimpleObjectProperty<Node>();
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
