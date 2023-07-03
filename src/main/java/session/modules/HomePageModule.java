package session.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import session.pageobjects.HomePageObject;

public class HomePageModule {
	WebDriver driver;
	public HomePageModule(WebDriver driver) {
		this.driver = driver;
	}

	public void searchFLight(String from, String to) {
		new Select(driver.findElement(HomePageObject.selectFromPort)).selectByVisibleText(from);
		new Select(driver.findElement(HomePageObject.selectToPort)).selectByVisibleText(to);
		driver.findElement(HomePageObject.btn_FindFlights).click();
	}
	
	public String getTitle() {
		return driver.findElement(HomePageObject.titleText).getText();
	}
	
	public void openBeach(){
		driver.findElement(HomePageObject.lnkBeach).click();
		}
}

