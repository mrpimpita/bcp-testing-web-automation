package com.automation.testing.frontend.tasks;

import lombok.Builder;
import org.openqa.selenium.WebDriver;

public class NavigateTo {

    private final NavigateInfo navigateInfo;

    public NavigateTo(NavigateInfo navigateInfo) {
        this.navigateInfo = navigateInfo;
    }

    public static NavigateBuilder theWebPagePeruRail(WebDriver driver) throws Throwable {
        return new NavigateBuilder(driver);
    }

    public static class NavigateBuilder{

        private String navigate;

        protected String URL_PERU_RAUL = "https://www.perurail.com/";

        public NavigateBuilder(WebDriver driver) {

            try {

                driver.navigate().to(URL_PERU_RAUL);

                this.navigate=navigate;

            }catch (Exception e){

                System.out.println(e.getMessage());
            }
        }

        public NavigateTo andBuild(){
            return new NavigateTo(
                    NavigateInfo.builder()
                            .navigate(this.navigate)
                            .build());
        }
    }


    @Builder
    private static class NavigateInfo { String navigate;}
}



