import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideGitTests {

    @BeforeAll
    public static void configProperty () {
        Configuration.browserSize = System.getProperty("browserSize","1920x1080");
        Configuration.browser = System.getProperty("browser", "firefox");
        open("https://github.com/selenide/selenide");
    }

    @Test
    void findPageSoftAssertions () {
        $("#wiki-tab").click();
        $("#wiki-pages-filter").setValue("SoftAssertions");
        $(".filterable-active").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class:"));
    }
}
