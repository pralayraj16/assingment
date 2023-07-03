package session.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;
import session.base.TestCasebase;
import session.modules.FlightModule;
import session.modules.HomePageModule;
import session.pageobjects.FlightPageObject;
import session.pageobjects.HomePageObject;
import session.pageobjects.PurchasePageObject;
import session.utils.PropertiesUtils;

public class Test1 extends TestCasebase{

	
	@Test
	public void test1() {
		HomePageModule homepage = new HomePageModule(driver);
		driver.get(PropertiesUtils.getPropValue("url"));
		//Title Assert
		assertEquals("Welcome to the Simple Travel Agency!", homepage.getTitle());
		homepage.openBeach();
		assertTrue(driver.getCurrentUrl().contains("vacation"));
		driver.navigate().back();
		homepage.searchFLight("Mexico City", "London");
		FlightModule flight = new FlightModule(driver);
		flight.clickLowestPriceFlight();
		assertEquals(flight.getFormattedPrice(), flight.getPrice());
		flight.purchase();
		String orderId = flight.getOrderId();
		System.out.println(orderId);
	}
	
}
