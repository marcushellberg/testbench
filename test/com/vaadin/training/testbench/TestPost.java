package com.vaadin.training.testbench;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vaadin.testbench.By;
import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;

public class TestPost extends TestBenchTestCase {
	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		driver = TestBench.createDriver(new FirefoxDriver());
		baseUrl = "http://localhost:8080/";
	}

	@Test
	public void testPost() throws Exception {
		driver.get(concatUrl(baseUrl, "/TestBenchDemo/"));
		WebElement statusField = driver.findElement(By.id("status-field"));
		WebElement postButton = driver.findElement(By.id("post-button"));

		testBenchElement(statusField).click(197, 5);
		statusField.clear();
		statusField.sendKeys("hello");
		statusField.sendKeys(Keys.RETURN);
		postButton.click();
		assertTrue(driver.getPageSource().contains("hello"));
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
