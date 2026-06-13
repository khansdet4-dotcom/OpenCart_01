package testBase;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BaseClass {
	
	
public WebDriver driver;
public Logger logger;
public Properties p;
	@BeforeClass(groups={"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException {
		
		p = new Properties();
		FileInputStream fis = new FileInputStream("./src//test//resources//config.properties");
		p.load(fis);
		
		logger = LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
		DesiredCapabilities cap = new DesiredCapabilities();
		if(os.equalsIgnoreCase("windows")) {
			cap.setPlatform(Platform.WIN11);
		}
		else if(os.equalsIgnoreCase("mac")) {
			cap.setPlatform(Platform.MAC);
		}
		else {
			System.out.println("No matching os");
			return;
		}
		switch(br.toLowerCase()) {
		case "chrome": cap.setBrowserName("chrome");break;
		case "edge": cap.setBrowserName("edge");break;
		case "firefox": cap.setBrowserName("firefox");break;
		default: System.out.println("Invalid browser"); return;
		}
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
		}
	
		
		else if(p.getProperty("execution_env").equalsIgnoreCase("local")){
			switch(br.toLowerCase()){
			case "chrome":driver = new ChromeDriver();break;
			case "edge": driver = new EdgeDriver();break;
			case "firefox": driver = new FirefoxDriver();break;
			default: System.out.println("Invalid browser name.."); return;
			}
	
		
	}
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	
	}
	
	@AfterClass(groups={"Sanity","Regression","Master"})
	public void tearDown() {
		driver.quit();
	}
	public String randomString() {
		 String generateString = RandomStringUtils.randomAlphabetic(5);
		 return generateString;
	}
	
	public String randomNumber() {
		String generateNumber = RandomStringUtils.randomNumeric(10);
		return generateNumber;
	}

	public String randomAlphaNumeric() {
		String generateAlphaNumeric = RandomStringUtils.randomAlphanumeric(10);
		return generateAlphaNumeric;
	}

}
