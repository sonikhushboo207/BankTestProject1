package logintests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class day5test {

	@Test(dataProvider= "getData")
	public void validateLoginAttempt(String username, String password)
	{
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
	
	
	@DataProvider
	public Object[][] getData()
	{
		Object [][] obj= new Object [4][2];
		
		obj[0][0]= "mngr580704";
		obj[0][1]= "qujarEp";
		obj[1][0]= "mngr580704";
		obj[1][1]= "a123456";
		obj[2][0]= "abcde";
		obj[2][1]= "qujarEp";
		obj[3][0]= "abcde";
		obj[3][1]= "a123456";
		
		return obj;
		
	}
	
}
