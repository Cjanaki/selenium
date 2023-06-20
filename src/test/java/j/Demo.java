package j;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Demo {
        public static void main(String[] args) {
            String ChromeDriverPath = "C:\\Software\\chromedriver_ver113\\chromedriver\\chromedriver.exe";
            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            System.setProperty("webdriver.chrome.driver", "ChromeDriverPath");
            driver.get("https://www.codecademy.com");
            driver.findElement(By.xpath("//a[@data-testid='header-sign-in']")).click();
           // driver.findElement(By.xpath("//a[@class='e1w6mdco0 gamut-yv5r9n-ResetElement-createButtonComponent e1bhhzie0']")).click();
           // driver.findElement(By.xpath("//input[@id='email']")).sendKeys("janurishithachitturi2795@gmail.com");
           // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456789@Code");
            driver.findElement(By.xpath("//div//input[@id='user_login']")).sendKeys(("janurishithachitturi2795@gmail.com"));
            driver.findElement(By.xpath("//input[@id='login__user_password']")).sendKeys(("123456789@Code"));
            driver.findElement(By.xpath("//button[@type='submit']")).click();



        }




}
