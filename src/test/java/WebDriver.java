import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import ru.mosshina.Endpoints;

import static com.codeborne.selenide.Selenide.open;

public class WebDriver {
    @BeforeClass
    public void setUpDriver() {
        Configuration.browser = WebDriverRunner.CHROME;
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = Endpoints.baseUrl;
        open(Endpoints.baseUrl);
    }
    @AfterMethod
    public void tearDown(){
        WebDriverRunner.closeWebDriver();
    }
}
