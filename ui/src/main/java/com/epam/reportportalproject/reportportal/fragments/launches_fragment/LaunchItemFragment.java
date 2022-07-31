package com.epam.reportportalproject.reportportal.fragments.launches_fragment;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import com.epam.reportportalproject.reportportal.AbstractFragment;
import static com.epam.reportportalproject.reportportal.components.LaunchesHeader.AUTO_BUG;
import static com.epam.reportportalproject.reportportal.components.LaunchesHeader.FAILED;
import static com.epam.reportportalproject.reportportal.components.LaunchesHeader.PASSED;
import static com.epam.reportportalproject.reportportal.components.LaunchesHeader.PRODUCT_BUG;
import static com.epam.reportportalproject.reportportal.components.LaunchesHeader.SKIPPED;
import static com.epam.reportportalproject.reportportal.components.LaunchesHeader.SYSTEM_ISSUE;
import static com.epam.reportportalproject.reportportal.components.LaunchesHeader.TOTAL;
import static com.epam.reportportalproject.reportportal.components.LaunchesHeader.TO_INVESTIGATE;
import static com.epam.reportportalproject.reportportal.utils.ElementsFinder.findElement;
import static com.epam.reportportalproject.reportportal.utils.ElementsFinder.findElements;
import static com.epam.reportportalproject.reportportal.utils.ElementsFinder.getElementByXpathFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import static org.openqa.selenium.By.xpath;

@Log4j2
public class LaunchItemFragment extends AbstractFragment {
    private static final By ROOT = By.xpath("//div[contains(@class,'gridRow__grid-row-wrapper')]");
    private static final By LAUNCH_PARAMETER_CELLS = xpath(
            ".//div[contains(@class,'defectStatistics__defect-statistics')] |" +
                    ".//div[contains(@class,'executionStatistics__execution-statistics')]");
    private static final String LAUNCH_BY_NAME_PATTERN = "//a[contains(@class,'name-link')]//span[text()='%s']";

    public LaunchItemFragment() {
        setRootElement($(ROOT));
    }

    public List<String> getLaunchParametersList() {
        return getChildElements(LAUNCH_PARAMETER_CELLS)
                .stream()
                .map(SelenideElement::text)
                .collect(toList());
    }

    public List<LaunchItemFragment> getLaunchItems() {
        return createFragments(findElements(ROOT), LaunchItemFragment.class);
    }

    public List<String> getLaunchItemParametersByNumber(int itemNumber) {
        return getLaunchItems().get(itemNumber).getLaunchParametersList();
    }

    public Map<String, String> getLaunchParameters(List<String> launchParameters) {
        return new HashMap<String, String>() {{
            put(TOTAL.name(), launchParameters.get(TOTAL.ordinal()));
            put(PASSED.name(), launchParameters.get(PASSED.ordinal()));
            put(FAILED.name(), launchParameters.get(FAILED.ordinal()));
            put(SKIPPED.name(), launchParameters.get(SKIPPED.ordinal()));
            put(PRODUCT_BUG.name(), launchParameters.get(PRODUCT_BUG.ordinal()));
            put(AUTO_BUG.name(), launchParameters.get(AUTO_BUG.ordinal()));
            put(SYSTEM_ISSUE.name(), launchParameters.get(SYSTEM_ISSUE.ordinal()));
            put(TO_INVESTIGATE.name(), launchParameters.get(TO_INVESTIGATE.ordinal()));
        }};
    }

    public LaunchItemFragment clickLaunchLinkWithName(String launchName) {
        getElementByXpathFormat(LAUNCH_BY_NAME_PATTERN, launchName).click();
        return this;
    }

    @Override
    public LaunchItemFragment waitUntilContentIsLoaded() {
        findElement(ROOT).shouldBe(visible);
        return this;
    }
}
