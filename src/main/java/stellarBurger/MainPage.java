package stellarBurger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
  private WebDriver driver;
  private By enterButton = By.xpath("//button[text()='Войти в аккаунт']");
  private By buns = By.xpath("//span[text()=\"Булки\"]\n");
  private By sauces = By.xpath("//span[text()=\"Соусы\"]\n");
  private By fillings = By.xpath("//div//span[text()=\"Начинки\"]\n");

  public void clickBuns(){
    driver.findElement(buns).click();
  }

  public void clickSauces(){
    driver.findElement(sauces).click();
  }

  public void clickFillings(){
    driver.findElement(fillings).click();
  }

  public void clickEnter(){
    driver.findElement(enterButton).click();
  }


}
