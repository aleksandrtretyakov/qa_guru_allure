package guru.qa;


import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParametersTest {

    @Test
    @DisplayName("The best test in the world")
    public void testAnnotated() {
        Allure.parameter("Region", "Krasnodar region");
        Allure.parameter("Town", "Gelendzhik");
    }
}



