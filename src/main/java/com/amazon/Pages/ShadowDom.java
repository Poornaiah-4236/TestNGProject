package com.amazon.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import com.base.Test.baseTest;

public class ShadowDom extends baseTest {
	public void shadowElements() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement shadowHost = baseTest.driver.findElement(By.id("shadow-host-id"));
		SearchContext serch =shadowHost.getShadowRoot();
		// Get the Shadow Root
		String script = "return arguments[0].shadowRoot";
		Object shadowRootObj = js.executeScript(script, shadowHost);

		// Locate element within Shadow DOM
		script = "return arguments[0].querySelector('.shadow-element')";
		WebElement elementInShadowDom = (WebElement) js.executeScript(script, shadowRootObj);

		// Perform action
		elementInShadowDom.click();
	}

	public WebElement getShadowElement() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement shadowHost = driver.findElement(By.xpath(""));
		String script = "return arguments[0].shadowRoot";
		Object shadowRootObj = js.executeScript(script, shadowHost);
		script = "returns arguments[0].querySelector('.shadow-element')";
		WebElement elementInShadowDom = (WebElement) js.executeScript(script, shadowRootObj);
		return elementInShadowDom;
	}

}
