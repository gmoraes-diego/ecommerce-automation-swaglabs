package Pages;

import Runners.RunnerBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage() {
        this.driver = RunnerBase.getDriver(); // Usa o WebDriver do RunnerBase
        PageFactory.initElements(driver, this); // Inicializa os elementos da página
    }

    @FindBy(id = "user-name")
    private WebElement usernameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    // Métodos de ação
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    // 👉 Getters necessários para a classe de Steps
    public WebDriver getDriver() {
        return this.driver;
    }

    public WebElement getUsernameField() {
        return this.usernameField;
    }
}
