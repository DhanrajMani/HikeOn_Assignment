package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signup_page_objects {

	
	@FindBy(xpath = "//input[@id='ap_customer_name']")
	public static WebElement firstName;
	
	@FindBy(xpath = "//input[@id='ap_phone_number']")
	public static WebElement mobileNumber;
	
	@FindBy(xpath = "//input[@id='ap_password']")
	public static WebElement passWord;
	
	@FindBy(xpath = "//input[@type='submit']")
	public static WebElement submit;
	
	@FindBy(xpath = "//button[@data-theme='home.verifyButton']")
	public static WebElement vetify;
	
	@FindBy(xpath = "//div[starts-with(@class,'sc')]/button[@aria-label='Image 5 of 6.']")
	public static WebElement pazzle;
	
	@FindBy(xpath = "(//input[@type='text'])[last()-2]")
	public static WebElement search;
	
	@FindBy(xpath = "(//div[@role='button'])[last()-9]")
	public static WebElement productSelect;
	
	@FindBy(xpath = "(//img[@class='s-image'])[last()-22]")
	public static WebElement clickProduct;
	
	@FindBy(xpath = "(\"//div[@class='alert-success']\"")
	public static WebElement successMsg;
}
