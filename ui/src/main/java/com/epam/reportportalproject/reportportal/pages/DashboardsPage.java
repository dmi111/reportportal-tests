package com.epam.reportportalproject.reportportal.pages;

import com.epam.reportportalproject.reportportal.BasePage;
import com.epam.reportportalproject.reportportal.fragments.dashboardspage_fragments.AddDashboardModalFragment;
import com.epam.reportportalproject.reportportal.fragments.dashboardspage_fragments.DashboardsHeaderFragment;
import com.epam.reportportalproject.reportportal.fragments.dashboardspage_fragments.DashboardsTableFragment;
import lombok.Getter;

@Getter
public class DashboardsPage extends BasePage {
    private final DashboardsHeaderFragment dashboardsHeaderFragment;
    private final AddDashboardModalFragment addDashboardModalFragment;
    private final DashboardsTableFragment dashboardsTableFragment;

    public DashboardsPage() {
        dashboardsHeaderFragment = new DashboardsHeaderFragment();
        addDashboardModalFragment = new AddDashboardModalFragment();
        dashboardsTableFragment = new DashboardsTableFragment();
    }

    @Override
    public DashboardsPage waitUntilContentIsLoaded() {
        dashboardsHeaderFragment.waitUntilContentIsLoaded();
        return this;
    }
}
