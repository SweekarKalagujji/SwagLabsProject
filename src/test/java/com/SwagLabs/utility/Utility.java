package com.SwagLabs.utility;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility 
{

	public static void getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		  File temp=ts.getScreenshotAs(OutputType.FILE);

		  //location
		  File dest=new File("./"+"\\Screenshots\\SwagLab"+System.currentTimeMillis()+".png");

		  try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	//Javascript methods
	public static void scrollDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

	}

	public static void scrollUp(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");

	}

	public static void scrollToElement(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",ele);

	}




	//WebDriverWait()=Explicit Wait

	public static WebElement waitForPresenceOfElement(WebDriver driver,By loc)
	{
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(5));
		return obj.until(ExpectedConditions.presenceOfElementLocated(loc));
	}

	public static WebElement waitForElementClickable(WebDriver driver,By loc)
	{
		WebDriverWait btnobj=new WebDriverWait(driver,Duration.ofSeconds(5));
		return btnobj.until(ExpectedConditions.elementToBeClickable(loc));
	}

	public static WebElement waitForVisibilityOfElement(WebDriver driver,By loc)
	{
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(5));
		return obj.until(ExpectedConditions.visibilityOfElementLocated(loc));
	}


	public static boolean waitForUrlContains(WebDriver driver,String url)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.urlContains(url));

	}

	public static boolean waitForTitleContains(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.titleContains(title));

	}




	//Select based drop down
	public static void selectBasedDropdown(WebElement ele,String value)
	{
		Select dd=new Select(ele);

		System.out.println("Is dropdown support mutiple selection: "+dd.isMultiple());

		List<WebElement> allOptions=dd.getOptions();

		System.out.println("Total Options are: "+allOptions.size());

		for(WebElement i:allOptions)
		{
			System.out.println(i.getText());
			if(i.getText().contains(value))
			{
				i.click();
				break;
			}
		}
	}


}