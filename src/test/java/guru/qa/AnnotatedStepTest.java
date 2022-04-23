package guru.qa;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;


public class AnnotatedStepTest {

    private static final String Repository = "eroshenkoam/allure-example";
    private static final Integer IssueNumber = 66;

    @Test
    public void testGithubIssue() {

        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.SearchForRepo(Repository);
        steps.clickOnRepoLink(Repository);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(IssueNumber);
    }
}



