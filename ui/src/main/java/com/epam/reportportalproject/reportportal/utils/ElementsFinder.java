package com.epam.reportportalproject.reportportal.utils;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.exist;
import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import com.codeborne.selenide.SelenideElement;
import static java.lang.String.format;
import org.openqa.selenium.By;

public class ElementsFinder {

    public static SelenideElement findElement(By Locator) {
        return $(Locator).shouldBe(exist);
    }

    public static ElementsCollection findElements(By Locator) {
        return $$(Locator).shouldBe(sizeGreaterThan(0));
    }

    public static SelenideElement getElementByXpathFormat(String locatorPattern, String... args) {
        return $x(format(locatorPattern, (Object[]) args));
    }
}
