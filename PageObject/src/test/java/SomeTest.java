import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.CoursePage;
import pages.MainPage;

public class SomeTest {

    private WebDriver driver;

    @BeforeAll
    public static void install() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUp() {
        // ChromeOptions options = new ChromeOptions();
        // options.addArguments("--remote-allow-origins=*");
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void setDown() {
        if (driver != null)
            driver.quit();
    }

    @Test
    public void someTest() {
        driver.get("https://otus.ru");
        String actual = new MainPage(driver)
                .getCards()
                .get(0)
                .getCourseName();
        String expected = "Системный аналитик и бизнес-аналитик";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void newTest1() {
        driver.get("https://otus.ru");

        String link = new MainPage(driver)
                .menuClick(2)
                .getCards()
                .get(0)
                .click(driver)
                .getTitle();
        System.out.print("link = " + link);

    }

    @Test
    public void newTest2() {
        driver.get("https://otus.ru");
        String duration = new MainPage(driver)
                .menuClick(2)
                .getCards()
                .get(0)
                .click(driver)
                .getDuration();
        System.out.println("duration = " + duration);
    }

    @Test
    public void newTest3() {
        driver.get("https://otus.ru");
        CoursePage page = new MainPage(driver)
                .menuClick(2)
                .getCards()
                .get(0)
                .click(driver);

        System.out.println("duration = " + page.getStartFrom());
        System.out.println("description = " + page.getDescription());
    }

    @Test
    public void newTest4() {
        driver.get("https://otus.ru");
        String aboutUsText = new MainPage(driver).aboutUsClick().getAboutUsText();
        System.out.println("aboutUsText = " + aboutUsText);

    }


}