package com.vaadin.training.testbench;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vaadin.testbench.By;
import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;

public class TestPost extends TestBenchTestCase {
	private WebDriver driver;
	private String baseUrl;
	private final StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = TestBench.createDriver(new FirefoxDriver());
		baseUrl = "http://localhost:8080/";
	}

	@Test
	public void testPost() throws Exception {
		driver.get(concatUrl(baseUrl, "/TestBenchDemo/"));
		testBenchElement(
				driver.findElement(By
						.vaadin("TestBenchDemo::/VVerticalLayout[0]/Slot[0]/VVerticalLayout[0]/Slot[0]/VHorizontalLayout[0]/Slot[0]/VTextField[0]")))
				.click(197, 5);
		driver.findElement(
				By.vaadin("TestBenchDemo::/VVerticalLayout[0]/Slot[0]/VVerticalLayout[0]/Slot[0]/VHorizontalLayout[0]/Slot[0]/VTextField[0]"))
				.clear();
		driver.findElement(
				By.vaadin("TestBenchDemo::/VVerticalLayout[0]/Slot[0]/VVerticalLayout[0]/Slot[0]/VHorizontalLayout[0]/Slot[0]/VTextField[0]"))
				.sendKeys("hello");
		driver.findElement(
				By.vaadin("TestBenchDemo::/VVerticalLayout[0]/Slot[0]/VVerticalLayout[0]/Slot[0]/VHorizontalLayout[0]/Slot[1]/VButton[0]/domChild[0]/domChild[0]"))
				.click();

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
}
