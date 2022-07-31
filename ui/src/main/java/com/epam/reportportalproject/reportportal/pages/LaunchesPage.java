package com.epam.reportportalproject.reportportal.pages;

import com.epam.reportportalproject.reportportal.BasePage;
import com.epam.reportportalproject.reportportal.fragments.launches_fragment.LaunchItemFragment;
import lombok.Getter;

@Getter
public class LaunchesPage extends BasePage {
    private final LaunchItemFragment launchItemFragment;

    public LaunchesPage() {
        launchItemFragment = new LaunchItemFragment();
    }

    @Override
    public LaunchesPage waitUntilContentIsLoaded() {
        launchItemFragment.waitUntilContentIsLoaded();
        return this;
    }
}
