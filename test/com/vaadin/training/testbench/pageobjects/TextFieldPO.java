package com.vaadin.training.testbench.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TextFieldPO {

	private final WebElement fieldElement;

	public TextFieldPO(WebElement fieldElement) {
		this.fieldElement = fieldElement;
	}

	public void input(String text) {
		fieldElement.clear();
		fieldElement.sendKeys(text);
		fieldElement.sendKeys(Keys.RETURN);
	}

	public boolean isDisplayed() {
		return fieldElement.isDisplayed();
	}
}
