package Runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


/* Classe responsável por gerenciar a instância do WebDriver. Garante que a inicialização e finalização
 sejam controladas corretamente durante os testes. */
public class RunnerBase {

    // Armazena uma instância única do WebDriver
    private static WebDriver driver;

    /**
     * Retorna a instância atual do WebDriver ou a inicializa, se ainda não existir.
     *
     * @return Instância do WebDriver.
     */
    public static WebDriver getDriver() {
        // Verifica se a instância do WebDriver já foi criada
        if (driver == null) {
            // Define o caminho do driver do Chrome se não estiver já definido via propriedade do sistema
            if (System.getProperty("webdriver.chrome.driver") == null) {
                System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
            }

            // Cria e configura opções para o Chrome
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized"); /// Inicia o navegador maximizado
            options.addArguments("--disable-notifications"); // Desativa notificações do navegador

            // Instancia o WebDriver com as opções definidas
            driver = new ChromeDriver(options);

            // Define um tempo de espera implícito para localização de elementos
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        // Retorna a instância atual do WebDriver
        return driver;
    }

    /**
     * Encerra a instância atual do WebDriver e fecha o navegador.
     * Torna o driver nulo para permitir uma nova inicialização futura.
     */
    public static void quitDriver() {
        // Verifica se o driver está instanciado antes de tentar encerrar
        if (driver != null) {
            driver.quit(); // Encerra a sessão do navegador
            driver = null; // Reseta a variável para permitir nova criação se necessário
        }
    }
}
