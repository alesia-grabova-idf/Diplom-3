package stellarBurger;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderMenu {

  private WebDriver driver;
  private By constructor = By.xpath("//a[p[text()='Конструктор']]");
  private By stellarBurgLogo = By.xpath("//*[@id=\"root\"]/div/header/nav/div");
  private By privateAreaButton = By.xpath("//a[@href=\"/account\"]");
  private By orderLine = By.xpath("//a[@href=\"/feed\"]");

  public HeaderMenu(WebDriver driver) {
    this.driver = driver;
  }

  @Step("Click Constructor button")
  public void clickConstructorButton() {
    driver.findElement(constructor).click();
  }

  @Step("Click Stellar Burger Logo")
  public void clickStellarBurgLogo() {
    driver.findElement(stellarBurgLogo).click();
  }

  @Step("Click Private Area Button")
  public void clickPrivateAreaButton() {
    driver.findElement(privateAreaButton).click();
  }
}
