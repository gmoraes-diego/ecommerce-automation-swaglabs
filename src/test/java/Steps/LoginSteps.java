package Steps;

import Pages.LoginPage;
import Utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private final LoginPage loginPage = new LoginPage(); // Instancia a página de login
    private final WebDriver driver = loginPage.getDriver(); // Obtém o WebDriver da LoginPage

    @Given("que eu estou na página de login do SauceDemo")
    public void queEuEstouNaPaginaDeLoginDoSauceDemo() {
        driver.get("https://www.saucedemo.com/"); // Acessa a página de login

        // Aguarda até que o campo de username esteja visível antes de prosseguir
        Utils.waitForElementToBeVisible(driver, loginPage.getUsernameField(), 10);
    }

    @When("preencho os campos Username e Password")
    public void preenchoOsCamposUsernameEPassword() {
        loginPage.enterUsername("standard_user"); // Insere o nome de usuário
        loginPage.enterPassword("secret_sauce"); // Insere a senha
    }

    @And("clico em Login")
    public void clicoEmLogin() {
        loginPage.clickLogin(); // Clica no botão de login
    }

    @Then("devo ser redirecionado para página de produtos")
    public void devoSerRedirecionadoParaPaginaDeProdutos() {
        String currentUrl = driver.getCurrentUrl(); // Obtém a URL atual

        // Verifica se a URL contém "inventory.html" para confirmar que o redirecionamento ocorreu corretamente
        Assert.assertTrue("A URL não corresponde à página de produtos.", currentUrl.contains("inventory.html"));
    }

    @And("devo visualizar o título da página")
    public void devoVisualizarOTituloDaPagina() {
        String expectedTitle = "Swag Labs"; // Define o título esperado
        String actualTitle = driver.getTitle(); // Obtém o título da página atual

        // Valida se o título da página corresponde ao esperado
        Assert.assertEquals("O título da página não está correto.", expectedTitle, actualTitle);
    }
}
