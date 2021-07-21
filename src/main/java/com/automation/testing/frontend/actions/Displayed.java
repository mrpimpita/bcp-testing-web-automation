package com.automation.testing.frontend.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Displayed {

    public static Boolean is(WebDriver driver, By locator) {

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

        boolean existe = false;

        try{

            existe = driver.findElement(locator).isDisplayed();

            return existe;

        }catch (NoSuchElementException nE){

            return existe;

        }
    }

}
