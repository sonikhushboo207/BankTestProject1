

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	public class AfterLogin {

		@Test(dataProvider= "testData")
		public void loginviaDataProvider(String username, String password) {
			System.setProperty("webdriver.chrome.driver", "G:\\ChromeWebDriver\\chromedriver-win64\\chromedriver.exe");
			
			WebDriver driver= new ChromeDriver();
			
			driver.get("https://www.demo.guru99.com/V4/");
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			driver.findElement(By.name("uid")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			
			driver.findElement(By.name("btnLogin")).click();
			
			//Assert.assertEquals(false, null);

		}
		
		@DataProvider
		public Object testData()
		{
			Object [][] obj= new Object [4][2];
			
			obj[0][0]="mngr552483";
			obj[0][1]="mAvanUq";
			obj[1][0]="mngr552483";
			obj[1][1]="a123456";
			obj[2][0]="abcde";
			obj[2][1]="mAvanUq";
			obj[3][0]="abcde";
			obj[3][1]="a123456";
			
			return obj;
				}

	}


