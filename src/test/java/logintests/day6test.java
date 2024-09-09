package logintests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day6test {
	@Test(dataProvider = "getData")
	public void validateLoginAttempt(String username, String password) throws IOException {
		// Launching Chrome browser and accessing the baseURL
		util.launchChrome();

		// Adding some waiting time so page is loaded properly
		util.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		util.driver.findElement(By.name("uid")).sendKeys(username);
		util.driver.findElement(By.name("password")).sendKeys(password);

		try {
			util.driver.findElement(By.name("btnLogin")).click();
			util.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			Alert alert = util.driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.accept();
		}

		catch (NoAlertPresentException e) {
			String title = util.driver.getTitle();

			// Verifying the title of the homepage
			Assert.assertEquals(title, "Guru99 Bank Manager HomePage");

			getScreenshot();
		}

		util.driver.quit();

	}

	public void getScreenshot() throws IOException {
		// Creating object of TakesScreenshot
		TakesScreenshot screenshot = (TakesScreenshot) util.driver;

		// Creating File object to get screenshot as a file
		File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);

		// Creating a file for storing the above screenshot file
		File image = new File(
				"G:\\Eclispse Folder\\eclipse\\Khushboo Eclipse Workspace\\BankTestProject1\\Screenshots\\Image1.png");

		// Writing file from source to target location
		FileUtils.copyFile(screenshotFile, image);
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[4][2];

		obj[0][0] = "mngr580704";
		obj[0][1] = "qujarEp";
		obj[1][0] = "mngr580704";
		obj[1][1] = "a123456";
		obj[2][0] = "abcde";
		obj[2][1] = "qujarEp";
		obj[3][0] = "abcde";
		obj[3][1] = "a123456";

		return obj;

	}

}
