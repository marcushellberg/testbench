package com.vaadin.training.testbench;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vaadin.testbench.Parameters;
import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.training.testbench.pageobjects.LoginPO;
import com.vaadin.training.testbench.pageobjects.PostPO;

public class TestLogin extends TestBenchTestCase {
	private static String baseUrl;
	private LoginPO loginPage;

	@BeforeClass
	public static void setupClass() {
		baseUrl = "http://localhost:8080/";

		// Define the default directory for reference screenshots
		Parameters.setScreenshotReferenceDirectory("src/screenshots");

		// Define the directory where possible error files and screenshots
		// should go
		Parameters.setScreenshotErrorDirectory("build/screenshot_errors");

		// Capture a screenshot if no reference image is found
		Parameters.setCaptureScreenshotOnFailure(true);
	}

	@Before
	public void setUp() throws Exception {
		setDriver(TestBench.createDriver(new FirefoxDriver()));
		getDriver().get(concatUrl(baseUrl, "/TestBenchDemo/"));
		testBench().resizeViewPortTo(800, 600);
		loginPage = new LoginPO(getDriver());
		assertTrue(loginPage.isDisplayed());
	}

	@Test
	public void testFailedLogin() {
		loginPage.enterUsername("a");
		loginPage.enterPassword("b");

		loginPage.submitLogin();

		assertTrue(loginPage.hasErrors());
		assertTrue(loginPage.errorMessageContains("Error"));
	}

	@Test
	public void testSuccessfulLogin() {
		loginPage.enterUsername("a");
		loginPage.enterPassword("a");

		loginPage.submitLogin();

		// Posts view should now be shown
		assertTrue(new PostPO(driver).isDisplayed());
	}

	@Test
	public void testLoginBoxStyles() throws IOException, AssertionError {
		assertTrue(testBench().compareScreen("loginBox"));
	}

	@After
	public void tearDownClass() throws Exception {
		getDriver().quit();
	}

}
