package Steps;

import Pages.LoginPage;
import Runners.RunnerBase;
import Utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage(); // Instancia a página de login
    private final WebDriver driver = loginPage.getDriver(); // Obtém o WebDriver da LoginPage

    @Given("que eu estou na página de login do e-commerce Swag Labs")
    public void queEuEstouNaPaginaDeLoginDoSauceDemo() {
        driver.get("https://www.saucedemo.com/"); // Acessa a página de login do Swag Labs,

        /*Recebe o localizador do elemento através do getUsernameField e aguarda até que o campo de username
        esteja visível antes de prosseguir*/
        Utils.waitForElementToBeVisible(driver, loginPage.getUsernameField(), 10);
    }

    @When("preencho os campos com username {string} e password {string}")
    public void preenchoOsCamposComUsernameEPassword(String username, String password) {
        loginPage.enterUsername(username); // Insere o nome de usuário recebido como argumento
        loginPage.enterPassword(password); // Insere a senha recebida como argumento
    }

    @And("clico em Login")
    public void clicoEmLogin() { loginPage.clickLogin(); }

    @Then("devo ser redirecionado para página de produtos")
    public void devoSerRedirecionadoParaPaginaDeProdutos() {
        // Obtém a URL da página atual no navegador
        String currentUrl =  driver.getCurrentUrl();

        // Verifica se a URL contém "inventory.html" para confirmar que o redirecionamento ocorreu corretamente
        Assert.assertTrue("A URL não corresponde à página de produtos.", currentUrl.contains("inventory.html"));
    }

    @And("devo visualizar o título da página")
    public void devoVisualizarOTituloDaPagina() {
        String expectedTitle = "Swag Labs"; // Título que esperamos que a página tenha
        String actualTitle = driver.getTitle(); // Captura o título real da página exibida

        Assert.assertEquals("O título da página não está correto.", expectedTitle, actualTitle);
    }
}
