import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Summary {
	public void summary(WebDriver driver) {
		Actions actions = new Actions(driver);

		// Check the checkbox.
		WebElement checkBox = driver.findElement(By.xpath(
				"/html[1]/body[1]/app-root[1]/div[1]/div[1]/div[1]/app-product-pgt[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/app-questions-field[1]/div[1]/div[1]/div[4]/div[4]/app-questions-container[1]/div[1]/app-group[1]/div[1]/div[1]/div[1]/div[2]/div[5]/app-questions-container[1]/div[1]/app-checkbox[1]/div[1]/div[1]/div[1]/div[1]/div[1]/label[1]/div[1]/div[1]/span[1]"));
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchResult = wait2.until(ExpectedConditions.visibilityOf(checkBox));

		// Perform force click using JavaScript Executor
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", searchResult);

		// Click the next button.
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement nextButton2 = driver.findElement(By.xpath(
				"/html/body/app-root/div/div/div/app-product-pgt/div/div/div[4]/div/div/div[2]/div[1]/div/app-questions-field/div/div[1]/div[4]/div[5]/div[2]/button"));
		actions.moveToElement(nextButton2).perform();
		nextButton2.click();
	}
}
