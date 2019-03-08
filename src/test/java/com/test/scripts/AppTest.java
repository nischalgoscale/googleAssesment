package com.test.scripts;


import org.testng.annotations.Test;

import com.test.common.CommonTestFunctions;

public class AppTest extends CommonTestFunctions{
	
	
	
  @Test
  public void googletest() throws InterruptedException 
  {
	
	reportLog("Navigate to Google");
	apppage.openApplication();
	
	reportLog("Enter Wedding Keyword");
	apppage.enterTextInSearchBox("wedding");
	
	reportLog("Select all options in list and assert that all option contain search keyword");
	apppage.findDataInSuggestionList("wedding");
  }


}