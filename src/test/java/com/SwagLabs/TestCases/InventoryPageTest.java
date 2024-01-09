package com.SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryPageTest extends BaseClass {
	
	
  @Test(priority=1)
  public void verifyProductCount() 
  {
	  int count =ip.getProductCount();
	  Assert.assertEquals(count,6,"Product count not matched");
	  System.out.println("Product count is as expected!");
	  System.out.println("Total products are: "+count);
	  
  }
  @Test(priority=2)
  public void verifyProductName() 
  {
	  ip.getProductName();
  }
  @Test(priority=3)
  public void verifyAddToCart() 
  {
	  ip.addToCart("Sauce Labs Fleece Jacket");
  }
}
//If you run this ,it will show error but no exception bcz fEs() doesnt throw an exception.
//error bcz login isnt done ..prerequisite--inventory page is completly dependent on loginpage.--only before 1st tc login shd be completed -@bc
//relation btn pages.
//dependency can be added with the help of annotations..(add dependency btn the tc,not in between class(dependenymethod)