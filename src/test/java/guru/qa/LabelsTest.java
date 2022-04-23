package guru.qa;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Owner("aleksandrtretyakov")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("The best test in the world")
    @Feature("Tasks in repo")
    @Story("Should see created issue in repo")
    @Link(value = "Mainpage", url = "https://github.com")
    public void testAnnotated() {

    }
}



