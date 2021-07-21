package com.automation.testing.frontend.tasks;

import com.automation.testing.frontend.actions.*;
import com.automation.testing.frontend.ui.BookingDestinationPage;
import com.automation.testing.frontend.ui.PassengerPage;
import lombok.Builder;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Passenger {

    private final PassengerInfo passengerInfo;

    private static final String ELEMENT_1 = "1";

    private static final String ELEMENT_2 = "2";

    public static final String PASSENGER_TEXTFIELD_NAME = ("formPasajero*CONTENIDO*-nomPasajero");

    public static final String PASSENGER_TEXTFIELD_SURNAME = ("formPasajero*CONTENIDO*-apePasajero");

    public static final String PASSENGER_DATEPICKER_BIRTHDAY = ("formPasajero*CONTENIDO*-fecNacimiento");

    public static final String PASSENGER_COMBOBOX_NATIONALITY = ("formPasajero*CONTENIDO*-idPais");

    public static final String PASSENGER_COMBOBOX_TYPEDOCUMENT = ("formPasajero*CONTENIDO*-idDocumentoIdentidad");

    public static final String PASSENGER_TEXTFIELD_NUMBERDOCUMENT = ("formPasajero*CONTENIDO*-numDocumentoIdentidad");

    public static final String PASSENGER_COMBOBOX_SEX = ("formPasajero*CONTENIDO*-idSexo");

    public static final String PASSENGER_TEXTFIELD_PHONE = ("formPasajero*CONTENIDO*-numTelefono");

    public static final String PASSENGER_TEXTFIELD_EMAIL = ("formPasajero*CONTENIDO*-desEmail");

    public static final String PASSENGER_TEXTFIELD_REEMAIL = ("formPasajero*CONTENIDO*-desEmailConfirmacion");

    public Passenger(PassengerInfo passengerInfo) {
        this.passengerInfo = passengerInfo;
    }

    public static PassengerBuilder fillFirstDataAdult(WebDriver driver, String name, String surName, String dateBirth, String nationality, String typeDocument, String numberDocument, String sex, String phone, String email, String reEmail) throws Throwable {
        return new PassengerBuilder(driver, name, surName, dateBirth, nationality, typeDocument, numberDocument, sex, phone, email, reEmail);
    }

    public static PassengerSecondBuilder fillSecondtDataAdult(WebDriver driver, String name, String surName, String dateBirth, String nationality, String typeDocument, String numberDocument, String sex, String phone, String email, String reEmail) throws Throwable {
        return new PassengerSecondBuilder(driver, name, surName, dateBirth, nationality, typeDocument, numberDocument, sex, phone, email, reEmail);
    }

    public static class PassengerBuilder {

        private String name;

        public PassengerBuilder(WebDriver driver, String name, String surName, String dateBirth, String nationality, String typeDocument, String numberDocument, String sex, String phone, String email, String reEmail) throws Throwable {

            try {

                Type.text(driver, PASSENGER_TEXTFIELD_NAME.replace("*CONTENIDO*", ELEMENT_1), name);

                Type.text(driver, PASSENGER_TEXTFIELD_SURNAME.replace("*CONTENIDO*", ELEMENT_1), surName);

                SelectFrom.byVisibleText(driver, PASSENGER_COMBOBOX_NATIONALITY.replace("*CONTENIDO*", ELEMENT_1), nationality);

                Click.on(driver, PASSENGER_DATEPICKER_BIRTHDAY.replace("*CONTENIDO*", ELEMENT_1));

                SelectFrom.byVisibleText(driver, PassengerPage.PASSENGER_COMBOBOX_BIRTHDAY_MONTH, dateBirth.split("-")[1].trim());

                SelectFrom.byVisibleText(driver, PassengerPage.PASSENGER_COMBOBOX_BIRTHDAY_YEAR, dateBirth.split("-")[2].trim());

                setBithDayPassenger(driver, PassengerPage.PASSENGER_LIST_BIRTHDAY_DAY, dateBirth.split("-")[0].trim());

                SelectFrom.byVisibleText(driver, PASSENGER_COMBOBOX_TYPEDOCUMENT.replace("*CONTENIDO*", ELEMENT_1), typeDocument);

                Type.text(driver, PASSENGER_TEXTFIELD_NUMBERDOCUMENT.replace("*CONTENIDO*", ELEMENT_1), numberDocument);

                SelectFrom.byVisibleText(driver, PASSENGER_COMBOBOX_SEX.replace("*CONTENIDO*", ELEMENT_1), sex);

                Type.text(driver, PASSENGER_TEXTFIELD_PHONE.replace("*CONTENIDO*", ELEMENT_1), phone);

                Type.text(driver, PASSENGER_TEXTFIELD_EMAIL.replace("*CONTENIDO*", ELEMENT_1), email);

                Type.text(driver, PASSENGER_TEXTFIELD_REEMAIL.replace("*CONTENIDO*", ELEMENT_1), reEmail);

                this.name=name;

            }catch (Exception e){

            }
        }

        public Passenger andBuild() {
            return new Passenger(PassengerInfo.builder().name(this.name).build());
        }
    }

    public static class PassengerSecondBuilder {

        private String name;

        public PassengerSecondBuilder(WebDriver driver, String name, String surName, String dateBirth, String nationality, String typeDocument, String numberDocument, String sex, String phone, String email, String reEmail) throws Throwable {

            try {

                Click.on(driver, PassengerPage.PASSENGER_LABEL_SECTION2);

                Type.text(driver, PASSENGER_TEXTFIELD_NAME.replace("*CONTENIDO*", ELEMENT_2), name);

                Type.text(driver, PASSENGER_TEXTFIELD_SURNAME.replace("*CONTENIDO*", ELEMENT_2), surName);

                SelectFrom.byVisibleText(driver, PASSENGER_COMBOBOX_NATIONALITY.replace("*CONTENIDO*", ELEMENT_2), nationality);

                Click.on(driver, PASSENGER_DATEPICKER_BIRTHDAY.replace("*CONTENIDO*", ELEMENT_2));

                SelectFrom.byVisibleText(driver, PassengerPage.PASSENGER_COMBOBOX_BIRTHDAY_MONTH, dateBirth.split("-")[1].trim());

                SelectFrom.byVisibleText(driver, PassengerPage.PASSENGER_COMBOBOX_BIRTHDAY_YEAR, dateBirth.split("-")[2].trim());

                setBithDayPassenger(driver, PassengerPage.PASSENGER_LIST_BIRTHDAY_DAY, dateBirth.split("-")[0].trim());

                SelectFrom.byVisibleText(driver, PASSENGER_COMBOBOX_TYPEDOCUMENT.replace("*CONTENIDO*", ELEMENT_2), typeDocument);

                Type.text(driver, PASSENGER_TEXTFIELD_NUMBERDOCUMENT.replace("*CONTENIDO*", ELEMENT_2), numberDocument);

                SelectFrom.byVisibleText(driver, PASSENGER_COMBOBOX_SEX.replace("*CONTENIDO*", ELEMENT_2), sex);

                Type.text(driver, PASSENGER_TEXTFIELD_PHONE.replace("*CONTENIDO*", ELEMENT_2), phone);

                Type.text(driver, PASSENGER_TEXTFIELD_EMAIL.replace("*CONTENIDO*", ELEMENT_2), email);

                Type.text(driver, PASSENGER_TEXTFIELD_REEMAIL.replace("*CONTENIDO*", ELEMENT_2), reEmail);

                this.name=name;

            }catch (Exception e){

            }
        }

        public Passenger andBuild() {
            return new Passenger(PassengerInfo.builder().name(this.name).build());
        }
    }


    private static void setBithDayPassenger(WebDriver driver, By locator, String value) throws Throwable {

        boolean found = false;

        while (!found) {

            List<WebElement> elementList = GetElements.list(driver, locator);

            for (WebElement element : elementList) {

                if (StringUtils.equals(value.split("-")[0].trim(), element.getText())) {

                    element.click();

                    found = true;

                    break;

                }

            }
        }
    }
    @Builder
    public static class PassengerInfo { String name; }
}
