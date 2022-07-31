package com.epam.reportportalproject.tests;

import com.epam.reportportalproject.BaseTest;
import com.epam.reportportalproject.reportportal.fragments.launches_fragment.LaunchItemFragment;
import com.epam.reportportalproject.reportportal.pages.LogInPage;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvFileSource;

public class LaunchesTests extends BaseTest {

    private final LogInPage logInPage = new LogInPage();
    private final LaunchItemFragment launchItemFragment = new LaunchItemFragment();
    private static final String LOGIN = "default";
    private static final String PASSWORD = "1q2w3e";
    private static final String LAUNCH_NAME = "Demo Api Tests";
    private static int ROW_COUNT = 0;

    @ParameterizedTest
    @CsvFileSource(resources = "/launch_parameters.csv", numLinesToSkip = 1)
    public void checkThatLaunchParametersAreDisplayed(ArgumentsAccessor argumentsAccessor) {
        logInPage.getLogInFormFragment()
                .fillLoginField(LOGIN)
                .fillPasswordField(PASSWORD)
                .clickLogInButton();

        List<String> launchParameters = argumentsAccessor.toList().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        Map<String, String> expectedLaunchParameters = launchItemFragment.getLaunchParameters(launchParameters);

        Map<String, String> actualLaunchParameters = launchItemFragment.getLaunchParameters(
                launchItemFragment.getLaunchItemParametersByNumber(ROW_COUNT++)
        );

        assertThat(actualLaunchParameters)
                .as("Launch parameters are not as expected")
                .isEqualTo(expectedLaunchParameters);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/suit_parameters.csv", numLinesToSkip = 1)
    public void checkThatSuitParametersAreDisplayed(ArgumentsAccessor argumentsAccessor) {
        logInPage.getLogInFormFragment()
                .fillLoginField(LOGIN)
                .fillPasswordField(PASSWORD)
                .clickLogInButton();

        List<String> launchParameters = argumentsAccessor.toList().stream()
                .map(Object::toString)
                .collect(Collectors.toList());
        Map<String, String> expectedLaunchParameters = launchItemFragment.getLaunchParameters(launchParameters);

        launchItemFragment.clickLaunchLinkWithName(LAUNCH_NAME);
        Map<String, String> actualLaunchParameters = launchItemFragment.getLaunchParameters(
                launchItemFragment.getLaunchItemParametersByNumber(ROW_COUNT++)
        );

        assertThat(actualLaunchParameters)
                .as("Suit parameters are not as expected")
                .isEqualTo(expectedLaunchParameters);
    }
}
