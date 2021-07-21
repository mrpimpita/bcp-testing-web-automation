package com.automation.testing.frontend.ui;

import org.openqa.selenium.By;

public class SummaryInBoundPage {

    public static final By SUMMARY_LABEL_DATE_INBOUND = By.xpath("(//div[text()='Date:']/../div)[4]");

    public static final By SUMMARY_LABEL_TRAIN_INBOUND = By.xpath("(//div[text()='Train:']/../div)[4]");

    public static final By SUMMARY_LABEL_QUANTITY_ADULT_INBOUND = By.xpath("(//div[@class='pasajeros']/div)[3]");

    public static final By SUMMARY_LABEL_TOTAL_INBOUND = By.xpath("(//div[@class='pasajeros']/div[2])[2]");

}
