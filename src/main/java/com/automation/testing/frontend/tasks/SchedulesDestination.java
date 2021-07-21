package com.automation.testing.frontend.tasks;

import com.automation.testing.frontend.actions.Click;
import com.automation.testing.frontend.actions.GetElements;
import com.automation.testing.frontend.actions.Scroll;
import com.automation.testing.frontend.actions.WaitUntil;
import com.automation.testing.frontend.helpers.Screenshot;
import com.automation.testing.frontend.ui.SchedulesDestinationPage;
import lombok.Builder;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SchedulesDestination {

    private final SchedulesDestinationInfo schedulesDestinationInfo;

    public SchedulesDestination(SchedulesDestinationInfo schedulesDestinationInfo) {
        this.schedulesDestinationInfo = schedulesDestinationInfo;
    }

    public static SchedulesDestinationBuilder chooseTrain(WebDriver driver, String trainOnbound, String trainInbound) throws Throwable {
        return new SchedulesDestinationBuilder(driver, trainOnbound, trainInbound);
    }

    public static class SchedulesDestinationBuilder{

        private String schedulesDestination;

        public SchedulesDestinationBuilder(WebDriver driver, String trainOnbound, String trainInbound) throws Throwable {

            try {

                WaitUntil.presenceElement(driver, SchedulesDestinationPage.SD_TABLE_JOURNET);

                findTrain(driver, SchedulesDestinationPage.SD_LIST_SCHEDULE_ONBOUND, trainOnbound);

                Scroll.down(driver, 450);

                findTrain(driver, SchedulesDestinationPage.SD_LIST_SCHEDULE_INBOUND, trainInbound);

                this.schedulesDestination=schedulesDestination;

            }catch (Exception e){

                Screenshot.to(driver, "Error-chooseTrain");

                throw e;

            }
        }

        public SchedulesDestinationBuilder andContinue(WebDriver driver) throws Throwable {

            try {

                Click.on(driver, SchedulesDestinationPage.SD_BUTTON_CONTINUE);

            }catch (Exception e){

                Screenshot.to(driver, "Error-Continue");

                throw e;
            }

            return this;
        }

        public SchedulesDestination andBuild(){
            return new SchedulesDestination(
                    SchedulesDestinationInfo.builder()
                            .schedulesDestination(this.schedulesDestination)
                            .build());
        }
    }

    private static void findTrain(WebDriver driver, By locator, String value) throws Throwable {

        List<WebElement> elementList = GetElements.list(driver, locator);

        for (WebElement element:elementList) {

            if (StringUtils.equals(StringUtils.removeEnd(element.getText(), "i").trim(), value)){

                element.click();

                break;

            }

            Scroll.down(driver, 30);

        }
    }

    @Builder
    public static class SchedulesDestinationInfo { String schedulesDestination;}
}



