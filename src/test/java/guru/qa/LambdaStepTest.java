package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {
    private static final String Repository = "eroshenkoam/allure-example";
    private static final Integer IssueNumber = 66;

    @Test
    public void testGithubIssue() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий" + " " + Repository, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys("eroshenkoam/allure-example");
            $(".header-search-input").submit();
        });
        step("Переходим по ссылке репозитория" + " " + Repository, () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("Кликаем на таб Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем что существует Issue c номером" + " " + IssueNumber, () -> {
            $(withText("#" + IssueNumber)).shouldBe(Condition.visible);
        });
// Вызов снэпшот-мэйкера в Аллюр
        Allure.getLifecycle().addAttachment(
                "Исходники страницы",
                "text/html",
                "html",
                WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
        );
    }
}



