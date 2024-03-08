package steps;

import pages.MainPage;


public class MainPageSteps {
    public void filterByAssignment(){
        MainPage mainPage = new MainPage();
        mainPage.costsClick();
        mainPage.assignmentClick();
    }
}
