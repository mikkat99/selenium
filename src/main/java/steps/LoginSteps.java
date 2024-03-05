package steps;

import pages.LoginPage;

public class LoginSteps {
    public MainPageSteps login(String login, String password){
        LoginPage loginPage = new LoginPage();
        loginPage.startPage();
        loginPage.enterLoginAndPassword(login, password);
        loginPage.submitClick();

        return new MainPageSteps();
    }
}
