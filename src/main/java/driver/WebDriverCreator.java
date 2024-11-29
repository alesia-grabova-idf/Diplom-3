package driver;

import static config.BrowserConfig.chromiumDriverVersion;
import static config.BrowserConfig.yandexBrowserPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverCreator {

  public WebDriver setup() {
    String browser = System.getProperty("browser", "chrome").toLowerCase();

    if (browser.equals("chrome")) {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      return new ChromeDriver(options);
    } else if (browser.equals("yandex")) {
      // Используем chromiumdriver для Yandex
      WebDriverManager.chromiumdriver().driverVersion(chromiumDriverVersion).setup();
      ChromeOptions options = new ChromeOptions();
      // Указываем путь до Yandex Browser
      options.setBinary(yandexBrowserPath);
      options.addArguments("--no-sandbox");
      return new ChromeDriver(options);
    } else {
      throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
  }
}
