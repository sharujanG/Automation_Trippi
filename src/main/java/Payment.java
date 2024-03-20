import java.io.FileInputStream;
import java.io.IOException;

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

public class Payment {
	public void payment(WebDriver driver) {
		Actions actions = new Actions(driver);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Find the input field for the last name and input the last name into it
		try {
			FileInputStream payment = new FileInputStream("E:\\Technical_Assignment-main\\New Folder\\Data.xlsx");
			Workbook workbook = new XSSFWorkbook(payment);
			Sheet sheet = workbook.getSheetAt(3); // Assuming data is in the Third sheet

			// Finding the field and importing the card number from the Excel sheet
			Row rowCardNumber = sheet.getRow(1);
			Cell cellCardNumber = rowCardNumber.getCell(0);
			String cardNumber = cellCardNumber.getStringCellValue();

			WebElement cardNumberField = driver.findElement(By.xpath(
					"/html/body/div/div/div/div[1]/div/div/div/div/div/div/form/div/div[1]/div[1]/div/div/div/div[1]/input"));
			cardNumberField.click();
			cardNumberField.sendKeys(cardNumber);

			// Finding the field and importing the expiration Date from the Excel sheet
			Row rowExpiration = sheet.getRow(1);
			Cell cellExpiration = rowExpiration.getCell(1);
			String expiration = cellExpiration.getStringCellValue();

			WebElement expirationField = driver.findElement(By.id("Field-expiryInput"));
			expirationField.click();
			expirationField.sendKeys(expiration);

			// Finding the field and importing the cvc from the Excel sheet
			Row rowCvc = sheet.getRow(1);
			Cell cellCvc = rowCvc.getCell(2);
			String cvc = cellCvc.getStringCellValue();

			WebElement cvcField = driver.findElement(By.id("Field-cvcInput"));
			cvcField.click();
			cvcField.sendKeys(cvc);

			// Selecting a country of travel from the dropdown menu.
			// Read data from Excel and use it for selecting country of travel
			Row rowCountry = sheet.getRow(1); // Assuming data is in the first row
			Cell cellCountry = rowCountry.getCell(3); // Assuming data is in the third column
			String country = cellCountry.getStringCellValue();

			WebElement countryField = driver.findElement(By.id("Field-countryInput"));
			countryField.click();
			countryField.sendKeys(country);
			countryField.sendKeys(Keys.ENTER);

			// Click the payment detail button.
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			WebElement payButton = driver.findElement(By.id("button-text"));
			actions.moveToElement(payButton).perform();
			payButton.click();

			workbook.close();
			payment.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
