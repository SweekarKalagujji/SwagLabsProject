package com.SwagLabs.TestCases;

import org.testng.annotations.Test;

public class CheckOutPageTest extends BaseClass {
  @Test(priority=1)
  public void verifyCancel() 
  {
	  cop.doCancel();
	  addWait();
	  cp.doCheckOut();
  }
  @Test(priority=2)
  public void verifyCheckout() {
	  cop.doContinue("Sweekar","Kalagujji","571321");
	  
  }
}
