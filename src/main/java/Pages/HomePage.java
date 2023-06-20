package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setSearchText(String value) {
        String Loc = "//input[@id='user_login']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.sendKeys(value);
    }
    public void setSearchText1(String value) {
        String Loc = "//input[@id='login__user_password']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.sendKeys(value);
    }
    public void clickSearchButton() {
        String Loc = "//button[@type='button']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }
    public void SetGoals() {
       String Loc = "//a[@class='e1w6mdco0 gamut-1fh2qtv-ResetElement-createButtonComponent e1bhhzie0']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }

    public void MailSettings() {
        WebElement ele = this.driver.findElement(By.linkText("Mail Settings"));
        ele.click();
    }
    //div[@class='gamut-jes3qs-CheckboxElement ev04j9m4']
    public void TickBox() {
        String Loc = "//div[@class='gamut-jes3qs-CheckboxElement ev04j9m4']";
        WebElement ele = this.driver.findElement(By.xpath(Loc));
        ele.click();
    }





}
