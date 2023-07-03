package session.pageobjects;

import org.openqa.selenium.By;

public class HomePageObject {
	public static By titleText = By.xpath("//div[@class='container']//h1");
	
	public static By lnkBeach = By.linkText("destination of the week! The Beach!");
	
	public static By selectFromPort = By.name("fromPort");
	public static By selectToPort = By.name("toPort");
	public static By btn_FindFlights=By.xpath("//input[@value='Find Flights']");
}
