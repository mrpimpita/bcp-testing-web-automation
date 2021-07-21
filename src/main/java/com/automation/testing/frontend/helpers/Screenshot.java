package com.automation.testing.frontend.helpers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

    public static String to(WebDriver driver, String screenShotName) throws IOException {

        //create a string variable which will be unique always
        String df = new SimpleDateFormat("yyyyMMddhhss").format(new Date());

        //create object variable of to class
        TakesScreenshot ts = (TakesScreenshot)driver;

        //create File object variable which holds the screen shot reference
        File source = ts.getScreenshotAs(OutputType.FILE);

        //store the screen shot path in path variable. Here we are storing the screenshots under screenshots folder
        String path = System.getProperty("user.dir") + "/target/screenshot-fail/" + screenShotName + df + ".png";

        //create another File object variable which points(refer) to the above stored path variable
        File destination = new File(path);

        //use FileUtils class method to save the screen shot at desired path
        FileUtils.copyFile(source, destination);

        //return the path where the screen shot is saved
        return path;

    }

}
