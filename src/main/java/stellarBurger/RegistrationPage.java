package stellarBurger;

import config.StellarBurgerConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.generators.model.User;

public class RegistrationPage implements BasePage {

  private WebDriver driver;
  private By nameInput = By.xpath("//label[text()='Имя']/following-sibling::input");
  private By emailInput = By.xpath("//label[text()='Email']/following-sibling::input");
  private By passwordInput = By.xpath("//input[@type='password']");
  private By registerButton = By.xpath("//button[text()='Зарегистрироваться']");
  private By loginButton = By.xpath("//a[@href='/login']");
  private By incorrectPassword = By.xpath("//p[text()='Некорректный пароль']");

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

  @Override
  public void openPage() {
    BasePage.super.openPage();
  }

  @Step("Enter users data: Name, Email, Password ")
  public void fillRegisterData(User user) {
    driver.findElement(nameInput).sendKeys(user.getName());
    driver.findElement(emailInput).sendKeys(user.getEmail());
    driver.findElement(passwordInput).sendKeys(user.getPassword());
  }

  @Step("Click register button")
  public void clickRegisterButton() {
    driver.findElement(registerButton).click();
  }

  @Step("Click Login Button ")
  public void clickLoginButton() {
    driver.findElement(loginButton).click();
  }

  @Step("Verify visibility of Некоректный пароль message")
  public boolean isValidationMessageVisible() {
    return isElementVisible(incorrectPassword);
  }
}
