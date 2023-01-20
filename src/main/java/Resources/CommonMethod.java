package Resources;

import java.io.File;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import PageObjectModel.ItemPriceVerificationPageObject;

public class CommonMethod {
	public WebDriver driver;

	public static void Assertion(String actual, String expected, String message) {
		SoftAssert sa = new SoftAssert();
		// sa.assertEquals(actual, expected);
		sa.assertEquals(actual, expected, message);
		sa.assertAll();
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String EmailGenerate() {
		Faker faker = new Faker();
		String Email = faker.name().username() + ("@gmail.com");
		return Email;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void LinkVerify(List<WebElement> link) throws MalformedURLException, IOException {
		SoftAssert Assert = new SoftAssert();
		for (WebElement links : link) {
			String url = links.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int ResponseCode = conn.getResponseCode();
			// System.out.println(ResponseCode);
			Assert.assertTrue(ResponseCode == 200,
					"The link" + links.getText() + "is broken with code :" + ResponseCode);
		}
		Assert.assertAll();
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void VerifyDropDowns(List<WebElement> dropdown, String TestName) {
		for (WebElement dropdowns : dropdown) {
			boolean resp = dropdowns.isEnabled(); // help to get disabled dropdown
			// System.out.println(dropdowns.getText());
			if (resp == false) {
				System.out.println(dropdowns.getText() + ":" + TestName);
			}
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static void ActionClass(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static double ItemDetails(WebDriver driver, List<WebElement> Titles, String name) {
		for (WebElement title : Titles) {
			if (title.getText().equals(name)) {
				title.click();
			}
		}
		WebElement price = driver.findElement(By.xpath("(//ul[@class='list-unstyled'])[9]"));
		// WebElement quantity =
		// driver.findElement(By.xpath("//input[@id='input-quantity']"));
		String ItemPrice = price.getText();
		String p[] = ItemPrice.split("\\s");
		String OnlyPrice = p[0].replaceAll("[$,]", "");
		double MainPrice = Double.parseDouble(OnlyPrice);
		ItemPriceVerificationPageObject ivo = new ItemPriceVerificationPageObject(driver);
		ivo.ClickOnAddToCart().click();
		return MainPrice;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static double CartPrice(WebDriver driver) {
		ItemPriceVerificationPageObject ivo = new ItemPriceVerificationPageObject(driver);
		ivo.ClickOnMainCart().click();
		String dollarstring = ivo.GetTotalPrice().getText();
		String p = dollarstring.substring(1);
		double TotalPrice = Double.parseDouble(p);
		return TotalPrice;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Under Working
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {

		String dateFormat = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		String destination = System.getProperty("user.dir") + "/Screenshots/" + screenshotName + dateFormat + ".png";

		File finalDestaination = new File(destination);
		// FileUtils.copyFile(source, finalDestaination);
		return destination;
	}
}
