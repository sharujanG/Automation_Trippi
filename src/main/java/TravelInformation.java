import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TravelInformation {
	public void travelInformation(WebDriver driver) {

// Perform a Nagative test for Travel Information
		WebElement GetQuoteButton = driver.findElement(
				By.xpath("/html/body/app-root/div/div/div/app-product-pgt/div/div/div[4]/div/div/div[2]/button"));

		Actions actions = new Actions(driver);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		actions.moveToElement(GetQuoteButton).perform();
		GetQuoteButton.click();

		try {
			@SuppressWarnings("unused")
			WebElement errorMessage1 = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]"));
			// Element found
			System.out.println("Element exists.");
		} catch (NoSuchElementException e) {
			// Element not found
			System.out.println("Element does not exist.");
		}

// Perform a Positive test for Travel Information
		try {
			FileInputStream fis = new FileInputStream("E:\\Technical_Assignment-main\\New Folder\\Data.xlsx");
			Workbook workbook = new XSSFWorkbook(fis);
			Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the Second sheet

			// Read data from Excel and use it for selecting country of travel
			Row row = sheet.getRow(1); // Assuming data is in the first row
			Cell cell = row.getCell(0); // Assuming data is in the first column
			String country = cell.getStringCellValue();

			// Selecting a country of travel from the dropdown menu.
			WebElement whereAreYouTravelling = driver.findElement(By.xpath(
					"/html/body/app-root/div/div/div/app-product-pgt/div/div/div[4]/div/div/div[1]/app-questions-field/div/div/div/div/div/div[1]/div[2]/div/div/div[1]/div/div/app-questions-container[1]/div/app-select/div/div[2]/div/div/ng-select/div/span"));
			whereAreYouTravelling.click();
			WebElement whereAreYouTravellingInput = driver.findElement(By.xpath(
					"/html/body/app-root/div/div/div/app-product-pgt/div/div/div[4]/div/div/div[1]/app-questions-field/div/div/div/div/div/div[1]/div[2]/div/div/div[1]/div/div/app-questions-container[1]/div/app-select/div/div[2]/div/div/ng-select/div/div/div[2]/input"));
			whereAreYouTravellingInput.sendKeys(country);
			whereAreYouTravellingInput.sendKeys(Keys.ENTER);

			// Read data for departure date
			Row rowDepartureDateXPath = sheet.getRow(1); 
			Cell cellDepartureDateXPath = rowDepartureDateXPath.getCell(1); 
																			
			String departureDateXPath = cellDepartureDateXPath.getStringCellValue();

			// Selecting the departure date from the date picker.
			WebElement departureDate = driver.findElement(By.xpath(
					"/html/body/app-root/div/div/div/app-product-pgt/div/div/div[4]/div/div/div[1]/app-questions-field/div/div/div/div/div/div[1]/div[2]/div/div/div[1]/div/div/app-questions-container[2]/div/app-date/div/div[2]/div/input"));
			departureDate.click();
			WebElement departureDateElement = driver.findElement(By.xpath(departureDateXPath));
			departureDateElement.click();

			// Clicking the leaving date element based on the provided XPath
			WebElement leavingDate = driver.findElement(By.xpath(
					"/html/body/app-root/div/div/div/app-product-pgt/div/div/div[4]/div/div/div[1]/app-questions-field/div/div/div/div/div/div[1]/div[2]/div/div/div[1]/div/div/app-questions-container[3]/div/app-date/div/div[2]/div/input"));
			leavingDate.click();

			// Read data for leaving date XPath
			Row rowLeavingDateXPath = sheet.getRow(1);
			Cell cellLeavingDateXPath = rowLeavingDateXPath.getCell(2);
			String leavingDateXPath = cellLeavingDateXPath.getStringCellValue();

			// Locating the leaving date element on the web page using the provided XPath
			WebElement leavingDateElement = driver.findElement(By.xpath(leavingDateXPath));
			leavingDateElement.click();

			// Read data for primary traveler age
			Row rowPrimaryAge = sheet.getRow(1);
			Cell cellPrimaryAge = rowPrimaryAge.getCell(3);
			double primaryAge = cellPrimaryAge.getNumericCellValue();

			// Read data for secondary traveler age
			Row rowSecondaryAge = sheet.getRow(1);
			Cell cellSecondaryAge = rowSecondaryAge.getCell(4);

			double secondaryAge = cellSecondaryAge.getNumericCellValue();

			// Convert numerical values to strings
			String primaryAgeString = String.valueOf((int) primaryAge);
			String secondaryAgeString = String.valueOf((int) secondaryAge);

			// Enter primary traveler age
			WebElement primaryAgeInput = driver.findElement(By.id("70_157_1393-ipt"));
			primaryAgeInput.clear();
			primaryAgeInput.sendKeys(primaryAgeString);

			// Enter Secondary Traveller Age
			WebElement additionalAgeInput = driver.findElement(By.id("70_157_1518age0-ipt"));
			additionalAgeInput.clear();
			additionalAgeInput.sendKeys(secondaryAgeString);

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			actions.moveToElement(GetQuoteButton).perform();
			GetQuoteButton.click();

			// Close workbook and file input stream
			workbook.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
