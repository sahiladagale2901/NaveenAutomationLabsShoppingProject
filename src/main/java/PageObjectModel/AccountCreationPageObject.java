package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;

public class AccountCreationPageObject {

	public WebDriver driver;

	//////////////////////////// Data for Register a use
	//////////////////////////// //////////////////////////////

	private By Account = By.xpath("//span[contains(text(),'My Account')]");
	private By Register = By
			.xpath("//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=account/register']");
	private By FirstName = By.xpath("//input[@name='firstname']");
	private By Lastname = By.xpath("//input[@name='lastname']");
	private By Email = By.xpath("//input[@name='email']");
	private By Telephone = By.xpath("//input[@name='telephone']");
	private By Password = By.xpath("//input[@name='password']");
	private By confirmPassword = By.xpath("//input[@name='confirm']");
	private By newsletter = By.xpath("//input[@name='newsletter']");
	private By PolicyCheckBox = By.xpath("//input[@name='agree']");
	private By ClickContinue = By.xpath("//input[@value='Continue']");
	private By SuccessfulRegister = By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]");
	private By ContinueAccount = By.xpath("//a[@class='btn btn-primary']");

	//////////////////////////// after register Links
	//////////////////////////// ////////////////////////////////////

	private By AllAccountLinkAfterRegister = By.xpath("//div[@id='content']//a");

	/////////////////////////// Login Element ///////////////////////////////////
	private By LogOut = By
			.xpath("(//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=account/logout'])[2]");
	private By SuccessfulLogOutMessage = By.xpath(
			"//p[contains(text(),'You have been logged off your account. It is now safe to leave the computer.')]");
	private By MainLogin = By.xpath("(//a[contains(text(),'Login')])[1]");
	private By SubLogin = By.xpath("(//a[contains(text(),'Login')])[3]");
	private By LoginEmail = By.xpath("//input[@id='input-email']");
	private By LoginPassword = By.xpath("//input[@id='input-email']");
	private By LoginButton = By.xpath("//input[@type='submit']");
	private By WarningMessage = By
			.xpath("//div[@class='alert alert-danger alert-dismissible']");

	private By HomeIcon = By
			.xpath("(//a[@href='https://naveenautomationlabs.com/opencart/index.php?route=common/home'])[2]");

	public AccountCreationPageObject(WebDriver driver2) {
		this.driver = driver2;
	}

	public WebElement ClickOnAccount() {
		return driver.findElement(Account);
	}

	public WebElement ClickOnRegister() {
		return driver.findElement(Register);
	}

	public WebElement EnterFirstName() {
		return driver.findElement(FirstName);
	}

	public WebElement EnterLastName() {
		return driver.findElement(Lastname);
	}

	public WebElement EnterEmail() {
		return driver.findElement(Email);
	}

	public WebElement EnterTelephone() {
		return driver.findElement(Telephone);
	}

	public WebElement EnterPassword() {
		return driver.findElement(Password);
	}

	public WebElement confirmPassword() {
		return driver.findElement(confirmPassword);
	}

	public WebElement ClickOnnewsletter() {
		return driver.findElement(newsletter);
	}

	public WebElement ClickPolicyCheckBox() {
		return driver.findElement(PolicyCheckBox);
	}

	public WebElement ClickOnContinue() {
		return driver.findElement(ClickContinue);
	}

	public WebElement SuccessfulMessage() {
		return driver.findElement(SuccessfulRegister);
	}

	public WebElement ContinueAccount() {
		return driver.findElement(ContinueAccount);
	}

	public List<WebElement> AllAccountLinkAfterRegister() {
		return driver.findElements(AllAccountLinkAfterRegister);

	}

///////////////////////////// Login Element ///////////////////////////////////////
	public WebElement EnterOnSubLogOut() {
		return driver.findElement(LogOut);
	}

	public WebElement SuccessfulLogOutMessage() {
		return driver.findElement(SuccessfulLogOutMessage);
	}

	public WebElement MainLogin() {
		return driver.findElement(MainLogin);
	}

	public WebElement EnterLoginEmail() {
		return driver.findElement(LoginEmail);
	}

	public WebElement EnterLoginPassword() {
		return driver.findElement(LoginPassword);
	}

	public WebElement ClickOnLogin() {
		return driver.findElement(LoginButton);
	}

	public WebElement ClinkOnHomeIcon() {
		return driver.findElement(HomeIcon);
	}

	public WebElement LoginWarningMessage() {
		return driver.findElement(WarningMessage);
	}

}
