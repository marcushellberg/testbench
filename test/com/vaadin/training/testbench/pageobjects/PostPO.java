package com.vaadin.training.testbench.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.vaadin.testbench.By;

public class PostPO {

	private final TextFieldPO statusField;
	private final WebElement postButton;
	private final WebDriver driver;

	public PostPO(WebDriver driver) {

		this.driver = driver;
		statusField = new TextFieldPO(driver.findElement(By.id("status-field")));
		postButton = driver.findElement(By.id("post-button"));
	}

	public void enterStatus(String status) {
		statusField.input(status);
	}

	public void postStatus() {
		postButton.click();
	}

	public int getPostCount() {
		return getPosts().size();
	}

	public boolean postContainsText(int index, String text) {
		return getPosts().get(index).getText().contains(text);
	}

	private List<WebElement> getPosts() {
		return driver.findElements(By.className("post"));
	}

	public boolean isDisplayed() {
		return statusField.isDisplayed() && postButton != null;
	}
}
