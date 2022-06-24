package com.epam.reportportalproject.reportportal;

import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class AbstractFragment extends BasePage {
    public <T extends BasePage> T lookAtPage(Class<T> page) {
        try {
            return page.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error("Failed to create instance of {} page", page.getSimpleName(), e);
            return null;
        }
    }
}
