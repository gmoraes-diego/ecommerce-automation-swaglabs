package Runners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


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
            options.addArguments("--start-maximized"); // Inicia o navegador maximizado
            options.addArguments("--disable-notifications"); // Desativa notificações do navegador
            options.addArguments("--incognito"); // Abre o navegador no modo anônimo
            options.addArguments("--disable-save-password-bubble"); // Impede o navegador de exibir o pop-up para salvar senhas

            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false); // Desativa o serviço de gerenciamento de credenciais do Chrome
            prefs.put("profile.password_manager_enabled", false); // Desativa o gerenciador de senhas do perfil do navegador

            options.setExperimentalOption("prefs", prefs); // Aplica as preferências configuradas acima ao navegador
            options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation", "disable-popup-blocking"));
            // Remove mensagens e comportamentos relacionados à automação (como "Chrome está sendo controlado por software de automação")
            // e impede o bloqueio de pop-ups durante os testes


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