package com.automation.testing.frontend.actions;

import com.automation.testing.frontend.exceptions.HandleError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Click {

    public static void on(WebDriver driver, By locator) throws Throwable {

        try {

            driver.findElement(locator).click();

        }catch (Exception e){

            HandleError.to(driver, "A-001", "No se encuentra el elemento " + locator);

            driver.close();

            throw e;

        }

    }

    public static void on(WebDriver driver, String locator) throws Throwable {

        try {

            driver.findElement(By.id(locator)).click();

        }catch (Exception e){

            HandleError.to(driver, "A-001", "No se encuentra el elemento " + locator);

            driver.close();

            throw e;

        }

    }
}
