package com.automation.testing.frontend.tasks;

import com.automation.testing.frontend.actions.*;
import com.automation.testing.frontend.ui.BookingDestinationPage;
import lombok.Builder;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BookingDestination {

    private final BookingDestinationInfo bookingDestinationInfo;

    public BookingDestination(BookingDestinationInfo bookingDestinationInfo) {
        this.bookingDestinationInfo = bookingDestinationInfo;
    }

    public static BookingDestinationBuilder fillInformationForTrip(WebDriver driver, String destination, String route, String train, String dateTrip) throws Throwable {
        return new BookingDestinationBuilder(driver, destination, route, train, dateTrip);
    }

    public static BookingDestinationWithOutTrainBuilder fillInformationForTripWithOutTrain(WebDriver driver, String destination, String route, String dateTrip) throws Throwable {
        return new BookingDestinationWithOutTrainBuilder(driver, destination, route, dateTrip);
    }

    public static BookingDestinationRoundBuilder fillInformationForRoundTrip(WebDriver driver, String destination, String route, String dateTrip, String dateReturn) throws Throwable {
        return new BookingDestinationRoundBuilder(driver, destination, route, dateTrip, dateReturn);
    }

    public static class BookingDestinationBuilder{

        private String bookingDestination;

        public BookingDestinationBuilder(WebDriver driver, String destination, String route, String train, String dateTrip) throws Throwable {

            try {

                SelectFrom.byVisibleText(driver, BookingDestinationPage.FBD_COMBOBOX_DESTINATION, destination);

                SelectFrom.byVisibleText(driver, BookingDestinationPage.FBD_COMBOBOX_ROUTE, route);

                SelectFrom.byVisibleText(driver, BookingDestinationPage.FBD_COMBOBOX_TRAIN, train);

                Click.on(driver, BookingDestinationPage.FBD_DATEPICKER_TRIP);

                selectDate(driver, dateTrip);

                this.bookingDestination=bookingDestination;

            }catch (Exception e){

                System.out.println(e.getMessage());
            }
        }

        public BookingDestination andBuild(){
            return new BookingDestination(
                    BookingDestinationInfo.builder()
                            .bookingDestination(this.bookingDestination)
                            .build());
        }
    }

    public static class BookingDestinationRoundBuilder{

        private String bookingDestination;

        public BookingDestinationRoundBuilder(WebDriver driver, String destination, String route, String dateTrip, String dateReturn) throws Throwable {

            try {

                SelectFrom.byVisibleText(driver, BookingDestinationPage.FBD_COMBOBOX_DESTINATION, destination);

                SelectFrom.byVisibleText(driver, BookingDestinationPage.FBD_COMBOBOX_ROUTE, route);

                Click.on(driver, BookingDestinationPage.FBD_DATEPICKER_TRIP);

                selectDate(driver, dateTrip);

                Click.on(driver, BookingDestinationPage.FBD_DATEPICKER_RETURN);

                selectDate(driver, dateReturn);

                this.bookingDestination=bookingDestination;

            }catch (Exception e){

                System.out.println(e.getMessage());
            }
        }

        public BookingDestination andBuild(){
            return new BookingDestination(
                    BookingDestinationInfo.builder()
                            .bookingDestination(this.bookingDestination)
                            .build());
        }
    }

    public static class BookingDestinationWithOutTrainBuilder{

        private String bookingDestination;

        public BookingDestinationWithOutTrainBuilder(WebDriver driver, String destination, String route, String dateTrip) throws Throwable {

            try {

                SelectFrom.byVisibleText(driver, BookingDestinationPage.FBD_COMBOBOX_DESTINATION, destination);

                SelectFrom.byVisibleText(driver, BookingDestinationPage.FBD_COMBOBOX_ROUTE, route);

                Click.on(driver, BookingDestinationPage.FBD_DATEPICKER_TRIP);

                selectDate(driver, dateTrip);

                this.bookingDestination=bookingDestination;

            }catch (Exception e){

                System.out.println(e.getMessage());
            }
        }


        public BookingDestination andBuild(){
            return new BookingDestination(
                    BookingDestinationInfo.builder()
                            .bookingDestination(this.bookingDestination)
                            .build());
        }
    }

    protected static void selectDate(WebDriver driver, String dateComplete) throws Throwable {

        WaitUntil.presenceElement(driver, BookingDestinationPage.FBD_LABEL_MONTH_YEAR_DATE);

        while (!StringUtils.equals(GetFrom.text(driver, BookingDestinationPage.FBD_LABEL_MONTH_YEAR_DATE).split(" ")[0].trim(), dateComplete.split("-")[1].trim())

                && StringUtils.equals(GetFrom.text(driver, BookingDestinationPage.FBD_LABEL_MONTH_YEAR_DATE).split(" ")[1].trim(), dateComplete.split("-")[2].trim())){

            Click.on(driver, BookingDestinationPage.FBD_DATEPICKER_BUTTON_NEXT);
        }

        boolean found = false;

        while (!found) {

            List<WebElement> elementList = GetElements.list(driver, BookingDestinationPage.FBD_DATEPICKER_ALLDAY);

            for (WebElement element : elementList) {

                if (StringUtils.equals(dateComplete.split("-")[0].trim(), element.getText())) {

                    element.click();

                    found = true;

                    break;

                }

            }
        }
    }

    @Builder
    public static class BookingDestinationInfo { String bookingDestination;}
}



