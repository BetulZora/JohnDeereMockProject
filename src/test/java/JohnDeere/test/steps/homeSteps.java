package JohnDeere.test.steps;

import JohnDeere.test.utils.ConfigurationReader;
import JohnDeere.test.utils.Driver;
import io.cucumber.java.en.Given;

public class homeSteps {

    @Given("I go to the John Deere Home Page")
    public void i_go_to_the_john_deere_home_page() {
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("JDbaseURL"));

    }



}
