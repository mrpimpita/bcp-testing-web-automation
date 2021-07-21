package com.automation.testing.frontend.actions;

import com.automation.testing.frontend.exceptions.HandleError;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetFrom {

    public static String text(WebDriver driver, By locator) throws Throwable {

        try {

            WebElement element = driver.findElement(locator);

            return StringUtils.trimToEmpty(element.getText().replaceAll("\n", " "));

        }catch (Exception e){

            HandleError.to(driver, "A-006", "No se encuentra el elemento " + locator);

            driver.close();

            throw e;

        }
    }
}
