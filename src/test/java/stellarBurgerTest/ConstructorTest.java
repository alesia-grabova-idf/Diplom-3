package stellarBurgerTest;

import org.junit.Assert;
import stellarBurger.MainPage;
import driver.WebDriverCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ConstructorTest {

  MainPage mainPage;
  private WebDriver driver;

  @Before
  public void startUp() {
    driver = new WebDriverCreator().setup();
    mainPage = new MainPage(driver);
    mainPage.openPage();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void constructorNavigationTest() {
    //проверяем начинки
    mainPage.clickFillings();
    mainPage.isFillingBeefVisible();
    mainPage.isFillingFilletVisible();
    mainPage.isFillingBioVisible();
    Assert.assertTrue("Неудачный переход на раздел Начинки", mainPage.isFillingMeatProtVisible());
    //проверяем булки
    mainPage.clickBuns();
    mainPage.isBunFlurVisible();
    mainPage.isBunKratorVisible();
    Assert.assertTrue("Неудачный переход на раздел Булки", mainPage.isBunKratorVisible());
    //проверяем соусы
    mainPage.clickSauces();
    mainPage.isSauceAntarVisible();
    mainPage.isSauceSpaceVisible();
    Assert.assertTrue("Неудачный переход на раздел Соусы", mainPage.isSauceTraditionalVisible());
  }
}
