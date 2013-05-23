package com.vaadin.training.testbench;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class LoginView extends VerticalLayout {

	private final TBDemoUI ui;
	private VerticalLayout loginBox;
	private Label errorLabel;

	public LoginView(TBDemoUI ui) {
		addStyleName(TrainingTheme.LoginView.STYLENAME);
		this.ui = ui;
		setSizeFull();
		addLoginBox();
	}

	private void addLoginBox() {
		loginBox = new VerticalLayout();
		loginBox.addStyleName(TrainingTheme.LoginView.LOGIN_BOX);
		loginBox.setSizeUndefined();
		loginBox.setSpacing(true);
		loginBox.setMargin(true);

		FormLayout loginLayout = new FormLayout();

		final TextField usernameField = new TextField("Username");
		usernameField.setId("username-field");
		final PasswordField passwordField = new PasswordField("Password");
		passwordField.setId("password-field");
		loginLayout.addComponents(usernameField, passwordField);

		Button loginButton = new Button("Login", new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				if (usernameField.getValue().equals(passwordField.getValue())) {
					ui.loginSuccessful();
				} else {
					showLoginError(true);
				}
			}
		});

		loginButton.setId("login-button");
		loginButton.addStyleName(TrainingTheme.BUTTON_DEFAULT);

		loginBox.addComponents(loginLayout, loginButton);
		loginBox.setComponentAlignment(loginButton, Alignment.BOTTOM_RIGHT);

		addComponent(loginBox);
		setComponentAlignment(loginBox, Alignment.MIDDLE_CENTER);
	}

	protected void showLoginError(boolean visible) {
		if (!visible && errorLabel != null) {
			loginBox.removeComponent(errorLabel);
			errorLabel = null;
		} else {
			errorLabel = new Label("Error logging in!");
			errorLabel.setId("error-label");
			errorLabel.addStyleName(TrainingTheme.ERROR_LABEL);
			loginBox.addComponent(errorLabel);
		}
	}

}
