package com.automation.testing.frontend.actions;

import com.automation.testing.frontend.exceptions.HandleError;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectFrom {

    public static void byVisibleText(WebDriver driver, By locator, String value) throws Throwable {

        try {

            String found = value;

            Select select = new Select(driver.findElement(locator));

            select.selectByVisibleText(found);

        }catch (Exception e){

            HandleError.to(driver, "A-003", "No se encuentra el elemento " + locator);

            driver.close();

            throw e;

        }

    }

    public static void byVisibleText(WebDriver driver, String locator, String value) throws Throwable {

        try {

            String found = value;

            Select select = new Select(driver.findElement(By.id(locator)));

            select.selectByVisibleText(found);

        }catch (Exception e){

            HandleError.to(driver, "A-003", "No se encuentra el elemento " + locator);

            driver.close();

            throw e;

        }

    }
}
