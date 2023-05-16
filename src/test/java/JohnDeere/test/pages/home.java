package JohnDeere.test.pages;

import JohnDeere.test.utils.Driver;
import org.openqa.selenium.support.PageFactory;

public class home {

    public home() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
