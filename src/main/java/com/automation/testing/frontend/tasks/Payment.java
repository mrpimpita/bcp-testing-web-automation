package com.automation.testing.frontend.tasks;

import com.automation.testing.frontend.actions.*;
import com.automation.testing.frontend.helpers.Screenshot;
import com.automation.testing.frontend.ui.PassengerPage;
import com.automation.testing.frontend.ui.PaymentPage;
import lombok.Builder;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Payment {

    private final PaymentInfo paymentInfo;

    public Payment(PaymentInfo paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public static PaymentBuilder chooseTypeOfCard(WebDriver driver) throws Throwable {
        return new PaymentBuilder(driver);
    }

    public static class PaymentBuilder {

        private String payment;

        public PaymentBuilder(WebDriver driver) throws Throwable {

            try {

                if (!Selected.is(driver, PaymentPage.PAYMENT_RADIOBUTTON_VISA)){

                    Click.on(driver, PaymentPage.PAYMENT_RADIOBUTTON_VISA);

                }else {

                    Screenshot.to(driver, "Error:Botón 'VISA' esta seleccionado");
                }

                this.payment=payment;

            }catch (Exception e){

            }
        }

        public PaymentBuilder andAcepteTerms(WebDriver driver) throws Throwable {

            try {

                if (!Selected.is(driver, PaymentPage.PAYMENT_CHECKBOX_TERM)){

                    Click.on(driver, PaymentPage.PAYMENT_CHECKBOX_TERM);

                }else {

                    Screenshot.to(driver, "Error:Botón 'Términos y Condiciones' esta seleccionado");
                }

            }catch (Exception e){

            }

            return this;
        }

        public PaymentBuilder andGoToPay(WebDriver driver) throws Throwable {

            try {

                if (Enable.is(driver, PaymentPage.PAYMENT_BUTTON_PAY)){

                    Click.on(driver, PaymentPage.PAYMENT_BUTTON_PAY);

                }else {

                    Screenshot.to(driver, "Error:Botón 'Pay' no esta habilitado");
                }

            }catch (Exception e){

            }

            return this;
        }

        public PaymentBuilder andWriteNumberCard(WebDriver driver, String numberCard) throws Throwable {

            try {

                List<WebElement> elements = driver.findElements(By.tagName("iframe"));

                driver.switchTo().frame(elements.get(0));

                if (Displayed.is(driver, PaymentPage.PAYMENT_LABEL_TITLE_PAYMENT_DETAILS) && Displayed.is(driver, PaymentPage.PAYMENT_TEXTFIELD_NUMBERCARD)){

                    Type.text(driver, PaymentPage.PAYMENT_TEXTFIELD_NUMBERCARD, numberCard);

                    Assert.assertEquals(numberCard, GetInside.attribute(driver, PaymentPage.PAYMENT_TEXTFIELD_NUMBERCARD,"value"));

                }else {

                    Screenshot.to(driver, "Error label & textfield 'payment' no esta presente.");

                }

            }catch (Exception e){

            }

            return this;
        }

        public PaymentBuilder andSelectExpirantionDate(WebDriver driver, String dateExpiration) throws Throwable {

            try {

                if (Displayed.is(driver, PaymentPage.PAYMENT_COMBOBOX_MONTH) && Displayed.is(driver, PaymentPage.PAYMENT_COMBOBOX_YEAR)){

                    SelectFrom.byVisibleText(driver, PaymentPage.PAYMENT_COMBOBOX_MONTH, dateExpiration.split("-")[0]);

                    Assert.assertEquals(dateExpiration.split("-")[0], GetInside.attribute(driver, PaymentPage.PAYMENT_COMBOBOX_MONTH, "value"));

                    SelectFrom.byVisibleText(driver, PaymentPage.PAYMENT_COMBOBOX_YEAR, dateExpiration.split("-")[1]);

                    Assert.assertEquals(dateExpiration.split("-")[1], GetInside.attribute(driver, PaymentPage.PAYMENT_COMBOBOX_YEAR, "value"));

                    Scroll.down(driver, 500);

                }else {

                    Screenshot.to(driver, "Error:ComboBox 'Expiration date' no esta presente");
                }

            }catch (Exception e){

                throw e;

            }

            return this;
        }

        public PaymentBuilder andWriteSecurityCode(WebDriver driver, String securityCide) throws Throwable {

            try {

                if (Displayed.is(driver, PaymentPage.PAYMENT_TEXTFIELD_SECURITY_CODE)){

                    Type.text(driver, PaymentPage.PAYMENT_TEXTFIELD_SECURITY_CODE, securityCide);

                    Assert.assertEquals(securityCide, GetInside.attribute(driver, PaymentPage.PAYMENT_TEXTFIELD_SECURITY_CODE, "value"));

                }else {

                    Screenshot.to(driver, "Error:Textfield 'Security code ' no esta presente");
                }

            }catch (Exception e){

            }

            return this;
        }

        public PaymentBuilder andWriteNameComplete(WebDriver driver, String nameComplete) throws Throwable {

            try {

                if (Displayed.is(driver, PaymentPage.PAYMENT_TEXTFIELD_NAME_COMPLETE)){

                    Type.text(driver, PaymentPage.PAYMENT_TEXTFIELD_NAME_COMPLETE, nameComplete);

                    Assert.assertEquals(nameComplete, GetInside.attribute(driver, PaymentPage.PAYMENT_TEXTFIELD_NAME_COMPLETE, "value"));

                    Scroll.down(driver, -300);

                }else {

                    Screenshot.to(driver, "Error:Textfield 'Name ' esta presente");
                }

                driver.switchTo().defaultContent();

            }catch (Exception e){

            }

            return this;
        }


        public Payment andBuild() {
            return new Payment(PaymentInfo.builder().payment(this.payment).build());
        }
    }


    @Builder
    public static class PaymentInfo { String payment; }

}
