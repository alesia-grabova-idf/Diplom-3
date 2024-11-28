package stellarBurger;

import config.StellarBurgerConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage implements BasePage {

  private WebDriver driver;
  private By emailInput = By.xpath("//input[@name='name']");
  private By passwordInput = By.xpath("//input[@name='Пароль']");
  private By enterButton = By.xpath("//button[text()='Войти']");
  private By registerButton = By.xpath("//a[@href='/register']");
  private By recoveryPasswordButton = By.xpath("//a[@href='/forgot-password']");

  public LoginPage(WebDriver driver) {
    this.driver = driver;
  }

  @Override
  public String getPageUrl() {
    return StellarBurgerConfig.LOGIN_USER;
  }

  @Override
  public WebDriver getDriver() {
    return driver;
  }

  @Step("Fill login data en login")
  public void login(String email, String password) {
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(passwordInput).sendKeys(password);
    driver.findElement(enterButton).click();
  }
}
