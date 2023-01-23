package HeaderFooterVerificationTest;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import ConstantData.ConstantDataForRegister;
import ConstantData.ConstantForAllObject;
import PageObjectModel.VerificationOfHeaderObject;
import Resources.BaseClass;
import Resources.CommonMethod;

public class VerificationOfHeaderObjectTest extends BaseClass {
	@Test(priority = 0)
	public void CurrencyDropDown() throws InterruptedException {
		VerificationOfHeaderObject vho = new VerificationOfHeaderObject(driver);
		vho.ClickCurrency().click();
		Thread.sleep(2000);
		CommonMethod.VerifyDropDowns(vho.AllCurrency(), ConstantForAllObject.Currency);
	}

	@Test(priority = 1)
	public void Contacts() {
		VerificationOfHeaderObject vho = new VerificationOfHeaderObject(driver);
		vho.ClickOnContact().click();
		if (vho.VerifyCompanyContactsDetails().getText().contains(ConstantForAllObject.CompanyContactDetails)) {
			// System.out.println("true");
			vho.EnterName().sendKeys(ConstantDataForRegister.FirstName);
			vho.Enetremail().sendKeys(ConstantDataForRegister.FirstInvalidEmail);
			vho.EnterEnquiryMessage().sendKeys(ConstantForAllObject.EnterEnquiry);
			vho.clickOnSubmit().click();
			vho.clickOnContinue().click();
		}
	}

	@Test(priority = 2)
	public void VerificationOfHeaderLinks() throws MalformedURLException, IOException {
		VerificationOfHeaderObject vho = new VerificationOfHeaderObject(driver);
		CommonMethod.LinkVerify(vho.HeaderLink());
	}

	@Test(priority = 3)
	public void DesktopLinks() throws MalformedURLException, IOException {
		VerificationOfHeaderObject vho = new VerificationOfHeaderObject(driver);
		//CommonMethod.ActionClass(driver, vho.DesktopDropdown());
		vho.DesktopDropdown().click();
		vho.ShowAllDesktopList().click();
		CommonMethod.LinkVerify(vho.AllLinksOnDeskTopIcon());
	}
}
