package org.example.habrtest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

//Подправленный Варинат в соответсии с замечаниями
public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.habr.com/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void search() {
        WebElement enter = driver.findElement(By.xpath("//button[contains(@class,'btn')]"));
        enter.click();
        WebElement enter2 = driver.findElement(By.xpath("//*[@class= 'shadow-box__title']"));

        assertTrue(enter2.isDisplayed(), "Элемент Вход не обнаружен");
    }

    @Test
    public void changemain() {
        WebElement langweech = driver.findElement(By.xpath("//button[contains(@class, 'tm-footer__link')]"));
        langweech.click();

        WebElement darkMain = driver.findElement(By.xpath(
                "(//*[@class=\"tm-input-radio-labeled__fake\"])[5]"));
        darkMain.click();

        WebElement chekpoint = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
        chekpoint.click();

        WebElement proverkaelementa = driver.findElement(By.xpath("(//nav/a)[1]"));
        assertTrue(proverkaelementa.isDisplayed(), "Элемент @Моя лента@  не обнаружен");
    }
}