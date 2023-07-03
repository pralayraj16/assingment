package session.modules;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import session.pageobjects.FlightPageObject;
import session.pageobjects.PurchasePageObject;

public class FlightModule {
	WebDriver driver;
	public FlightModule(WebDriver driver) {
		this.driver = driver;
	}

	public void clickLowestPriceFlight() {
		driver.findElement(FlightPageObject.btnChooseFlight(getLowestFlightIndex())).click();
	}
	public int getLowestFlightIndex() {
		List<WebElement> elm = driver.findElements(FlightPageObject.flghtTablePrice);
		int index = 0;
		double lowestPrice = 0.0d;
		int lowPriceIndex = 0;
		for(WebElement el : elm) {
			double thisflightPrice = Double.parseDouble(el.getText().replace("$", "").trim());
			if(index ==0) {
				lowestPrice = thisflightPrice;
			}
			if(thisflightPrice < lowestPrice) {
				lowestPrice = thisflightPrice;
				lowPriceIndex = index;
			}
			index++;
		}
		return lowPriceIndex;
	}
	
	public String getPrice() {
		String price = driver.findElement(FlightPageObject.totalCostPrice).getText();
		return price;
	}
	public String getFormattedPrice() {
		String price = driver.findElement(FlightPageObject.totalCostPrice).getText();
		Double priceValue = Double.parseDouble(price);
		String formattedValue = String.format("%03.2f", priceValue);
		return formattedValue;
	}
	
	public void purchase() {
		driver.findElement(FlightPageObject.btnPurchase).click();
	}
	public String getOrderId() {
		return driver.findElement(PurchasePageObject.purchaseId).getText();
	}
}
