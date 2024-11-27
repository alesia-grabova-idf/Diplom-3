package stellarBurger;

import config.StellarBurgerConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface BasePage {
  String getPageUrl();
  WebDriver getDriver();

  default void verifyPageEndpoint() {
    String fullUrl = StellarBurgerConfig.BASE_URL + getPageUrl();
    getDriver().get(fullUrl);
  }

  default boolean isElementVisible(By locator) {
    try {
      WebElement element = getDriver().findElement(locator);
      return element.isDisplayed();
    } catch (Exception e) {
      return false;
    }
  }
}
