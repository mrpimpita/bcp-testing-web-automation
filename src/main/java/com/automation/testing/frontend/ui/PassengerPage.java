package com.automation.testing.frontend.ui;

import org.openqa.selenium.By;

public class PassengerPage {

    public static final By PASSENGER_COMBOBOX_BIRTHDAY_MONTH = By.id("calendario_mes");

    public static final By PASSENGER_COMBOBOX_BIRTHDAY_YEAR = By.id("calendario_anio");

    public static final By PASSENGER_LIST_BIRTHDAY_DAY = By.cssSelector("#tlb_calendario tr > td > a");

    public static final By PASSENGER_LABEL_SECTION2 = By.cssSelector(".content-pasajero:nth-child(2)");

    public static final By PASSENGER_BUTTON_CONTINUE = By.cssSelector("input[value='Continue']");

}
