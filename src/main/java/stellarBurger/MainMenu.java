package stellarBurger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainMenu {
  private WebDriver driver;
  private By constructor = By.xpath("//a[p[text()='Конструктор']]");
  private By stellarBurgLogo = By.xpath("//*[@id=\"root\"]/div/header/nav/div");
  private By privateAreaButton = By.xpath("//a[@href=\"/account\"]");
  private By orderLine = By.xpath("//a[@href=\"/feed\"]");

  public void clickConstructorButton(){
    driver.findElement(constructor).click();
  }

  public void clickStellarBurgLogo(){
    driver.findElement(stellarBurgLogo).click();
  }

  public void clickPrivateAreaButton(){
    driver.findElement(privateAreaButton).click();
  }


}
