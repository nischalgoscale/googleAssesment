/*
 * @author adeeb
 */

package com.test.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CommonPageFunctions {
	
	protected WebDriver driver;

	protected String title;
	protected static final int DEFAULT_WAIT_4_ELEMENT = 30;
	protected static final int DEFAULT_WAIT_4_PAGE = 30;
	protected static final int DEFAULT_WAIT_MAXTIME = 900000000;
	protected static WebDriverWait ajaxWait;
	protected long timeout = 30;
	/*
	 * @Inject
	 * 
	 * @Named("framework.implicitTimeout") protected long timeout;
	 */

	public CommonPageFunctions(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * Click action performed and then wait
	 */

	// Handle locator type
	public By ByLocator(String locator) {
		By result = null;
		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.id(locator.replace("#", ""));
		} else if (locator.startsWith("name=")) {
			result = By.name(locator.replace("name=", ""));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else if (locator.startsWith("(//")) {
			result = By.xpath(locator);
		} else {
			result = By.className(locator);
		}
		return result;
	}

	
}