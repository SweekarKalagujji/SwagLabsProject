package com.SwagLabs.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage 
{
	private WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}
	private By cart=By.xpath("//a[@class='shopping_cart_link']");
	private	By remove=By.xpath("//button[text()='Remove']");
	private	By continueshop=By.xpath("//button[text()='Continue Shopping']");
	private	By checkout= By.xpath("//button[text()='Checkout']");
	
	
	//Methods
	public void getCartPage() {
		driver.findElement(cart).click();
		System.out.println("Cart page is open!");
	}
	
	public void doRemove() {
		driver.findElement(remove).click();
		System.out.println("Selected product gets removed!");
	}
	public void doContinueShopping() {
		driver.findElement(continueshop).click();
		System.out.println("Inventory page open: select Product");
	}
	public String doCheckOut() {
		driver.findElement(checkout).click();
		return driver.getCurrentUrl();
	}
	

}
