package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	WebDriver driver;
	@FindBy(css="span.title")
	WebElement pageHeader;

	@FindBy(id="first-name")
	WebElement fName;
	
	@FindBy(id="last-name")
	WebElement lName;
	
	@FindBy(id="postal-code")
	WebElement postalCode;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	@FindBy(id="finish")
	WebElement finisheBtn;
	
	@FindAll({@FindBy(how=How.CSS,using="summary_value_label")})
	
	List<WebElement> orderConfirm;
	
	public CheckoutPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isCheckoutHeaderDisp() {
		return pageHeader.isDisplayed();
	}
	
	public void Checkout(String strFName,String strLName,String strPostCde) {
		fName.sendKeys(strFName);
		lName.sendKeys(strLName);
		postalCode.sendKeys(strPostCde);
		continueBtn.click();
	}
	
	public boolean isItemsOrdered() {
		if(orderConfirm.size()>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	
	 public void finish() {
		 
			 finisheBtn.click();
		 }
	 
	
	

}
