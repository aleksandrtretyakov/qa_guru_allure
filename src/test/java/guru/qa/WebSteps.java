package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repo}")
    public void SearchForRepo(String repo) {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(repo);
        $(".header-search-input").submit();
    }

    @Step("Переходим по ссылке репозитория {repo}")
    public void clickOnRepoLink(String repo) {
        $(linkText("eroshenkoam/allure-example")).click();
    }

    @Step("Кликаем на таб Issues")
    public void openIssueTab() {
        $(partialLinkText("Issues")).click();
    }

    @Step("Проверяем что существует Issue c номером {number}")
    public void shouldSeeIssueWithNumber(Integer number) {
        $(withText("#" + number))
                .shouldBe(Condition.visible);
        attachScreenshot();
    }

    // Делаем скриншот и добавляем вызов метода в любой шаг
    @Attachment(value = "Необходимый скриншот", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}