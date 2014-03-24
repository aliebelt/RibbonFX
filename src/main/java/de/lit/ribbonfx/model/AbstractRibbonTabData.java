package de.lit.ribbonfx.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;

public abstract class AbstractRibbonTabData {

	StringProperty title;
	BooleanProperty disabled;
	ObjectProperty<Node> content;
	ObjectProperty<FooterData> footer;

	public AbstractRibbonTabData() {
		this.title = new SimpleStringProperty("NO_TITLE");
		this.disabled = new SimpleBooleanProperty(false);
		this.content = new SimpleObjectProperty<Node>();
		this.footer = new SimpleObjectProperty<FooterData>();
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

	public ObjectProperty<FooterData> footer() {
		return this.footer;
	}

}
