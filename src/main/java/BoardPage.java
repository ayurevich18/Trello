import core.BasePage;
import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class BoardPage extends BasePage {
    public BoardPage(WebDriver driver) {
        super(driver);
    }

    public String boardUrl;
    private By showMenu = By.cssSelector("a.board-header-btn.mod-show-menu.js-show-sidebar");
    private By permissionMenu = By.cssSelector("#permission-level");
    private By pubPermission = By.cssSelector("a[name='public']");
    private By privatPermission = By.cssSelector("a[name='private']");
    private By confirmbutton = By.cssSelector("button.make-public-confirmation-button");
    private By moreButton=By.cssSelector("a.board-menu-navigation-item-link.js-open-more");
    private By closeBoardButton=By.cssSelector("a.board-menu-navigation-item-link.js-close-board");

    public void changePermission(boolean a) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.attributeContains(permissionMenu, "title", "Only board members can see and edit this board."));
        clickOn(permissionMenu);
        if (a == true) {
            clickOn(privatPermission);
        } else clickOn(pubPermission);
        clickOn(confirmbutton);
        new WebDriverWait(driver, 10).until(ExpectedConditions.attributeContains(permissionMenu, "title", "Anyone on the internet (including Google) can see this board. Only board members can edit."));

    }

    public void deleteBoard()throws InterruptedException{
        clickOn(moreButton);
        new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#id-short-url")));
        clickOn(closeBoardButton);
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.cssSelector("span.pop-over-header-title"),"Close Board?"));
        clickOn(By.cssSelector("input.js-confirm.full.negate"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.cssSelector("div>h1"),"test000 is closed."));
        clickOn(By.cssSelector("a.quiet.js-delete"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.cssSelector("span.pop-over-header-title"),"Delete Board?"));
        jsClick(By.cssSelector("input[value='Delete']"));
        new WebDriverWait(driver, 10).until(ExpectedConditions.textToBe(By.cssSelector("div>h1"),"Board not found."));


    }

    public void writeBoardUrl() {
        boardUrl = driver.getCurrentUrl();

    }
}
