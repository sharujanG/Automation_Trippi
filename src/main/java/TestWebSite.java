import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWebSite {
	private WebDriver driver;

	@Before
	public void setUp() {

		// Set the path to the chromedriver executable
		System.setProperty("webdriver.chrome.driver",
				"C:\\WebDrivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

		// Instantiate ChromeDriver
		driver = new ChromeDriver();

		// Maximize the browser window
		driver.manage().window().maximize();

		// Navigate to the website
		driver.get("https://trippi.mustard-test.ensurtek.com/");

		// Wait for 10 seconds before starting the project
		try {
			Thread.sleep(7000); // Sleep for 10 seconds (7000 milliseconds)
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test
	public void performTravelOperations() {
		// Step 1: Provide travel information
		TravelInformation travelInformationobj = new TravelInformation();
		travelInformationobj.travelInformation(driver);
		// Step 2: Choose a travel plan
		ChooseYourPlan chooseYourPlanobj = new ChooseYourPlan();
		chooseYourPlanobj.chooseYourPlan(driver);
		// Step 3: Fill out applicant information
		ApplicantInformation applicationInformationObj = new ApplicantInformation();
		applicationInformationObj.applicationInformation(driver);
		// Step 4: Generate a summary of the entered information
		Summary summaryObj = new Summary();
		summaryObj.summary(driver);
		// Step 5: Proceed with the payment
		Payment paymentObj = new Payment();
		paymentObj.payment(driver);
	}

	@After
	 public void tearDown() {
	 driver.quit();
	 }

}
