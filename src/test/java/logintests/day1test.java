package logintests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class day1test {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "G:\\ChromeWebDriver\\chromedriver-win64\\chromedriver.exe");
		
		ChromeDriver driver= new ChromeDriver();
		
		driver.get("http://www.demo.guru99.com/V4/");
		
		//mngr576761 zusAdyd
		
		//Enter username in the username textbox
		driver.findElement(By.name("uid")).sendKeys("mngr576761");
		
		//Enter password in the password textbox
		driver.findElement(By.name("password")).sendKeys("zusAdyd");
		
		//Click LOGIN button
		driver.findElement(By.name("btnLogin")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		
		//Check if the user has logged-in to the website by verifying the accessed page
		String currentURL= driver.getCurrentUrl();
		
		if(currentURL.equalsIgnoreCase("https://www.demo.guru99.com/V4/manager/Managerhomepage.php"))
		{
			System.out.println("Login Successful");
		}
		
		else
		{System.out.println("Login not successful");
		

	}

}
}
