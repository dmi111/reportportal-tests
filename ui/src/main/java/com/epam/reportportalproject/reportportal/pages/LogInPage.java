package com.epam.reportportalproject.reportportal.pages;

import com.epam.reportportalproject.reportportal.BasePage;
import com.epam.reportportalproject.reportportal.fragments.loginpage_fragments.LogInFormFragment;
import lombok.Getter;

@Getter
public class LogInPage extends BasePage {
    private final LogInFormFragment logInFormFragment;

    public LogInPage() {
        logInFormFragment = new LogInFormFragment();
    }

    @Override
    public LogInPage waitUntilContentIsLoaded() {
        logInFormFragment.waitUntilContentIsLoaded();
        return this;
    }
}
