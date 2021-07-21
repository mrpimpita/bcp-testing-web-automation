package com.automation.testing.frontend.exceptions;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

public class HandleError {

    public static Exception to(WebDriver driver, String codigo, String msg) throws Throwable {

        return new FrontEndException(StringUtils.trimToEmpty(codigo), msg);

    }


}
