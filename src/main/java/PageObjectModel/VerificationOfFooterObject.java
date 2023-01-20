package PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerificationOfFooterObject {
	public WebDriver driver;

	By AllFooterLink = By.xpath("(//div[@class='row'])[8]//a");

	public VerificationOfFooterObject(WebDriver driver2) {
		this.driver = driver2;
	}

	public List<WebElement> AllFooterLink() {
		return driver.findElements(AllFooterLink);
	}

	public static void main(String[] args) {
		WebDriver d = new ChromeDriver();
		d.get("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=20");
		List<WebElement> w = d.findElements(By.xpath("(//div[@class='row'])[8]//a"));
		System.out.println(w.size());
	}
}
