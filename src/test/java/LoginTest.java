import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.mosshina.pages.AuthPage;
import ru.mosshina.pages.LkPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

@Epic("Супер новый функционал")
@Feature("Проверяем вход пользователя")
public class LoginTest extends WebDriver {
    String mail = "mail@mail.ru";
    String password = "password";
    String badPassword = "badPassword";
    AuthPage authPage;

    @BeforeMethod
    public void setUp() {
        authPage = open("/auth", AuthPage.class);
    }

    @Test(description = "Проверка успешного входа пользователя")
    public void testSuccessLogin() {
        LkPage lkPage = authPage.login(mail, password);
        assertThat(lkPage.getPersonalInfo()).contains(mail, "Город: Ivanovo");
    }

    @Test(description = "проверка входа с неправельным паролем")
    public void testBadLogin() {
        AuthPage authPageWithError = authPage.badLoginTest(mail, badPassword);
        authPageWithError.errorMsg.shouldHave(text("Пароль введен не верно"));
    }
}
