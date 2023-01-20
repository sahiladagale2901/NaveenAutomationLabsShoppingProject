package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemPriceVerificationPageObject {
	public WebDriver driver;
	By Search = By.xpath("//input[@name='search']");
	By SearchButton = By.xpath("//button[@class='btn btn-default btn-lg']");
	By Title = By.xpath("//div[@class='caption']//a");
	By AddToCart = By.xpath("//button[@id='button-cart']");
	By Cart = By.xpath("(//button[@data-toggle='dropdown'])[2]");
	By TotalPrice = By.xpath("(//td[@class='text-right'])[12]");

	public ItemPriceVerificationPageObject(WebDriver driver2) {
		this.driver = driver2;
	}

	public WebElement SearchBox() {
		return driver.findElement(Search);
	}

	public WebElement ClickOnSearchButton() {
		return driver.findElement(SearchButton);
	}

	public List<WebElement> TitleName() {
		return driver.findElements(Title);
	}

	public WebElement ClickOnAddToCart() {
		return driver.findElement(AddToCart);
	}

	public WebElement ClickOnMainCart() {
		return driver.findElement(Cart);
	}
	public WebElement GetTotalPrice() {
		return driver.findElement(TotalPrice);
	}

}