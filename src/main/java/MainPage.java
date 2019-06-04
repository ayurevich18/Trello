import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By settingButton = By.cssSelector(" button._3bl7HhpXOOyEkB._2OG55MZw5Ysbaz");
    private By logoutButton = By.cssSelector("[data-test-id='header-member-menu-logout']");
    private By createBoardMenu = By.cssSelector("div.board-tile");
    private By nameBoardInput = By.cssSelector(".subtle-input");
    private By createBoardButton = By.cssSelector("button[type='submit']");

    public void createBoard(String name) {
        otherClick(createBoardMenu);
        sendText(nameBoardInput, name);
        clickOn(createBoardButton);
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlContains(name));

    }


    public void logout() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(settingButton));
        clickOn(settingButton);
        clickOn(logoutButton);
    }

    public void makeFavoriteBoard() {
        Actions act = new Actions(driver);
        act.moveToElement(find(By.cssSelector("div[title='999'] ~ div > span"))).click(find(By.cssSelector("div[title='999'] ~ div > span"))).pause(Duration.ofSeconds(3)).perform();

    }

    public String getFavoriteBoardName() {
        String a = find(By.cssSelector("li.js-draggable>a")).getAttribute("href");
        return a.substring(a.lastIndexOf("/") + 1);
    }

}