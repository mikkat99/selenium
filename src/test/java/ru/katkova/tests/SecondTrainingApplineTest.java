package ru.katkova.tests;

import extension.DriverExtention;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.FillingInTheFieldsAssertSteps;
import steps.FillingInTheFieldsSteps;
import steps.LoginSteps;
import java.util.Properties;
import static project.properties.TestProperties.getINSTANCE;;


@ExtendWith(DriverExtention.class)
class SecondTrainingApplineTest {
    private LoginSteps loginSteps = new LoginSteps();
    private FillingInTheFieldsSteps fillingInTheFieldsSteps = new FillingInTheFieldsSteps();
    private FillingInTheFieldsAssertSteps fillingInTheFieldsAssertSteps = new FillingInTheFieldsAssertSteps();
    private final Properties properties = getINSTANCE().getProperties();

    @Test
    void test() {
        // Авторизация
        loginSteps
                .login(properties.getProperty("LOGIN"), properties.getProperty("PASSWORD"))
                .filterByAssignment();
        fillingInTheFieldsSteps
                .fillingFieldDivision()
                .fillingFieldCompany()
                .filledField(properties.getProperty("inputArrivalCity"),
                        properties.getProperty("departureDate"),
                        properties.getProperty("returnDate"));
        fillingInTheFieldsAssertSteps
                .assertFields();
        fillingInTheFieldsSteps
                .saveAndClose();
        fillingInTheFieldsAssertSteps
                .assertMassage();
    }
}
