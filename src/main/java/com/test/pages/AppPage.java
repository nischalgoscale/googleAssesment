/*
 * @author Nischal
 * 
 */

package com.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.test.common.CommonPageFunctions;

public class AppPage extends CommonPageFunctions{
	
	public AppPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@name='q']")
	private WebElement GoogleSearchField;
	

	@FindBy(xpath = "//ul[@role='listbox']/li")
	private List<WebElement> GoogleSearchSuggestions;


	public void openApplication(){
		driver.get("https://www.google.com");
	}
	
	public void enterTextInSearchBox(String keyToSearch){
		GoogleSearchField.sendKeys(keyToSearch);
	}
	
	public void findDataInSuggestionList(String keyToSearch){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		List allOptions = driver.findElements(By.xpath("//ul[@role='listbox']/li"));
		
		for (int i = 0; i < allOptions.size(); i++) {
			String option = ((WebElement) allOptions.get(i)).getText();
			System.out.println(option);
			Assert.assertTrue(option.contains(keyToSearch), "Option doesn't contain searched key");
		}
	}
}
