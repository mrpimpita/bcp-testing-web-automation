package com.automation.testing.frontend.steps;

import com.automation.testing.frontend.actions.*;
import com.automation.testing.frontend.helpers.Hook;
import com.automation.testing.frontend.helpers.Screenshot;
import com.automation.testing.frontend.tasks.*;
import com.automation.testing.frontend.ui.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.AssertJUnit.assertTrue;

public class RegisterTravel {

    private static final String MESSAGE_CABIN_NO_AVIABLE = "No cabins available for the selected date";
    public static WebDriver driver;

    public RegisterTravel(){ this.driver = Hook.getDriver(); }

    @Given("^Carla is on the Peru Rail Page$")
    public void carlaIsOnThePeruRailPage() throws Throwable {
        NavigateTo.theWebPagePeruRail(driver).andBuild();
    }

    @When("^select \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" for trip$")
    public void selectForTrip(String destination, String route, String train, String date) throws Throwable {
        BookingDestination.fillInformationForTrip(driver, destination, route, train, date).andBuild();
    }

    @When("^select \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" for trip$")
    public void selectForTrip(String destination, String route, String date) throws Throwable {
        BookingDestination.fillInformationForTripWithOutTrain(driver, destination, route, date).andBuild();
    }

    @Then("^the One Way should be selected$")
    public void theOneWayShouldBeSelected() {
        assertTrue(Selected.is(driver, OverviewBookingDestinationPage.OV_FBD_RADIOBUTTON_ONEWAY));
    }

    @And("^select search to train ticket$")
    public void selectSearchToTrainTicket() throws Throwable {
        Click.on(driver, BookingDestinationPage.FBD_BUTTON_SEARCH);
        WaitUntil.presenceElement(driver, SchedulesDestinationPage.SD_LABEL_SECTION2);

    }

    @When("^select \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" for round trip$")
    public void selectForRoundTrip(String destination, String route, String datetrip, String datereturn) throws Throwable {
        BookingDestination.fillInformationForRoundTrip(driver, destination, route, datetrip, datereturn).andBuild();

    }

    @Then("^the Round trip should be selected$")
    public void theRoundTripShouldBeSelected() throws InterruptedException {
        assertTrue(Selected.is(driver, OverviewBookingDestinationPage.OV_FBD_RADIOBUTTON_ROUNDTRIP));

    }

    @And("^Select schedules \"([^\"]*)\" \"([^\"]*)\"$")
    public void selectSchedules(String trainOutbound, String trainInbound) throws Throwable {
        SchedulesDestination.chooseTrain(driver, trainOutbound, trainInbound)
                            .andContinue(driver)
                            .andBuild();
    }

    @And("^fill first passenger \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void fillFirstPassenger(String name, String surName, String dateBirth, String nationality, String typeDocument, String numberDocument, String sex, String phone, String email, String reEmail) throws Throwable {
        Passenger.fillFirstDataAdult(driver, name, surName, dateBirth, nationality, typeDocument, numberDocument, sex, phone, email, reEmail).andBuild();
    }

    @And("^fill second passenger \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void fillSecondPassenger(String name, String surName, String dateBirth, String nationality, String typeDocument, String numberDocument, String sex, String phone, String email, String reEmail) throws Throwable {
        Passenger.fillSecondtDataAdult(driver, name, surName, dateBirth, nationality, typeDocument, numberDocument, sex, phone, email, reEmail).andBuild();
        Click.on(driver, PassengerPage.PASSENGER_BUTTON_CONTINUE);
        WaitUntil.visibilityElement(driver, PaymentPage.PAYMENT_RADIOBUTTON_VISA);
    }

    @When("^fill method payment \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void fillMethodPayment(String numberCard, String expirationDate, String securityCode, String nameComplete) throws Throwable {
        Payment.chooseTypeOfCard(driver)
                .andAcepteTerms(driver)
                .andGoToPay(driver)
                .andWriteNumberCard(driver,numberCard)
                .andSelectExpirantionDate(driver, expirationDate)
                .andWriteSecurityCode(driver, securityCode)
                .andWriteNameComplete(driver, nameComplete)
                .andBuild();
    }

    @Then("^verify in summary purchase Outbound \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void verifyInSummaryPurchaseOutbound(String dateOutbound, String trainOutbound, String quantityAdultInOutbound, String totalOutbound) throws Throwable {
        Assert.assertEquals(GetFrom.text(driver, SummaryOutBoundPage.SUMMARY_LABEL_DATE_OUTBOUND), dateOutbound);
        Assert.assertEquals(GetFrom.text(driver, SummaryOutBoundPage.SUMMARY_LABEL_TRAIN_OUTBOUND), trainOutbound);
        Assert.assertEquals(GetFrom.text(driver, SummaryOutBoundPage.SUMMARY_LABEL_QUANTITY_ADULT_OUTBOUND), quantityAdultInOutbound);
        Assert.assertEquals(GetFrom.text(driver, SummaryOutBoundPage.SUMMARY_LABEL_TOTAL_OUTBOUND), totalOutbound);

    }

    @And("^verify in summary purchase Inbound \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void verifyInSummaryPurchaseInbound(String dateInbound, String trainInbound, String quantityAdultInInbound, String totalInbound) throws Throwable {
        Assert.assertEquals(GetFrom.text(driver, SummaryInBoundPage.SUMMARY_LABEL_DATE_INBOUND), dateInbound);
        Assert.assertEquals(GetFrom.text(driver, SummaryInBoundPage.SUMMARY_LABEL_TRAIN_INBOUND), trainInbound);
        Assert.assertEquals(GetFrom.text(driver, SummaryInBoundPage.SUMMARY_LABEL_QUANTITY_ADULT_INBOUND), quantityAdultInInbound);
        Assert.assertEquals(GetFrom.text(driver, SummaryInBoundPage.SUMMARY_LABEL_TOTAL_INBOUND), totalInbound);
    }

    @And("^select \"([^\"]*)\" in \"([^\"]*)\"$")
    public void selectIn(String numberCabin, String suiteCabin) throws Throwable {

        if (Displayed.is(driver,ChooseCabinPage.CHOOSE_CABIN_LABEL_SUITE_CABINS)){

            Scroll.down(driver, 1000);

            Assert.assertEquals(suiteCabin, GetFrom.text(driver, ChooseCabinPage.CHOOSE_CABIN_LABEL_SUITE_CABINS));

            if (StringUtils.equalsIgnoreCase(GetFrom.text(driver,ChooseCabinPage.CHOOSE_CABIN_COMBOBOX_SUITE_CABINS), MESSAGE_CABIN_NO_AVIABLE)){

                Screenshot.to(driver, "No hay cabinas para elegir.");

            }else {

                SelectFrom.byVisibleText(driver, ChooseCabinPage.CHOOSE_CABIN_LABEL_SUITE_CABINS, numberCabin);
            }
        }
    }


}


