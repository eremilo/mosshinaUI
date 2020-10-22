package ru.mosshina.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LkPage {
    @FindBy(how = How.CSS, using = ".personal-info-contacts")
    private static SelenideElement personalInfo;

    public String getPersonalInfo() {
        return personalInfo.getText();
    }


}
