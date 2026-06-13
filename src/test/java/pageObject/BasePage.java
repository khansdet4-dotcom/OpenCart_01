package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
WebDriver driver;//to declare the driver variable to be used in the page classes
public BasePage(WebDriver driver) {//constructor to initialize the driver
	this.driver=driver;//to initialize the driver in the base class constructor
	PageFactory.initElements(driver, this);//to initialize the webelements in the page class
}

}
