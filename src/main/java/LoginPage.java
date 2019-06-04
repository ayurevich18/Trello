import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailFld = By.cssSelector("#user");
    private By passwordFld = By.cssSelector("#password");
    private By loginBth = By.cssSelector("#login");

    public void login(String email, String password) {
        sendText(emailFld, email);
        sendText(passwordFld, password);
        clickOn(loginBth);
        new WebDriverWait(driver, 10).until(ExpectedConditions.urlToBe("https://trello.com/aleksey899/boards"));
    }

}
