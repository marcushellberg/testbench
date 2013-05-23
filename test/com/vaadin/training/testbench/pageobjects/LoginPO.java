package com.vaadin.training.testbench.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPO {

	private final TextFieldPO usernameField;
	private final TextFieldPO passwordField;
	private final WebElement loginButton;
	private final WebDriver driver;

	public LoginPO(WebDriver driver) {
		this.driver = driver;

		usernameField = new TextFieldPO(driver.findElement(By
				.id("username-field")));

		passwordField = new TextFieldPO(driver.findElement(By
				.id("password-field")));

		loginButton = driver.findElement(By.id("login-button"));
	}

	public void enterUsername(String username) {
		usernameField.input(username);
	}

	public void enterPassword(String password) {
		passwordField.input(password);
	}

	public void submitLogin() {
		loginButton.click();
	}

	public boolean hasErrors() {
		return getErrorLabel() != null;
	}

	public boolean errorContains(String errorText) {
		return getErrorLabel().getText().contains(errorText);
	}

	private WebElement getErrorLabel() {
		return driver.findElement(By.id("error-label"));
	}

	public boolean isDisplayed() {
		return usernameField.isDisplayed() && passwordField.isDisplayed()
				&& loginButton.isDisplayed();
	}

	public void loginWithValidCredentials() {
		enterUsername("a");
		enterPassword("a");
		submitLogin();
	}

}
