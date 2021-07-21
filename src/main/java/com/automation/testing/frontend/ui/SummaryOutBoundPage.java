package com.automation.testing.frontend.ui;

import org.openqa.selenium.By;

public class SummaryOutBoundPage {

    public static final By SUMMARY_ICON_CART = By.cssSelector("#compra .logo-tren-normal");

    public static final By SUMMARY_LABEL_DATE_OUTBOUND = By.xpath("(//div[text()='Date:']/../div)[2]");

    public static final By SUMMARY_LABEL_TRAIN_OUTBOUND = By.xpath("(//div[text()='Train:']/../div)[2]");

    public static final By SUMMARY_LABEL_QUANTITY_ADULT_OUTBOUND = By.xpath("(//div[@class='pasajeros']/div)[1]");

    public static final By SUMMARY_LABEL_TOTAL_OUTBOUND = By.xpath("//div[@class='pasajeros']/div[2]");

}
