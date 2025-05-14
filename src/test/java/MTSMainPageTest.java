import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MTSMainPageTest {
    protected WebDriver driver;
    private MtsBase mtsBase;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void setupTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        mtsBase = new MtsBase(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    @Order(1)
    @DisplayName("Проверка названия блока 'Онлайн пополнение без комиссии'")
    @Description("Тест проверяет наличие и корректность отображения заголовка блока платежей")
    @Epic("Проверка главной страницы")
    @Feature("Блок онлайн-платежей")
    @Story("Отображение заголовка блока платежей")

    void verifyBlockTitle() {
        mtsBase.open();
        mtsBase.acceptCookies();

        WebElement title = driver.findElement(By.xpath("//h2[contains(., 'Онлайн пополнение без комиссии')]"));
        String actualText = title.getText()
                .replace("\n", " ")
                .replaceAll("\\s+", " ")
                .trim();

        assertEquals("Онлайн пополнение без комиссии", actualText);
    }

    @Test
    @Order(2)
    @DisplayName("Проверка логотипов платежных систем")
    @Description("Тест проверяет наличие основных логотипов платежных систем (Visa, Mastercard, Белкарт)")
    @Epic("Проверка главной страницы")
    @Feature("Блок онлайн-платежей")
    @Story("Отображение логотипов платежных систем")
    void verifyPaymentLogo() {
        mtsBase.open();
        mtsBase.acceptCookies();

        WebElement logosContainer = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.cssSelector(".pay__partners")));

        List<WebElement> logoImages = logosContainer.findElements(By.tagName("img")).stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());

        assertAll("Проверка основных платежных систем",
                () -> assertTrue(hasLogo(logoImages, "Visa")),
                () -> assertTrue(hasLogo(logoImages, "Mastercard")),
                () -> assertTrue(hasLogo(logoImages, "Белкарт"))
        );
    }

    private boolean hasLogo(List<WebElement> logos, String brandName) {
        return logos.stream().anyMatch(logo ->
                Stream.of("alt", "src", "class")
                        .map(attr -> {
                            String value = logo.getAttribute(attr);
                            return value != null ? value.toLowerCase() : "";
                        })
                        .anyMatch(attrValue -> attrValue.contains(brandName.toLowerCase()))
        );
    }

    @Test
    @Order(3)
    @DisplayName("Проверка работы ссылки Подробнее о сервисе")
    @Description("Тест проверяет корректность перехода по ссылке на страницу Порядок оплаты и безопасность интернет платежей")
    @Epic("Проверка главной страницы")
    @Feature("Блок онлайн-платежей")
    @Story("Корректная работа ссылки Подробнее о сервисе")

    void verifyDetailsLink() {
        mtsBase.open();
        mtsBase.acceptCookies();

        WebElement detailsLink = driver.findElement(By.xpath("//a[contains(., 'Подробнее о сервисе')]"));

        assertAll("Проверка ссылки 'Подробнее о сервисе'",
                () -> assertTrue(detailsLink.isDisplayed()),
                () -> assertTrue(detailsLink.isEnabled()),
                () -> assertNotNull(detailsLink.getAttribute("href"))
        );
    }

    @Test
    @Order(4)
    @DisplayName("Проверка работы кнопки Продолжить")
    @Description("Тест проверяет корректность перехода по кнопке Продолжить в модальное окно для оплаты услуг")
    @Epic("Проверка главной страницы")
    @Feature("Блок онлайн-платежей")
    @Story("Корректная работа кнопки Продолжить")

    void verifyPaymentForm() {
        mtsBase.open();
        mtsBase.acceptCookies();
        mtsBase.selectServicesTab();
        mtsBase.enterPhoneNumber(MtsBase.TEST_PHONE);
        mtsBase.enterEmail(MtsBase.TEST_EMAIL);
        mtsBase.enterSum(MtsBase.TEST_SUM);

        assertTrue(driver.findElement(mtsBase.continueButton).isEnabled());
        assertEquals(MtsBase.TEST_PHONE, mtsBase.getEnterPhoneNumber());
        assertEquals(MtsBase.TEST_SUM, mtsBase.getEnteredSum());
    }

    @Test
    @Order(5)
    @DisplayName("Проверка работы Проверка плейсхолдеров для Услуг связи")
    @Description("Тест проверяет корректность отображения плейсхолдеров полей Услуги связи")
    @Epic("Проверка главной страницы")
    @Feature("Блок онлайн-платежей")
    @Story("Корректное отображение плейсхолдеров полей")

    void verifyEmptyFieldsPlaceholdersForMobileServices() {
        mtsBase.open();
        mtsBase.acceptCookies();
        mtsBase.selectServicesTab();

        assertAll("Проверка плейсхолдеров для Услуг связи",
                () -> assertEquals("Номер телефона", mtsBase.getPhoneFieldPlaceholder(),
                        "Неверный плейсхолдер для поля номера телефона"),
                () -> assertEquals("Сумма", mtsBase.getSumFieldPlaceholder(),
                        "Неверный плейсхолдер для поля суммы"),
                () -> assertEquals("E-mail для отправки чека", mtsBase.getEmailFieldPlaceholder(),
                        "Неверный плейсхолдер для поля email")
        );
    }

    @Test
    @Order(6)
    @DisplayName("Проверка работы Проверка плейсхолдеров для вкладки Домашний интернет")
    @Description("Тест проверяет корректность отображения плейсхолдеров полей вкладки Домашний интернет")
    @Epic("Проверка главной страницы")
    @Feature("Блок онлайн-платежей")
    @Story("Корректное отображение плейсхолдеров полей")
    void verifyEmptyFieldsPlaceholdersForHomeInternet() {
        mtsBase.open();
        mtsBase.acceptCookies();
        mtsBase.selectHomeInternetTab();

        assertAll("Проверка для Домашний интернет",
                () -> assertEquals("Номер абонента", mtsBase.getHomeInternetAccountPlaceholder(),
                        "Неверный плейсхолдер для номера абонента"),
                () -> assertEquals("Сумма", mtsBase.getSumFieldPlaceholder(),
                        "Неверный плейсхолдер для суммы"),
                () -> assertEquals("E-mail для отправки чека", mtsBase.getEmailFieldPlaceholder(),
                        "Неверный плейсхолдер для email")
        );
    }

    @Test
    @Order(7)
    @DisplayName("Проверка работы Проверка плейсхолдеров для вкладки Рассрочка")
    @Description("Тест проверяет корректность отображения плейсхолдеров полей вкладки Рассрочка")
    @Epic("Проверка главной страницы")
    @Feature("Блок онлайн-платежей")
    @Story("Корректное отображение плейсхолдеров полей")
    void verifyEmptyFieldsPlaceholdersForInstallment() {
        mtsBase.open();
        mtsBase.acceptCookies();
        mtsBase.selectInstallmentTab();

        assertAll("Проверка для Рассрочки",
                () -> assertEquals("Номер счета на 44", mtsBase.getInstallmentAccountPlaceholder(),
                        "Неверный плейсхолдер для номера счёта"),
                () -> assertEquals("Сумма", mtsBase.getSumFieldPlaceholder(),
                        "Неверный плейсхолдер для суммы"),
                () -> assertEquals("E-mail для отправки чека", mtsBase.getEmailFieldPlaceholder(),
                        "Неверный плейсхолдер для email")
        );
    }

    @Test
    @Order(8)
    @DisplayName("Проверка работы Проверка плейсхолдеров для вкладки Задолженность")
    @Description("Тест проверяет корректность отображения плейсхолдеров полей вкладки Задолженность")
    @Epic("Проверка главной страницы")
    @Feature("Блок онлайн-платежей")
    @Story("Корректное отображение плейсхолдеров полей")
    void verifyEmptyFieldsPlaceholdersForDebt() {
        mtsBase.open();
        mtsBase.acceptCookies();
        mtsBase.selectDebtTab();

        assertAll("Проверка для Задолженности",
                () -> assertEquals("Номер счета на 2073", mtsBase.getDebtAccountPlaceholder(),
                        "Неверный плейсхолдер для номера счёта"),
                () -> assertEquals("Сумма", mtsBase.getSumFieldPlaceholder(),
                        "Неверный плейсхолдер для суммы"),
                () -> assertEquals("E-mail для отправки чека", mtsBase.getEmailFieldPlaceholder(),
                        "Неверный плейсхолдер для e-mail")
        );
    }

    @Test
    @DisplayName("Проверка отображаемых элементов в платёжной форме")
    @Description("Проверка корректности отображения всех элементов платежной формы")
    @Epic("Онлайн платежи")
    @Feature("Оплата мобильной связи")
    @Story("Проверка платежной формы для пополнения мобильного номера")
    @Order(9)
    void verifyMobileServicesPaymentProcess() {
        PaymentPage paymentPage = mtsBase.fillAndSubmitPaymentForm(
                "297777777",
                "100",
                "kupikota@test.com"
        );

        assertAll("Проверка платежной страницы",
                () -> assertTrue(paymentPage.isPaymentFrameDisplayed(),
                        "Платежное окно не отображается"),
                () -> assertEquals("100.00 BYN", paymentPage.getDisplayedSum(),
                        "Неверная сумма платежа"),
                () -> assertTrue(paymentPage.getDisplayedPhoneNumber().contains("375297777777"),
                        "Номер телефона не соответствует ожидаемому"),
                () -> assertEquals("Номер карты", paymentPage.getCardNumberLabel(),
                        "Неверный плейсхолдер для номера карты"),
                () -> assertEquals("Срок действия", paymentPage.getExpiryDateLabel(),
                        "Неверный плейсхолдер для срока действия"),
                () -> assertEquals("CVC", paymentPage.getCvcLabel(),
                        "Неверный плейсхолдер для CVC"),
                () -> assertEquals(4, paymentPage.getPaymentSystemsCount(),
                        "Неверное количество платежных систем"),
                () -> assertTrue(paymentPage.isPaymentSystemVisible("Visa"),
                        "Логотип Visa не отображается"),
                () -> assertTrue(paymentPage.isPaymentSystemVisible("Mastercard"),
                        "Логотип Mastercard не отображается"),
                () -> assertTrue(paymentPage.isPaymentSystemVisible("Белкарт"),
                        "Логотип Белкарт не отображается"),
                () -> assertTrue(paymentPage.getSubmitButtonText().contains("100.00 BYN"),
                        "Неверная сумма на кнопке оплаты")
        );
    }

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

