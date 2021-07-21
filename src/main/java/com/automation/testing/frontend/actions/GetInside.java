package com.automation.testing.frontend.actions;

import com.automation.testing.frontend.exceptions.HandleError;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetInside {

    public static String attribute(WebDriver driver, By locator, String value) throws Throwable {

        try {

            WebElement element = driver.findElement(locator);

            return StringUtils.trimToEmpty(element.getAttribute(value).replaceAll("\n", " "));

        }catch (Exception e){

            HandleError.to(driver, "A-005", "No se encuentra el elemento " + locator);

            driver.close();

            throw e;

        }
    }
}
