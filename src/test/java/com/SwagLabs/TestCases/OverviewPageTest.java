package com.SwagLabs.TestCases;

import org.testng.annotations.Test;

import com.SwagLabs.utility.Utility;


public class OverviewPageTest extends BaseClass {
  @Test(priority=1)
  public void verifySumarry() {
	  op.getSumarry();
	  Utility.getScreenshot(driver);
  }
  @Test(priority=2)
  public void verifyOverview() {
	  op.doFinish();
	  Utility.getScreenshot(driver);
  }
}
