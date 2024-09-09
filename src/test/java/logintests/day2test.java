package logintests;

import java.time.Duration;

import org.openqa.selenium.By;

public class day2test {

	public static void main(String[] args) {
		
		util.launchChrome();
		
		util.driver.findElement(By.name("uid")).sendKeys(util.username);
		util.driver.findElement(By.name("password")).sendKeys(util.password);
		util.driver.findElement(By.name("btnLogin")).click();
		
		//Waiting for the page to load properly
		util.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		
		String title= util.driver.getTitle();
		
		//Verifying the title of the homepage
		if(title.equals("Guru99 Bank Manager HomePage"))
		{
			System.out.println("Testcase passed, User has successfully logged in.");
		}
		
		else
		{
			System.out.println("Testcase failed, Login unsuccessful");
		}
			
		
		

	}

}
