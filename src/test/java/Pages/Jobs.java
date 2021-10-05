package  Pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Extent_Reports.ExtentReport;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Jobs
{
	
	 WebDriver driver;
	 
	ExtentTest logger;
	ExtentReports extent;
	String screenShotPath;
	String TestScriptName;
		
	public void Jobs(WebDriver driver,String TestScriptName,ExtentTest logger,ExtentReports extent)
		{
			this.driver = driver;
			this.logger=logger;
			this.extent=extent;
			this.TestScriptName=TestScriptName;
		}
		

	public  void AddJobs(String Jobs) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Job")).click();
		findElement(By.id("menu_admin_viewJobTitleList")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("jobTitle_jobTitle")).sendKeys("Sales6");
		findElement(By.id("jobTitle_jobDescription")).sendKeys("Sales6 desr");
		findElement(By.id("jobTitle_note")).sendKeys("Sales6 Note");
		findElement(By.id("btnSave"));
		screenShotPath = ExtentReport.capture(driver,TestScriptName);
		logger.pass("Job_Titles - Screenshot",MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		
		findElement(By.id("btnSave")).click();
		
	}
	
	
	public   WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		return elem;
	}


	
	}
	















