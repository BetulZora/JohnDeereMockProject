package JohnDeere.test.pages;

import JohnDeere.test.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class NavButtons {
    String primaryMenu="";

    public NavButtons() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (className = "nav-logo")
    public WebElement JDLogo;

    @FindBy (partialLinkText = "Home")
    public WebElement HomeBTN;

    @FindBy (partialLinkText = "Equipment")
    public WebElement equipmentBTN;
    @FindBy (partialLinkText = "Finance")
    public WebElement financeBTN;
    @FindBy (partialLinkText = "Parts & Service")
    public WebElement partsBTN;
    @FindBy (partialLinkText = "Digital")
    public WebElement digitalBTN;
    @FindBy (css = "a[href='/en/digital-tools/']")
    public WebElement digitalToolsOPT;
    @FindBy (partialLinkText = "Our Company & Purpose")
    public WebElement companyBTN;





    public WebElement hoverMenu(String menuName) throws NoSuchElementException {
        primaryMenu = menuName;
        if(primaryMenu.toLowerCase().equals("parts and services")||primaryMenu.toLowerCase().equals("parts and service")){
            primaryMenu = "Parts & Service";
        }

        if(primaryMenu.toLowerCase().equals("our company and purpose")){
            primaryMenu = "Our Company & Purpose";
        }

        switch (primaryMenu){
            case "Equipment":
                return equipmentBTN;
            case "Finance":
                return financeBTN;
            case "Parts & Service":
                return partsBTN;
            case "Digital":
                return digitalBTN;
            case "Our Company & Purpose":
                return companyBTN;
            default:
                throw new NoSuchElementException("Wrong Menu Item Chosen");
        }





    }

    public void hoverOnMenu(String menuName) throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(hoverMenu(menuName)).perform();
        Thread.sleep(500);
    }

    public void findSubmenu(String submenu){

//<a data-menu-category="Our Company &amp; Purpose" class="secondary-link"
// href="https://about.deere.com/en-us/our-company-and-purpose/customer-support-and-advocacy/"
// data-target="nav-tier3-customer-support-and-advocacy" aria-label="Our Company &amp; Purpose - Customer Support &amp;
// Advocacy">Customer Support &amp; Advocacy<span class="icon-jd_carrot_right"></span></a>
 String locator="";


    }



}
