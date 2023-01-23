package Account;

import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ConstantData.ConstantDataForRegister;
import PageObjectModel.AccountCreationPageObject;
import Resources.BaseClass;
import Resources.CommonMethod;

public class AccountCreationTestCAse extends BaseClass {

	@Test(priority = 0, dataProvider = "InvalidCredential")

	public void InValidLoginTest(String Email, String Password) throws InterruptedException {
		AccountCreationPageObject rpo = new AccountCreationPageObject(driver);
		rpo.ClickOnAccount().click();
		rpo.MainLogin().click();
		rpo.EnterLoginEmail().sendKeys(Email);
		rpo.EnterPassword().sendKeys(Password);
		rpo.ClickOnLogin().click();
		//CommonMethod.Assertion(rpo.LoginWarningMessage().getText(), ConstantDataForRegister.LongWarningMessage,
				//ConstantDataForRegister.InValidLoginError);

		// ul[@class='dropdown-menu dropdown-menu-right']//a }
	}
	/////////////////////////// use of DataProvider for Invalid Entries
	/////////////////////////// /////////////////////////////////

	@DataProvider
	public Object[][] InvalidCredential() {

		Object[][] data = new Object[3][2];

		data[0][0] = ConstantDataForRegister.FirstInvalidEmail;
		data[0][1] = ConstantDataForRegister.FirstInvalidPassword;

		data[1][0] = ConstantDataForRegister.SecondInValidEmail;
		data[1][1] = ConstantDataForRegister.SecondInvalidPassword;

		data[2][0] = ConstantDataForRegister.ThirdInValidEmail;
		data[2][1] = ConstantDataForRegister.ThirdInvalidPassword;

		return data;
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test(priority = 1)

	public void RegisterUser() throws MalformedURLException, IOException, InterruptedException {

		AccountCreationPageObject rpo = new AccountCreationPageObject(driver);
		rpo.ClickOnAccount().isEnabled();
		rpo.ClickOnAccount().click();
		rpo.ClickOnRegister().click();
		rpo.EnterFirstName().sendKeys(ConstantDataForRegister.FirstName);
		rpo.EnterLastName().sendKeys(ConstantDataForRegister.LAstName);
		String Email = CommonMethod.EmailGenerate();
		rpo.EnterEmail().sendKeys(Email);
		rpo.EnterTelephone().sendKeys(ConstantDataForRegister.Telephone);
		rpo.EnterPassword().sendKeys(ConstantDataForRegister.PassWord);
		rpo.confirmPassword().sendKeys(ConstantDataForRegister.ConformPAssword);
		rpo.ClickOnnewsletter().click();
		rpo.ClickPolicyCheckBox().click();
		rpo.ClickOnContinue().click();
		CommonMethod.Assertion(rpo.SuccessfulMessage().getText(), ConstantDataForRegister.SuccessfulMessage,
				ConstantDataForRegister.LoginError);
		rpo.ContinueAccount().click();
		CommonMethod.LinkVerify(rpo.AllAccountLinkAfterRegister());
		Thread.sleep(2000);
		rpo.EnterOnSubLogOut().click();
		;
		CommonMethod.Assertion(rpo.SuccessfulLogOutMessage().getText(), ConstantDataForRegister.SuccessfulLogout,
				ConstantDataForRegister.LogOutError);

		rpo.ClickOnAccount().click();
		rpo.MainLogin().click();
		rpo.EnterLoginEmail().sendKeys(Email);
		rpo.EnterPassword().sendKeys(ConstantDataForRegister.ConformPAssword);
		rpo.ClickOnLogin().click();

	}

}
