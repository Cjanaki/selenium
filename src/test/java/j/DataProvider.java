package j;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DataProvider {
        WebDriver driver = null;
       @org.testng.annotations.DataProvider(name = "credentials")
        public Object[][] getData() {
            Object[][] obj = {
                    {"bothCorrect", "janurishithachitturi2795@gmil.com", "123456789@Code"},
                    {"bothWrong", "supraja2592", "Lakshmi@259"},
                    {"correctUsername", "janurishithachitturi2795@gmail.com", "aishu"},
                    {"correctPassword", "supraja2592", "123456789@Code"}
            };
            return obj;
        }
        @BeforeMethod
        public void setUp() throws IOException, ParseException, org.json.simple.parser.ParseException {
            String chromeDriverPath = "C:\\software\\chromedriver_ver113\\chromedriver\\chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            String LoginDataPath = "src/main/resources/ValidData.json";
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
            driver.manage().window().maximize();
            System.out.println(driver.getTitle());
            FileReader fr = new FileReader(LoginDataPath);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(fr);
            JSONObject jsonObject = (JSONObject) obj;
            String url = (String) jsonObject.get("url");
            System.out.println(url);
            driver.get(url);
        }
        @AfterMethod
        public void tearDown() throws InterruptedException {
            Thread.sleep(1000);
            driver.quit();
        }
        @Test(dataProvider = "credentials")
        public void verifyLoginCredentials(String scenario, String username, String password) throws IOException, org.json.simple.parser.ParseException {
            System.out.println("type=" + scenario + " " + "username= " + username + " " + "password=" + password);
            driver.findElement(By.xpath("//div//input[@id='user_login']")).sendKeys(("janurishithachitturi2795@gmail.com"));
            driver.findElement(By.xpath("//input[@id='login__user_password']")).sendKeys(("123456789@Code"));
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            String TestCases = "src/main/resources/ValidLogin.json";
            FileReader fr = new FileReader(TestCases);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(fr);
            if (scenario.equals("bothCorrect")) {
                System.out.println("login success");
            } else if (scenario.equals("bothWrong")) {
                System.out.println("login fail");
            } else if (scenario.equals("correctUsername")) {
                System.out.println("enter correct uname");
            } else {
                System.out.println("enter correct password");
            }
        }
}
