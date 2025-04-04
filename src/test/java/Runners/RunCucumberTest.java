package Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * Classe responsável por executar os testes do Cucumber.
 * Configura e finaliza o WebDriver antes e depois da execução dos testes.
 */
@RunWith(Cucumber.class) // Define que esta classe será executada com o runner do Cucumber
@CucumberOptions(
        plugin = {"pretty"}, // Formatação legível para a saída dos testes
        features = {"src/test/resources/Features"}, // Caminho onde os arquivos .feature estão localizados
        tags = "@testesWeb", // Define quais cenários serão executados com base na tag
        glue = {"Steps"} // Define o pacote onde os Steps Definitions estão localizados
)
public class RunCucumberTest {

    /**
     * Metodo executado antes de todos os testes para inicializar o WebDriver.
     */
    @BeforeClass
    public static void setup() {
        RunnerBase.getDriver(); // Inicializa o WebDriver antes dos testes
    }

    /**
     * Metodo executado após todos os testes para encerrar o WebDriver.
     */
    @AfterClass
    public static void tearDown() {
        RunnerBase.quitDriver(); // Encerra o WebDriver após os testes
    }
}
