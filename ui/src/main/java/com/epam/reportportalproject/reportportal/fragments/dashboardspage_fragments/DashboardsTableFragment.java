package com.epam.reportportalproject.reportportal.fragments.dashboardspage_fragments;

import static com.codeborne.selenide.Condition.visible;
import com.epam.reportportalproject.reportportal.AbstractFragment;
import static com.epam.reportportalproject.reportportal.utils.ElementsFinder.findElement;
import static com.epam.reportportalproject.reportportal.utils.ElementsFinder.getElementByXpathFormat;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.xpath;

@Log4j2
public class DashboardsTableFragment extends AbstractFragment {
    private static final By DASHBOARD_TABLE = xpath("//div[contains(@class,'dashboardTable__dashboard-table')]");
    private static final String DASHBOARD_NAME_PATTERN = ("//div[contains(@class,'dashboardTable')]//a[text()='%s']");

    public boolean isDashboardPresentWithName(String name) {
        return getElementByXpathFormat(DASHBOARD_NAME_PATTERN, name).isDisplayed();
    }

    @Override
    public DashboardsTableFragment waitUntilContentIsLoaded() {
        findElement(DASHBOARD_TABLE).shouldBe(visible);
        return this;
    }
}
