package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	//Encapsulation=data(private)+method(public)
	
	private WebDriver driver;
	
	//Initialization of driver
	
	public LoginPage(WebDriver driver)//Base class
	{
		this.driver=driver;
		
	}
	//Locators
	
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginbtn = By.id("login-button");
	
	
	//Methods
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public String getAppTitle() {
		return driver.getTitle();
	}
	
	public String doLogin(String un,String psw)
	{
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(psw);
		driver.findElement(loginbtn).click();
		String curl=driver.getCurrentUrl();
		return curl;
	}

}
