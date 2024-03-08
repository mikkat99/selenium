package ru.katkova.tests;

import extension.DriverExtention;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import steps.LoginSteps;
import java.util.Properties;
import static project.properties.TestProperties.getINSTANCE;;

@ExtendWith(DriverExtention.class)
class SecondTrainingApplineTest {
    private LoginSteps loginSteps = new LoginSteps();
    private final Properties properties = getINSTANCE().getProperties();

    @Test
    void test() {
        //Авторизация
        loginSteps
                .login(properties.getProperty("LOGIN"), properties.getProperty("PASSWORD"))
                .filterByAssignment();
    }

}
