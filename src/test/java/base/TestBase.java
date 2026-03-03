//package base;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;


public class TestBase {
	private static TestBase testBase;
	private static WebDriver driver;
		private TestBase() {
			String strBrowser ="chrome";
			Map<String,Object> prefs=new HashMap<>();
			
			// Create ChromeOptions to configure browser settings
	        ChromeOptions options = new ChromeOptions();
	        // 1. Disable browser notifications
	        options.addArguments("--incognito"); 
	         prefs.put("profile.default_content_setting_values.notifications", 2); // 1=Allow, 2=Block
	        options.setExperimentalOption("prefs", prefs);

	        // 2. Disable save password pop up
	        prefs.put("credentials_enable_service", false);
	        prefs.put("profile.password_manager_enabled", false);

	        // 3. Disable info bars
	        options.addArguments("--disable-infobars");

	        // 4. Disable pop up blocking (optional, usually enabled by default)
	        options.addArguments("--disable-popup-blocking");
			prefs.put("credentials_ena", driver);
			
			if (strBrowser.equalsIgnoreCase("Chrome")) {
				
				driver=new ChromeDriver(options);
			}else if(strBrowser.equalsIgnoreCase("edge")) {
				driver=new EdgeDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().deleteAllCookies();
		}
	
	public static void initDriver() {
		if(testBase==null) {
			testBase=new TestBase();
		}
	}
		
	public static WebDriver getDriver() {
		return driver;
		}
	
	public static void OpenUrl(String url) {
		driver.get(url);
	}
	
	public static void tearDown() {
		if(driver!=null) {
			driver.close();
			driver.quit();
		}
		
		testBase=null;
	}
		
	}

