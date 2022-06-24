package com.epam.reportportalproject.reportportal.fragments.loginpage_fragments;

import static com.codeborne.selenide.Condition.visible;
import com.epam.reportportalproject.reportportal.AbstractFragment;
import static com.epam.reportportalproject.reportportal.utils.ElementsFinder.findElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.xpath;

@Log4j2
public class LogInFormFragment extends AbstractFragment {
    private static final By LOGIN_FIELD = xpath("//input[@name='login']");
    private static final By PASSWORD_FIELD = xpath("//input[@name='password']");
    private static final By LOGIN_BUTTON = xpath("//button[@type='submit']");

    public LogInFormFragment fillLoginField(String email) {
        findElement(LOGIN_FIELD).clear();
        findElement(LOGIN_FIELD).sendKeys(email);
        log.info("'Login' field has been filled in");
        return this;
    }

    public LogInFormFragment fillPasswordField(String email) {
        findElement(PASSWORD_FIELD).clear();
        findElement(PASSWORD_FIELD).sendKeys(email);
        log.info("'Password' field has been filled in");
        return this;
    }

    public LogInFormFragment clickLogInButton() {
        findElement(LOGIN_BUTTON).click();
        log.info("'Login' button has been clicked");
        return this;
    }

    @Override
    public LogInFormFragment waitUntilContentIsLoaded() {
        findElement(PASSWORD_FIELD).shouldBe(visible);
        return this;
    }
}
