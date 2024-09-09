package logintests;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class day4test {

	@Test
	public void loginFunction() throws InvalidFormatException, IOException {
		
		for(int i=1; i<5; i++)
		{
		System.out.println("Attempt no.: "+ i);
		String username = util.readDataFromExcelFile(i, 0);
		String password = util.readDataFromExcelFile(i, 1);
	
			
			//Launching Chrome browser and accessing the baseURL
			util.launchChrome();
			
			//Adding some waiting time so page is loaded properly
			util.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			util.driver.findElement(By.name("uid")).sendKeys(username);
			util.driver.findElement(By.name("password")).sendKeys(password);
			
			
	        try
			{
			util.driver.findElement(By.name("btnLogin")).click();
	        util.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
	        Alert alert= util.driver.switchTo().alert();
	        System.out.println(alert.getText());
	        alert.accept();
			}
			
			catch(NoAlertPresentException e)
			{
	        String title= util.driver.getTitle();
			
			//Verifying the title of the homepage
			Assert.assertEquals(title,"Guru99 Bank Manager HomePage");
			}
			
			util.driver.quit();
			
			
		}
		
		
		}	
}

	

