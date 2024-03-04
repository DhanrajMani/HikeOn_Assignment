package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonFunctions.launchBrowsers;
import pageObjects.signup_page_objects;

public class addToCart extends launchBrowsers {

	Logger logger = Logger.getLogger(addToCart.class);
	
	@Test(priority = 1)
	public void searchProduct() {
		PageFactory.initElements(driver, addToCart.class);
		logger.info("Searching the Product");
		signup_page_objects.search.sendKeys(prop.getProperty("product"));
		signup_page_objects.productSelect.click();
		signup_page_objects.clickProduct.click();
	}

	@Test(priority = 2)
	public void product_addToCart() {
		PageFactory.initElements(driver, addToCart.class);
		logger.info("erifying the add to cart button is enabled");
		WebElement addToCartButton = driver.findElement(By.xpath("(//span[@id='submit.add-to-cart'])[last()]"));
		if (addToCartButton.isEnabled()) {
			logger.info("Product is in stock, add it to cart");
			addToCartButton.click();
			logger.info("verify the product is added to the cart");
			wait = new WebDriverWait(driver, 10);
			WebElement successMessage = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert-success']")));
			Assert.assertTrue(successMessage.isDisplayed(), "Product added to cart successfully");
		} else {
			logger.info("Product is out of stock, trigger alert");
			System.out.println("Product is currently out of stock. We'll notify you once it's restocked.");
		}
	}

}