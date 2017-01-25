package com.saleforcecrm.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class InvalidLoginTest {
	static WebDriver driver;
	static String baseUrl;
	@BeforeTest
	public static void setup() throws Exception 
	{
	    driver = new FirefoxDriver();
	    
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   // driver.get(baseUrl);
	}
  
  @Test
  public void f() throws Exception {
	  baseUrl = "https://login.salesforce.com/";
	  driver.get(baseUrl);
	  	WebElement UN = driver.findElement(By.xpath("//*[@id='username']"));
		String userName="umaganesan24@gmail.com";
		enterText(UN,userName,"UserName Feild");
		
		
		WebElement PW = driver.findElement(By.id("password"));
		String password="";
		enterText(PW,password,"Password Feild");
		
		WebElement login=driver.findElement(By.id("Login"));
		clickObj(login,"Login");
		
		WebElement actual= driver.findElement(By.id("error"));
		validateMsg(actual,"Please enter your password.","Error Message");
		Thread.sleep(4000);
		//driver.close();
  }
  public static void enterText(WebElement obj,String textval, String objName)
	{
		if(obj.isDisplayed())
		{
		obj.clear();
		obj.sendKeys(textval);
		System.out.println("Pass:"+objName+" is displayed");
		}
		else
			System.out.println("Fail:"+objName+" is not displayed");
			
	}
public static void clickObj(WebElement obj,String objName)
	{
		if(obj.isDisplayed())
		{
			obj.click();
			System.out.println("Pass:" +objName+" is clicked.");
		}
		else
			System.out.println("Fail:"+objName+" is not displayed");
	}
public static void validateMsg(WebElement obj,String expectedText, String objName)
	{
		if(obj.isDisplayed())
		{
			String actual=obj.getText().trim();
			if(actual.equals(expectedText))
			{
				System.out.println("Pass:Actual Text matches with the expected Text '"+actual+"'");
			}
			else
				System.out.println("Fail:Actual Text '"+actual+"' doesnot match with the expected text '"+expectedText+"'");
		}
		else
			System.out.println("Fail: "+objName+" is not displayed");
	}
}
