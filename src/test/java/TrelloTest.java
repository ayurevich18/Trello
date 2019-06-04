import core.BasePage;
import core.BrowserFactory;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TrelloTest extends BrowserFactory {
    public BoardPage boardPage;
    public BoardPage boardPage1;

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        driver.get("https://trello.com/login");
        loginPage.login("aleksej.yurevich@gmail.com", "12345678q");
        Assert.assertTrue(!driver.findElements(By.cssSelector(".mod-add")).isEmpty(), "Board page not opened");
    }

    @Test(dependsOnMethods = "loginTest")
    public void madeFavoriteBoardTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.makeFavoriteBoard();
        Assert.assertEquals(mainPage.getFavoriteBoardName(), "999");
    }

    @Test(dependsOnMethods = "madeFavoriteBoardTest")
    public void createBoardTest() {
        createBoard("test777");
        String boardName = (driver.getTitle()).substring(0, 7);
        Assert.assertEquals(boardName, "test777");
        boardPage = new BoardPage(driver);
        boardPage.writeBoardUrl();

    }

    @Test(dependsOnMethods = "createBoardTest")
    public void delBoardTest() throws InterruptedException {
        driver.get("https://trello.com/aleksey899/boards");
        createBoard("test000");
        BoardPage boardPage1 = new BoardPage(driver);
        boardPage1.deleteBoard();
        Assert.assertEquals(boardPage1.find(By.cssSelector("div>h1")).getText(), "Board not found.");
    }

    @Test(dependsOnMethods = "delBoardTest")
    public void makePublicPermTest() {
        driver.get("https://trello.com/aleksey899/boards");
        createBoard("testpublic");
        boardPage1 = new BoardPage(driver);
        boardPage1.changePermission(false);
        boardPage1.writeBoardUrl();
    }

    @Test(dependsOnMethods = "makePublicPermTest")
    public void logoutTest() {
        MainPage mainPage = new MainPage(driver);
        mainPage.logout();
        Assert.assertEquals(driver.getCurrentUrl(), "https://trello.com/logged-out");

    }

    @Test(dependsOnMethods = "logoutTest")
    public void checkPermission() {
        driver.manage().deleteAllCookies();
        driver.get(boardPage.boardUrl);
        Assert.assertEquals(boardPage.find(By.cssSelector("div>h1")).getText(), "Board not found.");

    }

    @Test(dependsOnMethods = "checkPermission")
    public void checkPubPermTest() {
        driver.get(boardPage1.boardUrl);
        Assert.assertTrue(boardPage1.find(By.cssSelector("#permission-level")).isDisplayed());

    }

    private void createBoard(String name) {
        MainPage mainPage = new MainPage(driver);
        mainPage.createBoard(name);
    }
}
