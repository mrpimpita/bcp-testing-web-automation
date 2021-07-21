package com.automation.testing.frontend.ui;

import org.openqa.selenium.By;

public class BookingDestinationPage {

    public static final By FBD_COMBOBOX_DESTINATION = By.id("destinoSelect");

    public static final By FBD_COMBOBOX_ROUTE = By.id("rutaSelect");

    public static final By FBD_COMBOBOX_TRAIN = By.id("cbTrenSelect");

    public static final By FBD_DATEPICKER_TRIP = By.id("salida");

    public static final By FBD_DATEPICKER_RETURN = By.id("regreso");

    public static final By FBD_LABEL_MONTH_YEAR_DATE = By.className("ui-datepicker-title");

    public static final By FBD_DATEPICKER_BUTTON_NEXT = By.className("ui-datepicker-next");

    public static final By FBD_DATEPICKER_ALLDAY = By.cssSelector("#ui-datepicker-div .ui-datepicker-calendar tbody > tr > td");

    public static final By FBD_BUTTON_SEARCH = By.id("btn_search");

}
