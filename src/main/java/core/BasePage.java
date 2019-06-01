package core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement find(By element) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        return driver.findElement(element);
    }

    public List<WebElement> finds(By element) {

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

        return driver.findElements(element);
    }

    public void textInput(By element, String text) {
        WebElement elem = find(element);
        elem.clear();
        elem.sendKeys(text);
    }

    public void jsClick(By element) {
        WebElement elem = find(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", elem);
    }

    public void otherClick(By element) {
        WebElement elem = find(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(elem).click().perform();
    }

    public void clickOn(By element) {
        WebElement elem = find(element);
        elem.click();
    }

    public void selectDefaultDropDown(String value, By element) {
        WebElement element1 = find(element);
        Select day = new Select(element1);
        day.selectByValue(value);

    }

}