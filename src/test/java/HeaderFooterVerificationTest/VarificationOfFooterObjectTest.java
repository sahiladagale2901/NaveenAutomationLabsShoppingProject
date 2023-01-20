package HeaderFooterVerificationTest;

import java.io.IOException;
import java.net.MalformedURLException;
import org.testng.annotations.Test;
import PageObjectModel.VerificationOfFooterObject;
import Resources.BaseClass;
import Resources.CommonMethod;

public class VarificationOfFooterObjectTest extends BaseClass {

	@Test(priority = 0)
	public void AllFooterLink() throws MalformedURLException, IOException {
		VerificationOfFooterObject vfo = new VerificationOfFooterObject(driver);
		CommonMethod.LinkVerify(vfo.AllFooterLink());
	}

}
