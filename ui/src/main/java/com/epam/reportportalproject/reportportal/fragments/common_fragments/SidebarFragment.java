package com.epam.reportportalproject.reportportal.fragments.common_fragments;

import static com.codeborne.selenide.Condition.visible;
import com.epam.reportportalproject.reportportal.AbstractFragment;
import static com.epam.reportportalproject.reportportal.utils.ElementsFinder.findElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.xpath;

@Log4j2
public class SidebarFragment extends AbstractFragment {
    private static final By DASHBOARDS_BUTTON = xpath("//div[contains(@class,'sidebarButton')]//a[contains(@href,'/dashboard')]");

    public SidebarFragment clickDashboardsButton() {
        findElement(DASHBOARDS_BUTTON).click();
        log.info("'Dashboards' button has been clicked");
        return this;
    }

    @Override
    public SidebarFragment waitUntilContentIsLoaded() {
        findElement(DASHBOARDS_BUTTON).shouldBe(visible);
        return this;
    }
}
