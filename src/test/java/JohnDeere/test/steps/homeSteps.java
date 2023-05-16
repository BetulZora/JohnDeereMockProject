package JohnDeere.test.steps;

import JohnDeere.test.pages.ChildClass;
import JohnDeere.test.utils.ConfigurationReader;
import JohnDeere.test.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.interactions.Actions;

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
        }
    @Then("The URL should contain {string}")
    public void the_url_should_contain(String string) {
    }



}
