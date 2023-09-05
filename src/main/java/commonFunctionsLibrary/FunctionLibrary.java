package commonFunctionsLibrary;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.PropertyFileUtils;

public class FunctionLibrary {
	

	
	
	//Method to start the browser
	public static WebDriver startBrowser() throws Throwable {
		
		
		
		//Initiate driver
		  System.setProperty("webdriver.chrome.driver","E:\\New Project\\Project_Rebilling\\drivers"); 
		  ChromeDriver driver = new ChromeDriver();
		  
		  //Go to home page 
		  driver.get("http://10.98.4.114:4200/login");
		  
		  
		  //Maximize the window 
		  driver.manage().window().maximize();
		  
		  //waiting an element
		  driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		  
		  
		return driver;
		  
		  
		  }
		/*
		 * //If the test browser fire fox else
		 * if(utilities.PropertyFileUtils.getValueForKey("Browser").equalsIgnoreCase(
		 * "firefox")){ System.setProperty(
		 * "webdriver.gecko.driver","E:\\New Project\\Project_Rebilling\\drivers\\geckodriver.exe"
		 * );
		 * 
		 * driver=new FirefoxDriver(); }
		 */
		
		
		
		
		/* else if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("ie")){
		 * System.setProperty("webdriver.internetexplorer.driver",System.getProperty(
		 * "user.dir")+"\\ProjectMavenStorageTest\\drivers\\IEDriverServer.exe");
		 * driver=new InternetExplorerDriver(); 
		 * }*/
		 	
			
			
	
			
		
	//Method to open the application 
	public static void openApplication(WebDriver driver) throws Throwable {
		
		//PropertyFileUtil class uses to get the static value.
		driver.get(PropertyFileUtils.getValueForKey("Url"));
		
		//To maximize the browser test window.
		driver.manage().window().maximize();
	} 
	
	
	//Method for waiting an element or unable to locate the element
	public static void waitForElement(WebDriver driver, String locatorType, String locatorValue) {
		
		
	
		//Create an instance to access WebDriverWait class methods. WebDriverWait
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 
		
		//To find the element which locator we are using out of eight locators of selenium.  
		if(locatorType.equalsIgnoreCase("id")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
		}
		
		else if(locatorType.equalsIgnoreCase("name")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
		}
		
		else if(locatorType.equalsIgnoreCase("xpath")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			
		}
		
		else if (locatorType.equalsIgnoreCase("tagName")) {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
			
		}
		
		else if(locatorType.equalsIgnoreCase("className")) {
			
			
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
			
		}
		
		else if(locatorType.equalsIgnoreCase("linkText")) {
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
			
		}
		
		
		else if(locatorType.equalsIgnoreCase("cssSelector")) {
			
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(locatorValue)));
			
		}
			
		
			else {
				
				System.out.println("unable to locate element waitForElement method ");
				
				
			}
			
		}
	
	
	//Method for performing typing action for any text box
	public static void typeAction(WebDriver driver, String locatorType, String locatorValue, String testData ) {
		
		
		//To find the element which locator we are using out of eight locators of selenium.
		if(locatorType.equalsIgnoreCase("id")) {
			
			driver.findElement(By.id(locatorValue)).clear();
			driver.findElement(By.id(locatorValue)).sendKeys(testData);
			
		}
		
		else if(locatorType.equalsIgnoreCase("name")) {
			
			driver.findElement(By.name(locatorValue)).clear();
			driver.findElement(By.name(locatorValue)).sendKeys(testData);
			
		}
		
		else if(locatorType.equalsIgnoreCase("xpath")) {
			
			driver.findElement(By.xpath(locatorValue)).clear();
			driver.findElement(By.xpath(locatorValue)).sendKeys(testData);
		}
		
		else if(locatorType.equalsIgnoreCase("tagName")) {
			
			
			driver.findElement(By.tagName(locatorValue)).clear();
			driver.findElement(By.tagName(locatorValue)).sendKeys(testData);
		}
		
		else if(locatorType.equalsIgnoreCase("className")) {
			
			driver.findElement(By.className(locatorValue)).clear();
			driver.findElement(By.className(locatorValue)).sendKeys(testData);
			
		}
			
		else if(locatorType.equalsIgnoreCase("linkText")) {
			
			driver.findElement(By.linkText(locatorValue)).clear();
			driver.findElement(By.linkText(locatorValue)).sendKeys(testData);
		}
		
		
		else if(locatorType.equalsIgnoreCase("cssSelector")) {
			
			driver.findElement(By.cssSelector(locatorValue)).clear();
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(testData);
			
		}

		
		else {
			
			System.out.println("Locator not matching of typeAction method");
		}
		
	}
		
		//Method to perform click action to any button and link
		public static void clickAction(WebDriver driver, String locatorType, String locatorValue) {
			
			if(locatorType.equalsIgnoreCase("id")) {
				
			driver.findElement(By.id(locatorValue)).sendKeys(Keys.ENTER);
			
			
		}
			
			else if(locatorType.equalsIgnoreCase("xpath")) {
				
				driver.findElement(By.xpath(locatorValue)).click();
			}
			
			
			else if(locatorType.equalsIgnoreCase("name")) {
				
				driver.findElement(By.name(locatorValue)).click();
			}
			
			else if(locatorType.equalsIgnoreCase("linkText")) {
				
				driver.findElement(By.linkText(locatorValue)).sendKeys(Keys.ENTER);
				
				
			}
			
			
			else if(locatorType.equalsIgnoreCase("tagname")) {
				
				
				driver.findElement(By.tagName(locatorValue)).click();
				
			}
			
			
			else if(locatorType.equalsIgnoreCase("className")) {
				
				driver.findElement(By.className(locatorValue)).sendKeys(Keys.ENTER);
				
				
			}
			
			else if(locatorType.equalsIgnoreCase("partialLinkText")) {
				
				driver.findElement(By.partialLinkText(locatorValue)).click();
				
			}
			
			
			else {
				
				System.out.println("locator not matching of clickAction method");
				
			}
			
			
			
		}
		
		
		/*
		 * //Method to take screen shots for any bug analysis. public static void
		 * screenShot() throws Throwable {
		 * 
		 * //call getScreenshotAS method to take image file of any defect/bug/error.
		 * File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * 
		 * //Move image in the new location. File destfile = new
		 * File(System.getProperty("user.dir")+"\\Project_Rebilling\\Screenshots"
		 * +FunctionLibrary.generateDate()+".png");
		 * 
		 * //copy file to the destination FileUtils.copyFile(srcfile, destfile);
		 * 
		 * }
		 */
		
		
		//Method for capturing the current system date at time of generating test reports 
		public static String generateDate(){
			
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_dd_ss");
			
		 return sdf.format(date);
		 
		}
		
		//Method to close the browser
		public static void closeBrowser(WebDriver driver){
			
			driver.close();
			
		}
		
		
	
		
		
	}




