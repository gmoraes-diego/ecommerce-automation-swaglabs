package Pages;

import Runners.RunnerBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage {
    private final WebDriver driver;

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(xpath = "//div[normalize-space(text())='Sauce Labs Backpack']")
    private WebElement productName;

    @FindBy(xpath = "//div[text()='29.99']")
    private WebElement productPrice;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement buttonAddToCart;

    //@FindBy(css = "shopping-cart-link")
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement cartIcon;

    // @FindBy(css = "shopping-cart-badge")
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a/span")
    private WebElement cartBadge;

    public ProductPage() {
        this.driver = RunnerBase.getDriver();
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    // Valida o nome do produto e armazena para comparação futura.
    public boolean validarNomeProduto(String nomeEsperado) {
        String nomeAtual = productName.getText().trim();
        return nomeAtual.equalsIgnoreCase(nomeEsperado);
    }

    public boolean validarPrecoProduto(String precoEsperado) {
        String precoAtual = productPrice.getText().trim();
        return precoAtual.equalsIgnoreCase(precoEsperado);
    }

    // clica no botão "Adicionar ao carrinho
    public void adicionarProdutoAoCarrinho() {
        buttonAddToCart.click();
    }

    // Valida que 1 item foi adicionado ao carrinho
    public boolean validarQuantidadeNoCarrinho(String quantidadeEsperada) {
        String quantidadeAtual = cartBadge.getText().trim();
        return quantidadeAtual.equals(quantidadeEsperada);
    }

    // Clica no ícone para navegar até a página do carrinho
    public void acessarCarrinho() {
        cartIcon.click();
    }
}
