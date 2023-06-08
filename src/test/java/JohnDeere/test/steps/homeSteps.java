package JohnDeere.test.steps;

import JohnDeere.test.pages.ChildClass;
import JohnDeere.test.utils.ConfigurationReader;
import JohnDeere.test.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class homeSteps {
    ChildClass child;
    Actions actions;

    @Given("I go to the John Deere Home Page")
    public void i_go_to_the_john_deere_home_page() {
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("JDbaseURL"));

    }

    @Given("I hover over the {string} menu")
    public void i_hover_over_the_menu(String menuName) throws InterruptedException {
        child = new ChildClass();
        //actions = new Actions(Driver.getDriver());
        Thread.sleep(1000);
        child.hoverOnMenu(menuName);
        //actions.moveToElement(child.digitalBTN).perform();
        Thread.sleep(5000);
        //Assert.assertTrue();
    }

    @Given("I select the {string} option")
    public void i_select_the_option(String chosen) {

        // will use a switch case for simple menu

        switch(chosen){
            case "digital tools":
            case "Digital tools":
            case "Digital Tools":
            case "digital-tools":
            case "Digital-tools":
            case "Digital-Tools":
                child.digitalToolsOPT.click();
                break;

            case "Owner Information ":
            case "Owner Information":
                child.findSubmenu("Owner Information").click();
                break;

            case "StellarSupport™":
                child.findSubmenu("StellarSupport™").click();
                break;
            case "Recalls":
            case "recalls":
                child.findSubmenu("Recalls").click();
                break;
            case "Safety":
            case "safety":
                child.findSubmenu("Safety").click();
                break;
            case "Self-Repair":
            case "self-repair":
            case "self repair":
            case "Self Repair":
                child.findSubmenu("Self-Repair").click();
                break;
        }


        // will use this list only if the primary menu has more than one sub-menus
        List<WebElement> submenu = null;


        if(chosen.toLowerCase().equals("parts")){
            child.findSubmenu("Parts").click();

        }

        }
    @Then("The URL should contain {string}")
    public void the_url_should_contain(String chosen) {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(chosen));
    }



}
