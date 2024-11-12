package Pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import Base.SeleniumBase;

public class TS005_ConfirmationPage extends SeleniumBase {

	public TS005_ConfirmationPage(RemoteWebDriver driver, ExtentTest eachNode) {

		this.driver = driver;
		this.eachNode = eachNode;
	}

	public TS005_ConfirmationPage verifyConfimationPage() {

		webDriverWaitTillElementVisible(locateElement("css", "[class*='toast-title']"));
		verifyIsDisplayed(locateElement("css", "[class*='toast-title']"), "Order placed successfully");
		String text = getElementText(locateElement("tagname", "h1"));
		AssertEquals(text, " Thankyou for the order. "); // wantedly failing this to take screenshot
		verifyIsDisplayed(locateElement("css", "tr[class='ng-star-inserted']"), "Order ID");
		String prodcut = getElementText(locateElement("css", "div[class='title']"));
		AssertEquals(prodcut, prop.getProperty("product"));
		scrollUp();
		scrollUp();
		webDriverWaitTillElementVisible(locateElement("xpath", "//button[text()=' Sign Out ']"));
		click(locateElement("xpath", "//button[text()=' Sign Out ']")); //
		webDriverWaitTillElementVisible(locateElement("id", "toast-container"));
		verifyIsDisplayed(locateElement("id", "toast-container"), "Logout Successfully");

		return this;
	}

}
