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
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void enterUsername(String userName) {
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    // 👉 Getters necessários para a classe de Steps
    // Retorna a instância atual do WebDriver usado por esta página
    public WebDriver getDriver() {
        return this.driver; // faz referência ao driver da classe LoginPage
    }

    // Retorna o WebElement correspondente ao campo de nome de usuário na tela de login
    public WebElement getUsernameField() {
        return this.userNameField; // aponta para o campo localizado com @FindBy
    }
}
