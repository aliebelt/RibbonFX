package de.lit.ribbonfx.actions;

import javafx.event.ActionEvent;
import de.lit.ribbonfx.model.ButtonData;

/**
 * @author a.liebelt
 */
public class ButtonAction extends ActionEvent {

	private static final long serialVersionUID = -4378515087788533499L;

	ButtonData buttonData;

	public ButtonAction(ButtonData buttonData) {
		super();
		this.buttonData = buttonData;
	}

	public ButtonData getButtonData() {
		return this.buttonData;
	}

}
