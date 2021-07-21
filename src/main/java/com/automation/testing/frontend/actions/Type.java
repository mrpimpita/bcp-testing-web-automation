package com.automation.testing.frontend.actions;

import com.automation.testing.frontend.exceptions.HandleError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Type {

    public static void text(WebDriver driver, By locator, String value) throws Throwable {

        try {

            driver.findElement(locator).sendKeys(value);

        }catch (Exception e){

            HandleError.to(driver, "A-004", "No se encuentra el elemento " + locator);

            driver.quit();

            throw e;

        }
    }

    public static void text(WebDriver driver, String locator, String value) throws Throwable {

        try {

            driver.findElement(By.id(locator)).sendKeys(value);

        }catch (Exception e){

            HandleError.to(driver, "A-004", "No se encuentra el elemento " + locator);

            driver.quit();

            throw e;

        }
    }


}
