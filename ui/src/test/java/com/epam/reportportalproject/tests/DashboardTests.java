package com.epam.reportportalproject.tests;

import com.epam.reportportalproject.BaseTest;
import com.epam.reportportalproject.reportportal.fragments.common_fragments.SidebarFragment;
import com.epam.reportportalproject.reportportal.pages.DashboardsPage;
import com.epam.reportportalproject.reportportal.pages.LogInPage;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;

public class DashboardTests extends BaseTest {

    private final LogInPage logInPage = new LogInPage();
    private final SidebarFragment sidebarFragment = new SidebarFragment();
    private static final String LOGIN = "default";
    private static final String PASSWORD = "1q2w3e";
    private static final String DASHBOARD_TITLE = "Dashboard" + randomNumeric(2);

    @Test
    public void checkAbilityToAddDashboard() {
        logInPage.getLogInFormFragment()
                .fillLoginField(LOGIN)
                .fillPasswordField(PASSWORD)
                .clickLogInButton();
        boolean isDashboardDisplayed = sidebarFragment.waitUntilContentIsLoaded()
                .clickDashboardsButton()
                .lookAtPage(DashboardsPage.class)
                .getDashboardsHeaderFragment()
                .clickAddNewDashboardButton()
                .lookAtPage(DashboardsPage.class)
                .getAddDashboardModalFragment()
                .fillDashboardName(DASHBOARD_TITLE)
                .clickAddDashboardButton()
                .lookAtPage(DashboardsPage.class)
                .getDashboardsHeaderFragment()
                .clickAllDashboardsLink()
                .lookAtPage(DashboardsPage.class)
                .getDashboardsTableFragment()
                .waitUntilContentIsLoaded()
                .isDashboardPresentWithName(DASHBOARD_TITLE);

        assertThat(isDashboardDisplayed)
                .as("Dashboard '%s' is not displayed", DASHBOARD_TITLE)
                .isTrue();
    }
}
