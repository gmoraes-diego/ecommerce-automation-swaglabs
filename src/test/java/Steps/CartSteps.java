package Steps;

import Pages.CartPage;
import Pages.LoginPage;
import Pages.ProductPage;
import Runners.RunnerBase;
import Utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class CartSteps {

    private final WebDriver driver = RunnerBase.getDriver();
    private final LoginPage loginPage = new LoginPage();
    private final ProductPage productPage = new ProductPage();
    private final CartPage cartPage = new CartPage();


    @Given("que estou logado no e-commerce Swag Labs com username {string} e password {string}")
    public void queEstouLogadoNoECommerceSwagLabsComUsernameEPassword(String username, String password) {
        driver.get("https://www.saucedemo.com/");

        Utils.waitForElementToBeVisible(driver, loginPage.getUsernameField(), 10);
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        Assert.assertEquals("Products", productPage.getPageTitle());
    }

    @When("eu adiciono o produto {string} ao carrinho")
    public void euAdicionoOProdutoAoCarrinho(String nomeEsperado) {
        // Valida e armazena o nome do produto
        boolean nomeValido = productPage.validarNomeProduto(nomeEsperado);
        assertTrue("O nome do produto não corresponde ao esperado", nomeValido);

        // Valida e armazena o preço do produto
        String precoEsperado = "$29.99";
        boolean precoValido = productPage.validarPrecoProduto(precoEsperado);
        assertTrue("O preço do produto não corresponde ao esperado", precoValido);

        // Adiciona o produto ao carrinho
        productPage.adicionarProdutoAoCarrinho();
    }

    @And("eu acesso a página do carrinho")
    public void euAcessoAPaginaDoCarrinho() {
        productPage.acessarCarrinho();
    }

    @Then("o produto {string} deve estar visível na página do carrinho")
    public void oProdutoDeveEstarVisivelNaPaginaDoCarrinho(String nomeEsperado) {
        boolean nomeValido = cartPage.validarNomeProdutoCarrinho(nomeEsperado);
        assertTrue("O nome do produto no carrinho não corresponde ao esperado", nomeValido);
    }

    @And("o preço do produto no carrinho deve ser {string}")
    public void oPrecoDoProdutoNoCarrinhoDeveSer(String precoEsperado) {
        boolean precoValido = cartPage.validarPrecoCarrinho(precoEsperado);
        assertTrue("O preço do produto no carrinho não é o esperado", precoValido);
    }

}
