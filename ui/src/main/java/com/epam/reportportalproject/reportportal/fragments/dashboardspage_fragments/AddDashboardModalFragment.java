package com.epam.reportportalproject.reportportal.fragments.dashboardspage_fragments;

import static com.codeborne.selenide.Condition.visible;
import com.epam.reportportalproject.reportportal.AbstractFragment;
import static com.epam.reportportalproject.reportportal.utils.ElementsFinder.findElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.xpath;

@Log4j2
public class AddDashboardModalFragment extends AbstractFragment {
    private static final By DASHBOARD_NAME_FIELD = xpath("//input[@placeholder='Enter dashboard name']");
    private static final By ADD_DASHBOARD_BUTTON = xpath("//button[text()='Add']");

    public AddDashboardModalFragment fillDashboardName(String dashboardName) {
        findElement(DASHBOARD_NAME_FIELD).clear();
        findElement(DASHBOARD_NAME_FIELD).sendKeys(dashboardName);
        log.info("Dashboard name has been filled in");
        return this;
    }

    public AddDashboardModalFragment clickAddDashboardButton() {
        findElement(ADD_DASHBOARD_BUTTON).click();
        log.info("'Add dashboard' button has been clicked");
        return this;
    }

    @Override
    public AddDashboardModalFragment waitUntilContentIsLoaded() {
        findElement(ADD_DASHBOARD_BUTTON).shouldBe(visible);
        return this;
    }
}
