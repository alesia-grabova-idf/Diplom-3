package stellarBurger;

import config.StellarBurgerConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage implements BasePage{
  private WebDriver driver;
  private By emailInput = By.xpath("//input[@name='name']");
  private By recoveryButton = By.xpath("//button[text()='Восстановить']");
  private By enterButton = By.xpath("//a[@href='/login']");

  public RecoveryPasswordPage(WebDriver driver) {
    this.driver = driver;
  }

  @Override
  public WebDriver getDriver() {
    return driver;  // Возвращаем драйвер, который был передан через конструктор
  }

  @Override
  public String getPageUrl() {
    return StellarBurgerConfig.FORGOT_PASSWORD;
  }
  @Step("Click Enter Button")
  public void clickEnterButton(){
    driver.findElement(enterButton).click();
  }

}
