package com.automation.testing.frontend.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Selected {

    public static Boolean is(WebDriver driver, By locator) {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        boolean existe = false;

        try{

            WebElement element = driver.findElement(locator);

            return existe = element.isSelected();

        }catch (NoSuchElementException nE){

            return existe;

        }
    }
}
