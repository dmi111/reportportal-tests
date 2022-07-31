package com.epam.reportportalproject.reportportal.components;

public enum LaunchesHeader {
    TOTAL("total"),
    PASSED("passed"),
    FAILED("failed"),
    SKIPPED("skipped"),
    PRODUCT_BUG("product bug"),
    AUTO_BUG("auto bug"),
    SYSTEM_ISSUE("system issue"),
    TO_INVESTIGATE("to investigate");

    private final String title;

    @Override
    public String toString() {
        return title;
    }

    LaunchesHeader(String title) {
        this.title = title;
    }
}
