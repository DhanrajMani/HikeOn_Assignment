package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import pageObjects.signup_page_objects;

public class launchBrowsers extends signup_page_objects{
	
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait wait;
	
	Logger logger = Logger.getLogger(launchBrowsers.class);
	
	public Properties loadPropertyFile() throws IOException {
		FileInputStream fileInputStream = new FileInputStream("config.properties");
		prop = new Properties();
		prop.load(fileInputStream);
		return prop;
	}
	
	@BeforeSuite
	@Parameters("browser")
	public void launch_Browsers(String browser) throws IOException {
		
		logger.info("Amazon Application Sign-up");
		logger.info("Loading the property file");
		loadPropertyFile();
		PageFactory.initElements(driver, launchBrowsers.class);
		String url = prop.getProperty("url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./driver3/chromedriver.exe");
			logger.info("Launching Chrome");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.firefox.driver", "./driver3/geckodriver.exe");
			logger.info("Launching Firefox");
			driver = new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.info("Navigationg to Application");
		driver.get(url);		
		
	}
	
	@AfterSuite
	public void tearDown() {
		logger.info("Execution done and closing the browser");
		driver.quit();
	}

}
