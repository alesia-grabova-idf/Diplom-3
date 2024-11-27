package stellarBurger;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PrivateAreaPage {

  private WebDriver driver;
  private By exitButton = By.xpath("//button[text()='Выход']");
  @Step("Click exit button in Private Area")
  public void clickExitButton() {
    driver.findElement(exitButton).click();
  }
}
