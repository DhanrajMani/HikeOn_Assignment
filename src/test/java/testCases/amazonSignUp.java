package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import commonFunctions.launchBrowsers;
import pageObjects.signup_page_objects;

public class amazonSignUp extends launchBrowsers {

	Logger logger = Logger.getLogger(amazonSignUp.class);
	
	@Test()
	public void test_CreateAccount() throws InterruptedException {

		PageFactory.initElements(driver, amazonSignUp.class);
		logger.info("Logging to the application");
		signup_page_objects.firstName.sendKeys(prop.getProperty("name"));
		signup_page_objects.mobileNumber.sendKeys(prop.getProperty("mobile"));
		signup_page_objects.passWord.sendKeys(prop.getProperty("password"));
		signup_page_objects.submit.click();
		signup_page_objects.vetify.click();
		signup_page_objects.pazzle.click();
	}

}
