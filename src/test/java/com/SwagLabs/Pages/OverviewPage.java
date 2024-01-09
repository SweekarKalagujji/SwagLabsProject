package com.SwagLabs.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage {
	private WebDriver driver;
	public OverviewPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//locators
	private By summary=By.xpath("//div[@class='summary_info']//div[contains(@class,'summary')]");
	private By finish=By.id("finish");
	private By msg=By.tagName("h2");
	
	
	public void getSumarry() {
		List<WebElement>all=driver.findElements(summary);
		//System.out.println(all);
		for(WebElement i:all) {
			System.out.println(i.getText());
		}
		
	}
	public void doFinish() {
		driver.findElement(finish).click();
		String text=driver.findElement(msg).getText();
		System.out.println("Final status is: "+text);
	}

}
