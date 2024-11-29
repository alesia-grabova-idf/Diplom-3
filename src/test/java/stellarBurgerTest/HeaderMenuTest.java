package stellarBurgerTest;

import static org.junit.Assert.assertEquals;

import api.ClientUser;
import io.restassured.response.Response;
import stellarBurger.LoginPage;
import stellarBurger.HeaderMenu;
import stellarBurger.MainPage;
import stellarBurger.ProfilePage;
import utils.generators.UserGenerator;
import driver.WebDriverCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utils.generators.model.User;

public class HeaderMenuTest {

  private WebDriver driver;
  private LoginPage loginPage;
  private MainPage mainPage;
  private HeaderMenu headerMenu;
  private ProfilePage profilePage;
  private User testUser;
  private ClientUser clientUser;
  private String token;
  private WebDriverWait wait;

  @Before
  public void startUp() {
    driver = new WebDriverCreator().setup();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    clientUser = new ClientUser();
    mainPage = new MainPage(driver);
    loginPage = new LoginPage(driver);
    headerMenu = new HeaderMenu(driver);
    profilePage = new ProfilePage(driver);
    loginPage.openPage();
    testUser = UserGenerator.randomUser();
    Response response = clientUser.registerUser(testUser);
    token = clientUser.extractToken(response);
    loginPage.login(testUser.getEmail(), testUser.getPassword());
  }

  @After
  public void tearDown() {
    clientUser.deleteUser(token);
    driver.quit();
  }

  @Test
  public void headerMenuNavigationTest() {
    headerMenu.clickPrivateAreaButton();
    wait.until(ExpectedConditions.urlToBe(profilePage.getExpectedUrl()));
    assertEquals("Redirect to incorrect page URL", profilePage.getExpectedUrl(), driver.getCurrentUrl());
    headerMenu.clickConstructorButton();
    wait.until(ExpectedConditions.urlToBe(mainPage.getExpectedUrl()));
    assertEquals("Redirect to incorrect page URL", mainPage.getExpectedUrl(), driver.getCurrentUrl());
    headerMenu.clickPrivateAreaButton();
    wait.until(ExpectedConditions.urlToBe(profilePage.getExpectedUrl()));
    assertEquals("Redirect to incorrect page URL", profilePage.getExpectedUrl(), driver.getCurrentUrl());
    headerMenu.clickStellarBurgLogo();
    wait.until(ExpectedConditions.urlToBe(mainPage.getExpectedUrl()));
    assertEquals("Redirect to incorrect page URL", mainPage.getExpectedUrl(), driver.getCurrentUrl());
  }
}
