package JohnDeere.test.pages;

import JohnDeere.test.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class NavButtons {

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
    @FindBy (partialLinkText = "Our Company & Purpose")
    public WebElement companyBTN;





    public WebElement hoverMenu(String menuName) throws NoSuchElementException {
        if(menuName.toLowerCase().equals("parts and services")||menuName.toLowerCase().equals("parts and service")){
            menuName = "Parts & Service";
        }

        if(menuName.toLowerCase().equals("our company and purpose")){
            menuName = "Our Company & Purpose";
        }

        switch (menuName){
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
        Thread.sleep(1000);
    }
    public void hoverOnMenu(WebElement element) throws InterruptedException {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
        Thread.sleep(1000);
    }


}
