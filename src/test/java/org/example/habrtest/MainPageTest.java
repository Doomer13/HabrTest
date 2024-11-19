package org.example.habrtest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

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

        WebElement enter = driver.findElement(By.xpath("//button[contains(@class,'btn btn_solid btn_small tm-header-user-menu__login')]"));
        enter.click();

        WebElement enter2 = driver.findElement(By.xpath("//*[contains(text(), 'Вход')]"));


        assertTrue(enter2.isDisplayed(), "Элемент Вход не обнаружен");
    }

    @Test
    public void changemain() {

        WebElement langweech = driver.findElement(By.xpath("//button[contains(@class, 'tm-footer__link')]"));
        langweech.click();

        WebElement darkmain = driver.findElement(By.xpath("//*[@id=\"overlays\"]/div/div[2]/div/div/form/div[5]/div[2]/p[1]/div/label/div/span"));
        darkmain.click();

        WebElement chekpoint = driver.findElement(By.xpath("//button[contains(@type,'submit')]"));
        chekpoint.click();

        WebElement proverkaelementa = driver.findElement(By.xpath("//h1[contains(text(), \"Моя лента\")]"));
        assertTrue(proverkaelementa.isDisplayed(), "Элемент @Моя лента@  не обнаружен");

    }




}
