import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Тестирование главной страницы МТС")
@Feature("Проверка функционала онлайн-платежей")
public class MTSMainPageTest {

    private WebDriver driver;
    private MtsBase mtsBase;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "--start-maximized");
        driver = new ChromeDriver(options);
        mtsBase = new MtsBase(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    @Order(1)
    @Story("Элементы интерфейса")
    @DisplayName("Проверка заголовка блока платежей")
    @Description("Тест проверяет корректность отображения основного заголовка")
    @Severity(SeverityLevel.BLOCKER)
    void verifyPaymentBlockTitle() {
        openMainPage();
        acceptCookies();
        verifyHeaderText("Онлайн пополнение без комиссии");
    }

    @Test
    @Order(2)
    @Story("Элементы интерфейса")
    @DisplayName("Проверка отображения логотипов платежных систем")
    @Severity(SeverityLevel.CRITICAL)
    void verifyPaymentLogos() {
        openMainPage();
        acceptCookies();

        checkLogosContainerVisibility();
        verifyLogoPresence("Visa");
        verifyLogoPresence("Mastercard");
        verifyLogoPresence("Белкарт");
    }

    @Test
    @Order(3)
    @Story("Навигация")
    @DisplayName("Проверка корректной работы ссылки 'Подробнее о сервисе'")
    @Severity(SeverityLevel.NORMAL)
    void verifyDetailsLinkFunctionality() {
        openMainPage();
        acceptCookies();

        WebElement link = findDetailsLink();
        checkLinkVisibility(link);
        checkLinkEnabledState(link);
        verifyLinkHasHref(link);
    }

    @Test
    @Order(4)
    @Story("Формы ввода")
    @DisplayName("Проверка работы формы оплаты")
    @Severity(SeverityLevel.CRITICAL)
    void verifyPaymentFormSubmission() {
        openMainPage();
        acceptCookies();

        selectServiceTab();
        fillPhoneNumber(MtsBase.TEST_PHONE);
        fillEmail(MtsBase.TEST_EMAIL);
        enterPaymentAmount(MtsBase.TEST_SUM);
        verifyContinueButtonState();
    }

    @Test
    @Order(5)
    @Story("Формы ввода")
    @DisplayName("Проверка плейсхолдеров для вкладки Услуги связи")
    @Severity(SeverityLevel.NORMAL)
    void verifyMobileServicesPlaceholders() {
        openMainPage();
        acceptCookies();
        selectServiceTab();

        checkPlaceholderText(mtsBase.getPhoneFieldPlaceholder(), "Номер телефона");
        checkPlaceholderText(mtsBase.getSumFieldPlaceholder(), "Сумма");
        checkPlaceholderText(mtsBase.getEmailFieldPlaceholder(), "E-mail для отправки чека");
    }

    @Test
    @Order(6)
    @Story("Формы ввода")
    @DisplayName("Проверка плейсхолдеров для вкладки Домашний интернет")
    @Severity(SeverityLevel.NORMAL)
    void verifyHomeInternetPlaceholders() {
        openMainPage();
        acceptCookies();
        selectHomeInternetTab();

        checkPlaceholderText(mtsBase.getHomeInternetAccountPlaceholder(), "Номер абонента");
        checkPlaceholderText(mtsBase.getSumFieldPlaceholder(), "Сумма");
        checkPlaceholderText(mtsBase.getEmailFieldPlaceholder(), "E-mail для отправки чека");
    }

    @Test
    @Order(7)
    @Story("Формы ввода")
    @DisplayName("Проверка плейсхолдеров для вкладки Рассрочка")
    @Severity(SeverityLevel.NORMAL)
    void verifyInstallmentPlaceholders() {
        openMainPage();
        acceptCookies();
        selectInstallmentTab();

        checkPlaceholderText(mtsBase.getInstallmentAccountPlaceholder(), "Номер счета на 44");
        checkPlaceholderText(mtsBase.getSumFieldPlaceholder(), "Сумма");
        checkPlaceholderText(mtsBase.getEmailFieldPlaceholder(), "E-mail для отправки чека");
    }

    @Test
    @Order(8)
    @Story("Формы ввода")
    @DisplayName("Проверка плейсхолдеров для вкладки Задолженность")
    @Severity(SeverityLevel.NORMAL)
    void verifyDebtPlaceholders() {
        openMainPage();
        acceptCookies();
        selectDebtTab();

        checkPlaceholderText(mtsBase.getDebtAccountPlaceholder(), "Номер счета на 2073");
        checkPlaceholderText(mtsBase.getSumFieldPlaceholder(), "Сумма");
        checkPlaceholderText(mtsBase.getEmailFieldPlaceholder(), "E-mail для отправки чека");
    }

    @Test
    @Order(9)
    @Story("Платежная форма")
    @DisplayName("Проверка элементов платежной формы")
    @Severity(SeverityLevel.CRITICAL)
    void verifyPaymentFormElements() {
        openMainPage();
        acceptCookies();

        PaymentPage paymentPage = submitPaymentForm();
        verifyPaymentFormContent(paymentPage);
    }

    // Реализация шагов

    @Step("Открытие главной страницы")
    private void openMainPage() {
        mtsBase.open();
    }

    @Step("Принятие cookies")
    private void acceptCookies() {
        mtsBase.acceptCookies();
    }

    @Step("Проверка текста заголовка: {expectedText}")
    private void verifyHeaderText(String expectedText) {
        WebElement header = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(
                        By.xpath("//h2[contains(., 'Онлайн пополнение без комиссии')]")));

        String actualText = header.getText()
                .replace("\n", " ")
                .replaceAll("\\s+", " ")
                .trim();

        assertEquals(expectedText, actualText, "Текст заголовка не соответствует ожидаемому");
    }

    @Step("Проверка видимости контейнера с логотипами")
    private void checkLogosContainerVisibility() {
        WebElement container = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> {
                    WebElement element = driver.findElement(By.cssSelector(".pay__partners"));
                    assertTrue(element.isDisplayed(), "Контейнер с логотипами не отображается");
                    return element;
                });
    }

    @Step("Проверка наличия логотипа: {logoName}")
    private void verifyLogoPresence(String logoName) {
        List<WebElement> logos = driver.findElements(By.cssSelector(".pay__partners img"));
        boolean isLogoPresent = logos.stream()
                .anyMatch(logo ->
                        logo.isDisplayed() &&
                                Stream.of("alt", "src", "class")
                                        .map(attr -> logo.getAttribute(attr))
                                        .anyMatch(attrValue ->
                                                attrValue != null &&
                                                        attrValue.toLowerCase().contains(logoName.toLowerCase())
                                        )
                );

        assertTrue(isLogoPresent, "Логотип " + logoName + " не найден");
    }

    @Step("Поиск ссылки 'Подробнее о сервисе'")
    private WebElement findDetailsLink() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(
                        By.xpath("//a[contains(., 'Подробнее о сервисе')]")));
    }

    @Step("Проверка видимости элемента")
    private void checkLinkVisibility(WebElement element) {
        assertTrue(element.isDisplayed(), "Элемент не отображается");
    }

    @Step("Проверка активности элемента")
    private void checkLinkEnabledState(WebElement element) {
        assertTrue(element.isEnabled(), "Элемент неактивен");
    }

    @Step("Проверка наличия атрибута href")
    private void verifyLinkHasHref(WebElement element) {
        assertNotNull(element.getAttribute("href"), "Отсутствует атрибут href");
    }

    @Step("Выбор вкладки 'Услуги связи'")
    private void selectServiceTab() {
        mtsBase.selectServicesTab();
    }

    @Step("Ввод номера телефона: {phone}")
    private void fillPhoneNumber(String phone) {
        mtsBase.enterPhoneNumber(phone);
    }

    @Step("Ввод email: {email}")
    private void fillEmail(String email) {
        mtsBase.enterEmail(email);
    }

    @Step("Ввод суммы платежа: {amount}")
    private void enterPaymentAmount(String amount) {
        mtsBase.enterSum(amount);
    }

    @Step("Проверка состояния кнопки 'Продолжить'")
    private void verifyContinueButtonState() {
        WebElement button = driver.findElement(mtsBase.continueButton);
        assertTrue(button.isEnabled(), "Кнопка неактивна");
        assertEquals(MtsBase.TEST_PHONE, mtsBase.getEnteredPhoneNumber(), "Номер телефона не совпадает");
        assertEquals(MtsBase.TEST_SUM, mtsBase.getEnteredSum(), "Сумма не совпадает");
    }

    @Step("Проверка текста плейсхолдера")
    private void checkPlaceholderText(String actual, String expected) {
        assertEquals(expected, actual, "Неверный текст плейсхолдера");
    }

    @Step("Выбор вкладки 'Домашний интернет'")
    private void selectHomeInternetTab() {
        mtsBase.selectHomeInternetTab();
    }

    @Step("Выбор вкладки 'Рассрочка'")
    private void selectInstallmentTab() {
        mtsBase.selectInstallmentTab();
    }

    @Step("Выбор вкладки 'Задолженность'")
    private void selectDebtTab() {
        mtsBase.selectDebtTab();
    }

    @Step("Отправка платежной формы")
    private PaymentPage submitPaymentForm() {
        return mtsBase.fillAndSubmitPaymentForm(
                "297777777",
                "100",
                "kupikota@test.com"
        );
    }

    @Step("Проверка содержимого платежной формы")
    private void verifyPaymentFormContent(PaymentPage paymentPage) {
        assertAll("Проверка элементов платежной формы",
                () -> assertTrue(paymentPage.isPaymentFrameDisplayed(),
                        "Платежное окно не отображается"),
                () -> assertEquals("100.00 BYN", paymentPage.getDisplayedSum(),
                        "Неверная сумма платежа"),
                () -> assertTrue(paymentPage.getDisplayedPhoneNumber().contains("375297777777"),
                        "Номер телефона не соответствует"),
                () -> assertEquals("Номер карты", paymentPage.getCardNumberLabel(),
                        "Неверный плейсхолдер для номера карты"),
                () -> assertEquals("Срок действия", paymentPage.getExpiryDateLabel(),
                        "Неверный плейсхолдер для срока действия"),
                () -> assertEquals("CVC", paymentPage.getCvcLabel(),
                        "Неверный плейсхолдер для CVC"),
                () -> assertEquals(4, paymentPage.getPaymentSystemsCount(),
                        "Неверное количество платежных систем"),
                () -> assertTrue(paymentPage.isPaymentSystemVisible("Visa"),
                        "Логотип Visa отсутствует"),
                () -> assertTrue(paymentPage.isPaymentSystemVisible("Mastercard"),
                        "Логотип Mastercard отсутствует"),
                () -> assertTrue(paymentPage.isPaymentSystemVisible("Белкарт"),
                        "Логотип Белкарт отсутствует"),
                () -> assertTrue(paymentPage.getSubmitButtonText().contains("100.00 BYN"),
                        "Неверная сумма на кнопке оплаты")
        );
    }

    @AfterEach
    @Step("Завершение теста")
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}