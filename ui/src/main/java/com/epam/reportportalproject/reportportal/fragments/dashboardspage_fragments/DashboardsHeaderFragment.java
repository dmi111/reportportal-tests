package com.epam.reportportalproject.reportportal.fragments.dashboardspage_fragments;

import static com.codeborne.selenide.Condition.visible;
import com.epam.reportportalproject.reportportal.AbstractFragment;
import static com.epam.reportportalproject.reportportal.utils.ElementsFinder.findElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.xpath;

@Log4j2
public class DashboardsHeaderFragment extends AbstractFragment {
    private static final By ADD_NEW_DASHBOARD_BUTTON = xpath("//div[contains(@class,'addDashboardButton')]//button");
    private static final By ALL_DASHBOARDS_LINK = xpath("//ul[contains(@class,'pageBreadcrumbs')]//a");

    public DashboardsHeaderFragment clickAddNewDashboardButton() {
        findElement(ADD_NEW_DASHBOARD_BUTTON).click();
        log.info("'Add New Dashboard' button has been clicked");
        return this;
    }

    public DashboardsHeaderFragment clickAllDashboardsLink() {
        findElement(ALL_DASHBOARDS_LINK).click();
        log.info("'All dashboards' link has been clicked");
        return this;
    }

    @Override
    public DashboardsHeaderFragment waitUntilContentIsLoaded() {
        findElement(ADD_NEW_DASHBOARD_BUTTON).shouldBe(visible);
        return this;
    }
}
