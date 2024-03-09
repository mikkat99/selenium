package steps;

import pages.FillingInTheFieldsPage;

public class FillingInTheFieldsSteps {
    final FillingInTheFieldsPage fillingInTheFieldsPage = new FillingInTheFieldsPage();
    public FillingInTheFieldsSteps fillingFieldDivision() {
        fillingInTheFieldsPage.divisionSelect();
        return new FillingInTheFieldsSteps();
    }
    public FillingInTheFieldsSteps fillingFieldCompany() {
        fillingInTheFieldsPage.organizationSelect();
        return new FillingInTheFieldsSteps();
    }
    public FillingInTheFieldsSteps saveAndClose() {
        fillingInTheFieldsPage.saveAndClose();
        return new FillingInTheFieldsSteps();
    }

    public FillingInTheFieldsAssertSteps filledField(String inputArrivalCity, String departureDate, String returnDate) {

        fillingInTheFieldsPage.fillingRemagFields(inputArrivalCity, departureDate, returnDate);
        return new FillingInTheFieldsAssertSteps();
    }
}
