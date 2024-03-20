import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ApplicantInformation {
	public void applicationInformation(WebDriver driver) {
		Actions actions = new Actions(driver);

		// Perform a Negative test for Applicant Information

		// Check 1 : if an error is displayed when clicking the button without providing
		// any input.
		WebElement nextButton = driver.findElement(By.xpath(
				"/html/body/app-root/div/div/div/app-product-pgt/div/div/div[4]/div/div/div[2]/div[1]/div/app-questions-field/div/div[1]/div[3]/div[3]/div[2]/button"));

		Actions action = new Actions(driver);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		action.moveToElement(nextButton).perform();
		nextButton.click();

		try {
			@SuppressWarnings("unused")
			WebElement errorMessage = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]"));
			// Element found
			System.out.println("Element exists.");
		} catch (NoSuchElementException e) {
			// Element not found
			System.out.println("Element does not exist.");
		}

		// Perform a Positive test for Applicant Information.

		// Pause execution.
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Input the first name into the field.
		try {
			FileInputStream applicationInformation = new FileInputStream(
					"E:\\Technical_Assignment-main\\New Folder\\Data.xlsx");
			Workbook workbook = new XSSFWorkbook(applicationInformation);
			Sheet sheet = workbook.getSheetAt(2);

			// Find the input field for the first name and input the first name into it.
			Row rowfirstName = sheet.getRow(1);
			Cell cellFirstName = rowfirstName.getCell(0);
			String firstName = cellFirstName.getStringCellValue();

			WebElement firstNameField = driver.findElement(By.id("78_158_1440_14410-ipt"));
			firstNameField.sendKeys(firstName);

			// Find the input field for the last name and input the last name into it

			Row rowlastName = sheet.getRow(1);
			Cell cellLastName = rowlastName.getCell(1);
			String lastName = cellLastName.getStringCellValue();

			WebElement lastNameField = driver.findElement(By.id("78_158_1440_14920-ipt"));
			lastNameField.sendKeys(lastName);

			// Retrieving data from the Excel sheet
			Row rowDob = sheet.getRow(1);
			Cell cellDob = rowDob.getCell(2);
			String dobXpath = cellDob.getStringCellValue();

			// Finding the calendar using XPath
			WebElement dob = driver.findElement(By.xpath(
					"/html[1]/body[1]/app-root[1]/div[1]/div[1]/div[1]/app-product-pgt[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/app-questions-field[1]/div[1]/div[1]/div[3]/div[2]/app-questions-container[1]/div[1]/app-group[1]/div[1]/div[1]/div[1]/div[2]/div[4]/app-questions-container[1]/div[1]/app-date[1]/div[1]/div[2]/div[1]/input[1]"));
			dob.click();

			WebElement dobPick = driver.findElement(By.xpath(dobXpath));
			dobPick.click();

			// Retrieving data from the Excel sheet
			Row rowAddress = sheet.getRow(1);
			Cell cellAddress = rowAddress.getCell(4);
			String address = cellAddress.getStringCellValue();

			// Searching for the Address Field and inputting the first 2 letters
			WebElement addressField = driver.findElement(By.xpath(
					"/html[1]/body[1]/app-root[1]/div[1]/div[1]/div[1]/app-product-pgt[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/app-questions-field[1]/div[1]/div[1]/div[3]/div[2]/app-questions-container[1]/div[1]/app-group[1]/div[1]/div[1]/div[1]/div[2]/div[6]/app-questions-container[1]/div[1]/app-address[1]/div[1]/div[2]/ng-select[1]/div[1]/div[1]/div[2]/input[1]"));
			addressField.sendKeys(address);

			// Handling InterruptedException
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			addressField.sendKeys(Keys.ENTER);

			// Retrieving Moblile Number data from the Excel sheet
			Row rowContactNumber = sheet.getRow(1);
			Cell cellContactNumber = rowContactNumber.getCell(5);
			double contactNumber = (int) cellContactNumber.getNumericCellValue();

			String contactNumberString = String.valueOf((int) contactNumber);

			// Finding the Moblile Number Field
			WebElement contactNumberField = driver.findElement(By.id("text-input-78_158_1440_11470"));
			contactNumberField.sendKeys(contactNumberString);

			Row rowEmail = sheet.getRow(1);
			Cell cellEmail = rowEmail.getCell(6);
			String email = cellEmail.getStringCellValue();

			WebElement emailField = driver.findElement(By.id("78_158_1440_14430-ipt"));
			emailField.sendKeys(email);

			// Find the input field for the Additional Travellers First name and input the
			// Additional Travellers First name into it.
			Row rowAddTravellerfirstName = sheet.getRow(1);
			Cell cellAdditionalTravellersFirstName = rowAddTravellerfirstName.getCell(8);
			String additionalTravellersFirstName = cellAdditionalTravellersFirstName.getStringCellValue();

			WebElement secondaryFirstNameField = driver.findElement(By.id("78_158_1444_12320-ipt"));
			secondaryFirstNameField.sendKeys(additionalTravellersFirstName);

			// Find the input field for the Additional Travellers Last name and input the
			// Additional Travellers Last name into it.
			Row rowAddTravellerLastName = sheet.getRow(1);
			Cell cellAdditionalTravellersLastName = rowAddTravellerLastName.getCell(9);
			String additionalTravellersLastName = cellAdditionalTravellersLastName.getStringCellValue();

			WebElement additionalTravellersLastNameField = driver.findElement(By.id("78_158_1444_14830-ipt"));
			additionalTravellersLastNameField.sendKeys(additionalTravellersLastName);

			// Retrieving data from the Excel sheet
			Row rowAdditionalTravellersDob = sheet.getRow(1);
			Cell celladditionalTravellersDob = rowAdditionalTravellersDob.getCell(10);
			String additionalTravellersDobXpath = celladditionalTravellersDob.getStringCellValue();

			// Finding the calendar using XPath
			WebElement additionalTravellersDob = driver.findElement(By.xpath(
					"/html/body/app-root/div/div/div/app-product-pgt/div/div/div[4]/div/div/div[2]/div[1]/div/app-questions-field/div/div[1]/div[3]/div[2]/app-questions-container[2]/div/app-group/div[1]/div/div/div[2]/div[5]/app-questions-container/div/app-date/div/div[2]/div/input"));
			additionalTravellersDob.click();

			WebElement additionalTravellersDobPick = driver.findElement(By.xpath(additionalTravellersDobXpath));
			additionalTravellersDobPick.click();

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebElement button = driver.findElement(By.xpath(
					"/html/body/app-root/div/div/div/app-product-pgt/div/div/div[4]/div/div/div[2]/div[1]/div/app-questions-field/div/div[1]/div[3]/div[3]/div[2]/button"));
			actions.moveToElement(button).perform();
			button.click();

			workbook.close();
			applicationInformation.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
