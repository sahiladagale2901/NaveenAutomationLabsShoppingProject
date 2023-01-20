package ItemPriceVerification;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import ConstantData.ConstantForAllObject;
import PageObjectModel.ItemPriceVerificationPageObject;
import Resources.BaseClass;
import Resources.CommonMethod;

public class ItemPriceVerificationTest extends BaseClass {

	@Test(priority =0)
	public void PriceVerification() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ItemPriceVerificationPageObject ivo = new ItemPriceVerificationPageObject(driver);
		ivo.SearchBox().sendKeys(ConstantForAllObject.FirstItemName);
		ivo.ClickOnSearchButton().click();
		double FirstItemPrice = CommonMethod.ItemDetails(driver, ivo.TitleName(), ConstantForAllObject.FirstItemName);
		ivo.SearchBox().clear();
		ivo.SearchBox().sendKeys(ConstantForAllObject.SecondItemName);
		ivo.ClickOnSearchButton().click();
		double SecondItemPrice = CommonMethod.ItemDetails(driver, ivo.TitleName(), ConstantForAllObject.SecondItemName);
		double total = FirstItemPrice + SecondItemPrice;

		double CartTotal = CommonMethod.CartPrice(driver);
		if (total == CartTotal) {

			System.out.println("Amount matching successfully, Can Buy Now ");
		} else {

			System.out.println("Amount not matching ");
		}
	}

}
