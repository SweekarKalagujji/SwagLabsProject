package com.SwagLabs.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage
{
	private WebDriver driver;
	
	public InventoryPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	//Locator
	
	private By plist =By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']");
	private By pnlist=By.xpath("//div[@class='inventory_item_name ']");
	private By addbtn=By.xpath("//button[text()='Add to cart']");
	
	
	//Methods
	public int getProductCount()
	{
		int count =driver.findElements(plist).size();
		return count;
		
	}
	public void getProductName()
	{
		List<WebElement>list=driver.findElements(pnlist);
		System.out.println("********************Product names are**********************");
		for(WebElement i:list) {
			System.out.println(i.getText());
		}
	}
	
	public void addToCart(String pname) {
		
		List<WebElement>allProduct=driver.findElements(pnlist);
		for(WebElement i:allProduct) {
		if(i.getText().contains(pname)) {
			i.click();
			break;
		}
	}
		//add the product
		driver.findElement(addbtn).click();
		System.out.println("Product added: "+pname);
		
	}}


	


