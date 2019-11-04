package basic;

import com.cdhenren.fetch.tools.PropertiesTools;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class JSTest {
    public static void main(String[] args) {
        WebDriver driver = new InternetExplorerDriver(ieOptions());
        driver.get("http://4a.chinatowercom.cn:20000/uac_oa");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //login
        // #username
        js.executeScript("document.getElementById('username').value='wangrf'");
        js.executeScript("document.getElementById('password').value='ffjj1314.'");
        //body > div.wrap > div > div.right-form > div:nth-child(4) > input.btn
        //登录
       js.executeScript("checkAccount()");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.close();
        driver.quit();
    }

    private static InternetExplorerOptions ieOptions() {
        System.setProperty("webdriver.ie.driver", PropertiesTools.getProperty("tower.properties", "ieDriver"));
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.setCapability("ignoreProtectedModeSettings",true);
        options.introduceFlakinessByIgnoringSecurityDomains();
        enableIEProtectModeOfAllZones();
        return options;
    }

    private static void enableIEProtectModeOfAllZones() {

        final String[] ZONES = {
                "\"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\0\""
                ,"\"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\1\""
                , "\"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\2\""
                , "\"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\3\""
                , "\"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Internet Settings\\Zones\\4\""
        };
        for (String zone : ZONES) {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "reg", "add",
                    zone, "/v", "2500", "/t", "REG_DWORD", "/d", "0", "/f");
            try {
                pb.start();
            } catch (IOException ioe) { ioe.printStackTrace(); }
        }
    }
}
