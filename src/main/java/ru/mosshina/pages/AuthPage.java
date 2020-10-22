package ru.mosshina.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AuthPage {
    @FindBy(how = How.CSS, using = "#reg-field-1[name='USER_LOGIN']")
    private SelenideElement loginInput;
    @FindBy(how = How.CSS, using = "#reg-field-1[name='USER_PASSWORD']")
    private SelenideElement passwordInput;
    @FindBy(how = How.CSS, using = "[action=''] [name='Login']")
    private SelenideElement loginButton;
    @FindBy(how = How.CSS, using = "[action=''] [name='Login']")
    private SelenideElement createNewAccountButton;
    @FindBy(how = How.CSS, using = "[style^='color']")
    public SelenideElement errorMsg;

    @Step("входим в личный кабинет mail: {mail}, pass:{password}")
    public LkPage login(String mail, String password) {
        doLogin(mail, password);
        return page(LkPage.class);
    }


    @Step("входим в личный кабинет с неправильным паролем mail: {mail}, pass:{password}")
    public AuthPage badLoginTest(String mail, String password) {
        doLogin(mail, password);
        return page(AuthPage.class);
    }

    private void doLogin(String mail, String password) {
        loginInput.setValue(mail);
        passwordInput.setValue(password).pressEnter();
    }
}
