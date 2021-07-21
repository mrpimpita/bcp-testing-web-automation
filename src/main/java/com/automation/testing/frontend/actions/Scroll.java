package com.automation.testing.frontend.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Scroll {

    public static void down(WebDriver driver, int size) {
        JavascriptExecutor ev = (JavascriptExecutor) driver;
        ev.executeScript("window.scrollBy(0, " + size + ")");
    }

}
