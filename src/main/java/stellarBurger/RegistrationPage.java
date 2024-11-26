package stellarBurger;

import config.StellarBurgerConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage implements BasePage {

  private WebDriver driver;
  private By nameInput = By.xpath("//label[text()='Имя']/following-sibling::input");
  private By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
  private By passwordInput = By.xpath("//input[@type='password']");
  private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
  private By loginButton = By.xpath("//a[@href='/login']");

  public RegistrationPage(WebDriver driver) {
    this.driver = driver;
  }

  @Override
  public String getPageUrl() {
    return StellarBurgerConfig.REGISTER_USER;
  }
  @Override
  public WebDriver getDriver() {
    return driver;
  }

  public void fillRegisterData(String name, String email, String password) {
    driver.findElement(nameInput).sendKeys(name);
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(passwordInput).sendKeys(password);
  }

  public void clickRegisterButton() {
    driver.findElement(registerButton).click();
  }

  public void clickLoginButton() {
    driver.findElement(loginButton).click();
  }

  @Override
  public void verifyPageEndpoint() {
    BasePage.super.verifyPageEndpoint();
  }
}
