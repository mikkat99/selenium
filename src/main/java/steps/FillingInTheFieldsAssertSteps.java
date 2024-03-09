package steps;

import pages.FillingInTheFieldsAssertPage;
import project.properties.BasePage;

public class FillingInTheFieldsAssertSteps extends BasePage {
    FillingInTheFieldsAssertPage fillingInTheFieldsAssertPage = new FillingInTheFieldsAssertPage();

    public FillingInTheFieldsAssertSteps assertFields() {
        fillingInTheFieldsAssertPage.fillingInTheFieldsAssert();
        return new FillingInTheFieldsAssertSteps();
    }

    public void assertMassage() {

        fillingInTheFieldsAssertPage.assertMessage();
    }
}
