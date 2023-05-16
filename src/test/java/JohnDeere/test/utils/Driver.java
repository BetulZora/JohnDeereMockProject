package JohnDeere.test.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;
import java.net.URL;

public class Driver {


    private Driver() {
    }
    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browserName = System.getProperty("browser") != null ? browserName = System.getProperty("browser") : JohnDeere.test.utils.ConfigurationReader.getProperty("browser");



            switch(browserName){
                case "remote-chrome":
                    try {

                        String gridAddress = "54.87.211.169";
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("chrome");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "remote-firefox":
                    try {

                        String gridAddress = "54.87.211.169";
                        URL url = new URL("http://"+ gridAddress + ":4444/wd/hub");
                        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                        desiredCapabilities.setBrowserName("firefox");
                        driverPool.set(new RemoteWebDriver(url, desiredCapabilities));


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "chrome":
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }

        return driverPool.get();

    }

    // This method will make sure our driver value is always null after using quit() method
    public static void closeDriver(){
        if(driverPool.get() != null){
            driverPool.get().quit(); // this line will terminate the existing driver session. with using this driver will not be even null
            driverPool.remove();  //driver = null
        }

    }
}
