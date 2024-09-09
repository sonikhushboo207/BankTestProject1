package logintests;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;

public class day3test {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		

		//Calling loginWithMultiData function and passing arguments using readDataFromExcelFile function
		for(int i=1; i<5; i++)
		{
		System.out.println("Attempt no.: "+ i);
		loginWithMultiData(util.readDataFromExcelFile(i, 0), util.readDataFromExcelFile(i, 1));
		}
		

	}
	
	public static void loginWithMultiData(String username, String password)
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
		if(title.equals("Guru99 Bank Manager HomePage"))
		{
			System.out.println("Testcase passed, User has successfully logged in.");
		}
		
		else	
		{
			System.out.println("Testcase failed, User has not been able to log in.");
		}
	
		}
		
		util.driver.quit();
		
	}
}
        
		
				
		
		
		
		
		

