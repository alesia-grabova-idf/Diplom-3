package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;


public class WebDriverCreator {
  private WebDriver driver;

  public WebDriver setup() {
    String browser = System.getProperty("browser", "chrome").toLowerCase();

    if (browser.equals("chrome")) {
      WebDriverManager.chromedriver().setup();
      ChromeOptions options = new ChromeOptions();
      return new ChromeDriver(options);
    } else if (browser.equals("yandex")) {
      WebDriverManager.chromedriver().setup(); // Используем chromedriver для Yandex
      ChromeOptions options = new ChromeOptions();
      // Указываем путь до Yandex Browser, если требуется
      options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex"); // Замените на путь к бинарному файлу Yandex Browser
      return new ChromeDriver(options);
    } else {
      throw new IllegalArgumentException("Unsupported browser: " + browser);
    }
  }
}
