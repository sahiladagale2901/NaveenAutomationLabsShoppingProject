package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VerificationOfHeaderObject {
	public WebDriver driver;

	By Currency = By.xpath("//span[contains(text(),'Currency')]");
	By AllCurrency = By.xpath("//button[@class='currency-select btn btn-link btn-block']");
	By Account = By.xpath("//span[@class='caret']");
	By SearchBox = By.xpath("//input[@name='search']");
	By Contact = By.xpath("//i[@class='fa fa-phone']");
	By ValidCompanyContact = By.xpath("(//div[@class='row'])[3]");
	By name = By.xpath("//input[@id='input-name']");
	By email = By.xpath("//input[@id='input-email']");
	By EnquiryMessage = By.xpath("//textarea[@id='input-enquiry']");
	By Submit = By.xpath("//input[@type='submit']");
	By Continue = By.xpath("(//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=common/home'])[3]");
	By HeaderLink = By.xpath("//ul[@class='list-inline']//a");
	By DesktopDropdown = By.xpath(
			"(//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=20'])[1]");
	By AllDesktopList = By.xpath(
			"(//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=20'])[2]");
	By AllLinksOnDeskTopIcon = By.xpath("//aside[@id='column-left']//a");

	public VerificationOfHeaderObject(WebDriver driver2) {
		this.driver = driver2;
	}

	public WebElement ClickCurrency() {
		return driver.findElement(Currency);
	}

	public List<WebElement> AllCurrency() {
		return driver.findElements(AllCurrency);
	}

	public WebElement ClickOnAccount() {
		return driver.findElement(Account);
	}

	public WebElement ClickOnContact() {
		return driver.findElement(Contact);
	}

	public WebElement VerifyCompanyContactsDetails() {
		return driver.findElement(ValidCompanyContact);
	}

	public WebElement EnterName() {
		return driver.findElement(name);
	}

	public WebElement Enetremail() {
		return driver.findElement(email);
	}

	public WebElement EnterEnquiryMessage() {
		return driver.findElement(EnquiryMessage);
	}

	public WebElement clickOnSubmit() {
		return driver.findElement(Submit);
	}

	public WebElement clickOnContinue() {
		return driver.findElement(Continue);
	}

	public List<WebElement> HeaderLink() {
		return driver.findElements(HeaderLink);
	}

	public WebElement DesktopDropdown() {
		return driver.findElement(DesktopDropdown);
	}

	public WebElement ShowAllDesktopList() {
		return driver.findElement(AllDesktopList);
	}

	public List<WebElement> AllLinksOnDeskTopIcon() {
		return driver.findElements(AllLinksOnDeskTopIcon);
	}

}
