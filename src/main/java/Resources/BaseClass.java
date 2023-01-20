package Resources;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ConstantData.ConstantDataForRegister;

public class BaseClass {
	public WebDriver driver;

	// public ExtentSparkReporter htmlReporter; // repsosnible for look and feel
	// public ExtentReports extent; // Resposnisble for entries
	// public ExtentTest test; // Respossible for test status pass/fail

	public void BrowserInitilization() throws IOException {

		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\browser.properties");

		Properties prop = new Properties();
		prop.load(file);

		String BrowserName = prop.getProperty("browser");
		if (BrowserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (BrowserName.equalsIgnoreCase("Firefwwox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("check the Browser Name");
		}

	}

	/**
	 * @BeforeTest public void SetUp() { // Looks htmlReporter = new
	 *             ExtentSparkReporter(System.getProperty("user.dir") +
	 *             "/test-output/myReport.html");
	 *             htmlReporter.config().setDocumentTitle("Automation Report");
	 *             htmlReporter.config().setReportName("Functional Report");
	 *             htmlReporter.config().setTheme(Theme.DARK); // Entries extent =
	 *             new ExtentReports(); extent.attachReporter(htmlReporter);
	 *             extent.setSystemInfo("hostname", "LocalHost");
	 *             extent.setSystemInfo("os", "windows10");
	 *             extent.setSystemInfo("testername", "test"); }
	 **/

	@BeforeMethod
	public void BrowserLunch() throws IOException {
		BrowserInitilization();
		driver.get("https://naveenautomationlabs.com/opencart/");
		driver.manage().window().maximize();
	}
	/*
	 * @AfterMethod public void tearDown(ITestResult result) throws IOException { if
	 * (result.getStatus() == ITestResult.FAILURE) {
	 * 
	 * test.log(Status.FAIL, "Test CASE Failed is " + result.getName()); // To add
	 * name in extent report
	 * 
	 * test.log(Status.FAIL, "Test CASE Failed is " + result.getThrowable()); // To
	 * throw excpetion
	 * 
	 * String screenshotPath = CommonMethod.getScreenshot(driver,
	 * result.getName());//
	 * 
	 * test.addScreenCaptureFromPath(screenshotPath); // Adding screenshot inside
	 * report
	 * 
	 * } else if (result.getStatus() == ITestResult.SKIP) { test.log(Status.SKIP,
	 * "test case skipped is" + result.getName());
	 * 
	 * } else if (result.getStatus() == ITestResult.SUCCESS) { test.log(Status.PASS,
	 * "Test case passed is" + result.getName()); }
	 * 
	 * }
	 */

	@AfterMethod
	public void BrowserClose() {
		driver.close();
	}
	/*
	 * @AfterTest public void endReport() { extent.flush(); }
	 */

}
