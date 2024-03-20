import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChooseYourPlan {
	public void chooseYourPlan(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(500));
		Actions actions = new Actions(driver);
		// implementing a Try catch block to wait until the "Choose your plane" page is
		// loaded

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Select an excess amount.
		try {
			FileInputStream plan = new FileInputStream("E:\\Technical_Assignment-main\\New Folder\\Data.xlsx");
			Workbook workbook = new XSSFWorkbook(plan);
			Sheet sheet = workbook.getSheetAt(1);

			Row rowExcessAmount = sheet.getRow(1);
			Cell cellExcessAmount = rowExcessAmount.getCell(0);
			String axcessAmountXpath = cellExcessAmount.getStringCellValue();

			WebElement axcessAmount = driver.findElement(By.xpath(axcessAmountXpath));
			axcessAmount.click();

			// Selecting packages.
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Finding the package dropdown
			Row rowPackage1 = sheet.getRow(1);
			Cell cellPackage1 = rowPackage1.getCell(1);
			String packageDropdown = cellPackage1.getStringCellValue();

			WebElement package1 = driver.findElement(By.xpath(packageDropdown));
			package1.click();

			// Pick Trip Cancellation And Interruption package switch
			Row rowCancellation = sheet.getRow(1);
			Cell cellCancellation = rowCancellation.getCell(2);
			String cancellationSwitchXpath = cellCancellation.getStringCellValue();

			WebElement cancellation = driver.findElement(By.xpath(cancellationSwitchXpath));
			cancellation.click();

			// Disabling the baggage package switch.
			Row rowBaggageSwitch = sheet.getRow(1);
			Cell cellBaggageSwitch = rowBaggageSwitch.getCell(3);
			String baggageSwitchXpath = cellBaggageSwitch.getStringCellValue();

			WebElement baggagePackage = driver.findElement(By.xpath(baggageSwitchXpath));
			baggagePackage.click();

			// Activating Rental Vehicle Damage Package
			Row rowDamageSwitch = sheet.getRow(1);
			Cell cellDamageSwitch = rowDamageSwitch.getCell(4);
			String vechileDamageXpath = cellDamageSwitch.getStringCellValue();

			WebElement vechileDamagePackage = driver.findElement(By.xpath(vechileDamageXpath));
			vechileDamagePackage.click();

			// finding the More Info Button
			Row rowMoreInfo = sheet.getRow(1);
			Cell cellMoreInfo = rowMoreInfo.getCell(5);
			String moreInfoXpath = cellMoreInfo.getStringCellValue();

			WebElement moreInfo = driver.findElement(By.xpath(moreInfoXpath));
			moreInfo.click();

			// Checking if the tip message popup appeared.
			try {
				Row rowTipMessage = sheet.getRow(1);
				Cell cellTipMessage = rowTipMessage.getCell(6);
				String tipMessageButtonXpath = cellTipMessage.getStringCellValue();

				@SuppressWarnings("unused")
				WebElement tipMessage = driver.findElement(By.xpath(tipMessageButtonXpath));

				// Element found
				System.out.println("Tip Message exists.");
			} catch (NoSuchElementException e) {
				// Element not found
				System.out.println("Tip Message does not exist.");
			}

			// Activating Snow Package.
			Row rowSnowPackage = sheet.getRow(1);
			Cell cellSnowPackage = rowSnowPackage.getCell(7);
			String snowPackageXpath = cellSnowPackage.getStringCellValue();

			WebElement snowPackage = driver.findElement(By.xpath(snowPackageXpath));
			snowPackage.click();

			// Click the "Buy Now" button.
			Row rowBuyNowButton = sheet.getRow(1);
			Cell cellBuyNowButton = rowBuyNowButton.getCell(8);

			String buyNowButtonXPath = cellBuyNowButton.getStringCellValue();

			WebElement buyNowButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buyNowButtonXPath)));

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			actions.moveToElement(buyNowButton).perform();
			buyNowButton.click();

			// Close workbook and file input stream
			workbook.close();
			plan.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
