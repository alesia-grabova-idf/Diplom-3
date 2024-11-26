package stellarBurger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivateAreaPage {

  private WebDriver driver;
  private By exitButton = By.xpath("//button[text()='Выход']");

  public void clickExitButton() {
    driver.findElement(exitButton).click();
  }
}
