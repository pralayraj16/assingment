package session.pageobjects;

import org.openqa.selenium.By;

public class FlightPageObject {

	public static By flghtTablePrice = By.xpath("//table/tbody/tr/td[6]");
	
	public static By btnChooseFlight(int index) {
		return By.xpath("(//table//input[@value='Choose This Flight'])["+(index+1)+"]");
	}
	
	public static By totalCostPrice =By.xpath("//p[contains(text(),'Total Cost:')]/em"); 
	public static By btnPurchase = By.xpath("//input[@value='Purchase Flight']");
}
