package stellarBurger;

import config.StellarBurgerConfig;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage implements BasePage {

  private WebDriver driver;
  private By enterButton = By.xpath("//button[text()='Войти в аккаунт']");
  private By buns = By.xpath("//span[text()=\"Булки\"]");
  private By sauces = By.xpath("//span[text()=\"Соусы\"]");
  private By fillings = By.xpath("//div//span[text()=\"Начинки\"]\n");
  private By bunFluorescented = By.xpath("//a[@href='/ingredient/61c0c5a71d1f82001bdaaa6c']");
  private By bunKratorna = By.xpath("//a[@href='/ingredient/61c0c5a71d1f82001bdaaa6c']");
  private By sauceTraditionalGalactic = By.xpath("//a[@href='/ingredient/61c0c5a71d1f82001bdaaa74']");
  private By sauceAntarianFlat = By.xpath("//a[@href='/ingredient/61c0c5a71d1f82001bdaaa75']");
  private By sauceSpace = By.xpath("//a[@href='/ingredient/61c0c5a71d1f82001bdaaa73']");
  private By fillingProtostomiaMeat = By.xpath("//a[@href='/ingredient/61c0c5a71d1f82001bdaaa6f']");
  private By fillingBeefMeteorite = By.xpath("//a[@href='/ingredient/61c0c5a71d1f82001bdaaa70']");
  private By fillingTetraodontimformFillet = By.xpath("//a[@href='/ingredient/61c0c5a71d1f82001bdaaa6e']");
  private By fillingBioCutlet = By.xpath("//a[@href='/ingredient/61c0c5a71d1f82001bdaaa71']");

  @Override
  public String getPageUrl() {
    return StellarBurgerConfig.BASE_URL;
  }
  @Override
  public WebDriver getDriver() {
    return driver;
  }

  @Step("Click on buns in Menu block")
  public void clickBuns() {
    driver.findElement(buns).click();
  }

  @Step("Click on sauces in Menu block")
  public void clickSauces() {
    driver.findElement(sauces).click();
  }
  @Step("Click on fillings in Menu block")
  public void clickFillings() {
    driver.findElement(fillings).click();
  }
  @Step("Click Enter to Private Area on Menu Page")
  public void clickEntertoAccount() {
    driver.findElement(enterButton).click();
  }
  @Step("Verify visibility of Флюоресцентная булка in Buns menu")
  public boolean isBunFlurVisible() {
    return isElementVisible(bunFluorescented);
  }
  @Step("Verify visibility of Краторная булка in Buns menu")
  public boolean isBunKratorVisible() {
    return isElementVisible(bunKratorna);
  }
  @Step("Verify visibility of Соус традиционный галактический in sauces menu")
  public boolean isSauceTraditionalVisible() {
    return isElementVisible(sauceTraditionalGalactic);
  }
  @Step("Verify visibility of Соус с шипами Антарианского плоскоходца in sauces menu")
  public boolean isSauceAntarVisible() {
    return isElementVisible(sauceAntarianFlat);
  }
  @Step("Verify visibility of Соус фирменный Space in sauces menu")
  public boolean isSauceSpaceVisible() {
    return isElementVisible(sauceSpace);
  }
  @Step("Verify visibility of Мясо бессмертных моллюсков Protostomia in fillings menu")
  public boolean isFillingMeatProtVisible() {
    return isElementVisible(fillingProtostomiaMeat);
  }
  @Step("Verify visibility of Говяжий метеорит in fillings menu")
  public boolean isFillingBeefVisible() {
    return isElementVisible(fillingBeefMeteorite);
  }
  @Step("Verify visibility of Филе Люминесцентного тетраодонтимформа in fillings menu")
  public boolean isFillingFilletVisible() {
    return isElementVisible(fillingTetraodontimformFillet);
  }
  @Step("Verify visibility of Биокотлета из марсианской Магнолии in fillings menu")
  public boolean isFillingBioVisible() {
    return isElementVisible(fillingBioCutlet);
  }

}
