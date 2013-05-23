package com.vaadin.training.testbench;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vaadin.testbench.TestBench;
import com.vaadin.testbench.TestBenchTestCase;
import com.vaadin.training.testbench.pageobjects.LoginPO;
import com.vaadin.training.testbench.pageobjects.PostPO;

public class TestLogin extends TestBenchTestCase {
	private static WebDriver driver;
	private static String baseUrl;
	private LoginPO loginPage;

	@BeforeClass
	public static void setupClass() {
		driver = TestBench.createDriver(new FirefoxDriver());
		baseUrl = "http://localhost:8080/";
	}

	@Before
	public void setUp() throws Exception {
		driver.get(concatUrl(baseUrl, "/TestBenchDemo/"));
		loginPage = new LoginPO(driver);
		assertTrue(loginPage.isDisplayed());
	}

	@Test
	public void testFailedLogin() {
		loginPage.enterUsername("a");
		loginPage.enterPassword("b");

		loginPage.submitLogin();

		assertTrue(loginPage.hasErrors());
		assertTrue(loginPage.errorContains("Error"));
	}

	@Test
	public void testSuccessfulLogin() {
		loginPage.enterUsername("a");
		loginPage.enterPassword("a");

		loginPage.submitLogin();

		// Posts view should now be shown
		assertTrue(new PostPO(driver).isDisplayed());
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		driver.quit();
	}

}
