package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	@FindAll({@FindBy(how=How.CSS,using="div.cart_item_label")})
	List<WebElement> items;
	
	@FindBy(id="checkout")
	WebElement chkOutBtn;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isItemsAdded() {
		if(items.size()>0) 
			{
				return true;
			}
			else
			{
				return false;
			}
		}
	 public void cheoutOrder() {
		 if(isItemsAdded()) {
			 chkOutBtn.click();
		 }
	 }
		
	}
