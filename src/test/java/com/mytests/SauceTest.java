package com.mytests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceTest extends BrowserStackBaseTest {

	public void doLogin() {
		driver.get("https://www.saucedemo.com/index.html");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
	}

	@Test(priority = 1)
	public void checkInventoryItemTest() {
		doLogin();
		Assert.assertTrue(driver.findElements(By.cssSelector(".inventory_item")).size() == 6);
	}

	@Test(priority = 2)
	public void checkAddToCartButtonTest() {
		doLogin();
		Assert.assertTrue(driver.findElements(By.xpath("//button[text()='ADD TO CART']")).size() == 6);
	}

}
