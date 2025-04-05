package Utils;

import Runners.RunnerBase;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    public static WebDriver getDriver() {
        return RunnerBase.getDriver();
    }

    // Metodo de espera para tornar o elemento visível
    public static void waitForElementToBeVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)); // Usando Duration
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Metodo de espera para tornar o elemento clicável
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)); // Usando Duration
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToBottom(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public static void switchToWindow(@NotNull WebDriver driver, String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public static String getCurrentWindowHandle(@NotNull WebDriver driver) {
        return driver.getWindowHandle();
    }
}
