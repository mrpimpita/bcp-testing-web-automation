package com.automation.testing.frontend.ui;

import org.openqa.selenium.By;

public class SchedulesDestinationPage {

    public static final By SD_LABEL_SECTION2 = By.cssSelector(".active a span");

    public static final By SD_TABLE_JOURNET = By.id("viajeIdaCapa");

    public static final By SD_LIST_SCHEDULE_ONBOUND = By.cssSelector("#viajeIda .content-viajes .seleccionarTren .divFila");

    public static final By SD_LIST_SCHEDULE_INBOUND = By.cssSelector("#viajeRegresoCapa #viajeRegreso #divViajeRegreso .seleccionarTren .divFila");

    public static final By SD_BUTTON_CONTINUE = By.cssSelector("input[value='Continue']");

}
