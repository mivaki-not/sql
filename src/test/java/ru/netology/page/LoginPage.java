package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginField = $("[data-test-id=login] input");
    private final SelenideElement passwordField = $("[data-test-id=password] input");
    private final SelenideElement loginButton = $("[data-test-id=action-login]");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public void verifyErrorNotificationVisiblity(String expectedText) {
        errorNotification.shouldHave(text(expectedText)).shouldBe(visible);
    }

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        login(info);
        return new VerificationPage();
    }

    public void login(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
    }

}