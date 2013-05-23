package com.vaadin.training.testbench;

import static org.junit.Assert.assertEquals;
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

public class TestPost extends TestBenchTestCase {
	private static WebDriver driver;
	private static String baseUrl;
	private PostPO postPage;

	@BeforeClass
	public static void setupClass() {
		driver = TestBench.createDriver(new FirefoxDriver());
		baseUrl = "http://localhost:8080/";
	}

	@Before
	public void setUp() throws Exception {
		driver.get(concatUrl(baseUrl, "/TestBenchDemo/"));
		// Login before each test
		new LoginPO(driver).loginWithCredentials("a", "a");
		postPage = new PostPO(driver);
		assertTrue(postPage.isDisplayed());
	}

	@Test
	public void testPost() throws Exception {
		String status = "hello";
		postPage.enterStatus(status);
		postPage.postStatus();

		assertEquals("Incorrect number of posts found", 1,
				postPage.getPostCount());
		assertTrue("Post did not contain correct text",
				postPage.postContainsText(0, status));
	}

	@Test
	public void testPostOrder() {
		String firstStatus = "first";
		String secondStatus = "second";

		postPage.enterStatus(firstStatus);
		postPage.postStatus();

		postPage.enterStatus(secondStatus);
		postPage.postStatus();

		assertEquals("Incorrect number of posts found", 2,
				postPage.getPostCount());

		// Newest post should be on top
		assertTrue("Posts were in incorrect order",
				postPage.postContainsText(0, secondStatus));
		assertTrue("Posts were in incorrect order",
				postPage.postContainsText(1, firstStatus));
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
		driver.quit();
	}

}
