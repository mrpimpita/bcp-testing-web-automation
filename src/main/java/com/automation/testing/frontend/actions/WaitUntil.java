package com.automation.testing.frontend.actions;

import com.automation.testing.frontend.exceptions.HandleError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUntil {

    private static final long MAX_WAIT_TIME_SECONDS = 20;

    private static final long NEXT_TRY_TIME_MILISECONDS = 40;

    public static boolean presenceElement(WebDriver driver, By locator) throws Throwable {

        try{

            WebDriverWait driverWait = new WebDriverWait(driver, MAX_WAIT_TIME_SECONDS, NEXT_TRY_TIME_MILISECONDS);

            driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));

        }catch (Exception e){

            HandleError.to(driver, "A-005", "No se encuentra el elemento " + locator);

            throw e;

        }

        return false;

    }

    public static boolean visibilityElement(WebDriver driver, By locator) throws Throwable {

        try{

            WebDriverWait driverWait = new WebDriverWait(driver, MAX_WAIT_TIME_SECONDS, NEXT_TRY_TIME_MILISECONDS);

            driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        }catch (Exception e){

            HandleError.to(driver, "A-005", "No se encuentra el elemento " + locator);

            throw e;

        }

        return false;

    }


}
