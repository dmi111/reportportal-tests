package com.epam.reportportalproject.reportportal;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$;
import com.codeborne.selenide.SelenideElement;
import java.util.List;
import static java.util.stream.Collectors.toList;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Log4j2
public abstract class AbstractFragment extends BasePage {
    private WebElement rootElement;

    public <T extends BasePage> T lookAtPage(Class<T> page) {
        try {
            return page.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            log.error("Failed to create instance of {} page", page.getSimpleName(), e);
            return null;
        }
    }

    public static <T extends AbstractFragment> T createFragment(SelenideElement rootElement, Class<T> fragment) {
        try {
            T instance = fragment.getDeclaredConstructor().newInstance();
            instance.setRootElement(rootElement);
            return instance;
        } catch (Exception e) {
            log.error("Failed to create instance of {} fragment", fragment.getSimpleName(), e);
            return null;
        }
    }

    public static <T extends AbstractFragment> List<T> createFragments(ElementsCollection elements, Class<? extends T> type) {
        return elements.stream().map(element -> createFragment(element, type)).collect(toList());
    }

    protected void setRootElement(WebElement rootElement) {
        this.rootElement = rootElement;
    }

    protected ElementsCollection getChildElements(By byLocator) {
        return $(rootElement).$$(byLocator);
    }
}
