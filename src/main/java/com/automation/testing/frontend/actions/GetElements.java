package com.automation.testing.frontend.actions;

import com.automation.testing.frontend.exceptions.HandleError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetElements {

    public static List<WebElement> list(WebDriver driver, By locator) throws Throwable {

        try {

            return driver.findElements(locator);

        }catch (Exception e){

            HandleError.to(driver, "A-002", "No se encuentra el elemento " + locator);

            driver.close();

            throw e;

        }
    }



}
