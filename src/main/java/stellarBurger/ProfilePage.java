package stellarBurger;

import config.StellarBurgerConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage implements BasePage {

  private WebDriver driver;
  private By exitButton = By.xpath("//button[text()='Выход']");

  public ProfilePage(WebDriver driver) {
    this.driver = driver;
  }

  @Override
  public String getPageUrl() {
    return StellarBurgerConfig.PROFILE;
  }
  @Override
  public WebDriver getDriver() {
    return driver;
  }

  @Step("Click exit button in Private Area")
  public void clickExitButton() {
    driver.findElement(exitButton).click();
  }
}
