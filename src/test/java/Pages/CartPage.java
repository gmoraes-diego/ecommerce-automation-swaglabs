package Pages;

import Runners.RunnerBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private final WebDriver driver;

    public CartPage() {
        this.driver = RunnerBase.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[normalize-space(text())='Sauce Labs Backpack']")
    private WebElement productNameInCart;

    @FindBy(xpath = "//div[text()='29.99']")
    private WebElement productPriceInCart;


    public boolean validarNomeProdutoCarrinho(String nomeEsperado) {
        String nomeAtual = productNameInCart.getText().trim();
        return nomeAtual.equalsIgnoreCase(nomeEsperado);
    }

    public boolean validarPrecoCarrinho(String precoEsperado) {
        String precoAtual = productPriceInCart.getText().trim();
        return precoAtual.equalsIgnoreCase(precoEsperado);
    }
}
