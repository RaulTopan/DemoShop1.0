package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver; // mai initializeaza odata obiectul web driver pentru a putea fi folosit ulterior

    @BeforeMethod
    public void setUp() {  // se declara locatia chrome driver-ului randul 13
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Raul Topan\\IdeaProjects\\ProiectFinal\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://fasttrackit-test.netlify.app/#/"); //prin driver se declara webpage-ul
    }

    @AfterMethod
    public void tearDown() { // daca driver-ul mai e initializat, dupa ce termian programul de rulat se inchide google chrome
        if (driver != null) {
            driver.quit();
        }
    }
}