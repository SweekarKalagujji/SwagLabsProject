package com.SwagLabs.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseClass
{
  @Test(priority=1)
  public void verifyRemove() {
	  
	  cp.doRemove();
	  addWait();
  }
  
  @Test(priority=2)
  public void verifyContinueShopping() {
	  cp.doContinueShopping();
	  addWait();
	  ip.addToCart("Sauce Labs Fleece Jacket");
	  cp.getCartPage();
	  addWait();
	  
	  
  }
  
  @Test(priority=3)
  public void verifyCheckout() {
	 String url= cp.doCheckOut();
	  Assert.assertTrue(url.contains("checkout"),"Url not matched");
	  System.out.println("Checkout page is open");
	  
  }
}
