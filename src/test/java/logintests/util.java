package logintests;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class util {

	// declaration and initialization of the driver object
	public static ChromeDriver driver;

	// declaration and initialization of the URL variable
	public static final String baseURL = "http://www.demo.guru99.com/V4/";

	// initializing the location variable
	public static final String chromelocation = "G:\\ChromeWebDriver\\chromedriver-win64\\chromedriver.exe";

	public static String username = "mngr580704";
	public static String password = "qujarEp";

	public static void launchChrome() {
		System.setProperty("webdriver.chrome.driver", chromelocation);
		
		/*DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);*/
		driver= new ChromeDriver();
		
		driver.get(baseURL);
		//driver.manage().window().maximize();
	}

	public static String readDataFromExcelFile(int rownumber, int cellnumber) throws InvalidFormatException, IOException
	
	{
		
		//Create file class object
		File file= new File("G:\\Extra Docs\\Testdatafile.xlsx");
		
	    //Create object of XSSFWorkbook class to access the MS Excel file
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		//Create object of the XSSFSheet class to access the required sheet in the workbook
		XSSFSheet sheet= workbook.getSheetAt(0);
			
	    //Create object of XSSFRow class to point to the required row in the sheet
		XSSFRow row= sheet.getRow(rownumber);
			
		//Accessing data in the particular cell in the row
		String data = row.getCell(cellnumber).getStringCellValue();
			
		//returning the value of the cell
		return data;
		
	}
		
	
	
}
