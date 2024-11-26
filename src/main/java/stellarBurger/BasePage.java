package stellarBurger;

import config.StellarBurgerConfig;
import org.openqa.selenium.WebDriver;

public interface BasePage {
  String getPageUrl();
  WebDriver getDriver();

  default void verifyPageEndpoint() {
    String fullUrl = StellarBurgerConfig.BASE_URL + getPageUrl();
    getDriver().get(fullUrl);
  }
}
