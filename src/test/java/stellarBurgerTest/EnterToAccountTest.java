package stellarBurgerTest;

import static org.junit.Assert.assertEquals;

import api.ClientUser;
import io.restassured.response.Response;
import stellarBurger.LoginPage;
import stellarBurger.HeaderMenu;
import stellarBurger.MainPage;
import stellarBurger.RecoveryPasswordPage;
import utils.generators.UserGenerator;
import driver.WebDriverCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import stellarBurger.RegistrationPage;
import utils.generators.model.User;

public class EnterToAccountTest {

  private WebDriver driver;
  private RegistrationPage registrationPage;
  private LoginPage loginPage;
  private RecoveryPasswordPage recoveryPasswordPage;
  private MainPage mainPage;
  private HeaderMenu headerMenu;
  private User testUser;
  private ClientUser clientUser;
  private String token;

  @Before
  public void startUp() {
    driver = new WebDriverCreator().setup();
    clientUser = new ClientUser();
    testUser = UserGenerator.randomUser();
    mainPage = new MainPage(driver);
    loginPage = new LoginPage(driver);
    headerMenu = new HeaderMenu(driver);
    registrationPage = new RegistrationPage(driver);
    recoveryPasswordPage = new RecoveryPasswordPage(driver);
    Response response = clientUser.registerUser(testUser);
    token = clientUser.extractToken(response);
  }

  @After
  public void tearDown() {
    clientUser.deleteUser(token);
    driver.quit();
  }

  @Test
  public void enterToAccountByEnterButtonOnMainPage() throws Exception {
//    mainPage = new MainPage(driver);
    mainPage.openPage();
    mainPage.clickEnterToAccount();
    assertEquals("Redirect to incorrect page URL", loginPage.getExpectedUrl(), driver.getCurrentUrl());
    loginPage.login(testUser.getEmail(), testUser.getPassword());
  }

  @Test
  public void enterToAccountButtonInHeaderMenuTest() throws Exception {
    mainPage.openPage();
    headerMenu.clickPrivateAreaButton();
    assertEquals("Redirect to incorrect page URL", loginPage.getExpectedUrl(), driver.getCurrentUrl());
    loginPage.login(testUser.getEmail(), testUser.getPassword());
    Thread.sleep(1000);
    assertEquals("Redirect to incorrect page URL", mainPage.getExpectedUrl(), driver.getCurrentUrl());
  }

  @Test
  public void enterToAccountInRegistrationPageTest() throws Exception {
    registrationPage.openPage();
    registrationPage.clickLoginButton();
    assertEquals("Redirect to incorrect page URL", loginPage.getExpectedUrl(), driver.getCurrentUrl());
    loginPage.login(testUser.getEmail(), testUser.getPassword());
    Thread.sleep(1000);
    assertEquals("Redirect to incorrect page URL", mainPage.getExpectedUrl(), driver.getCurrentUrl());
  }

  @Test
  public void enterToAccountInRecoveryPasswordPageTest() throws Exception {
    recoveryPasswordPage.openPage();
    recoveryPasswordPage.clickEnterButton();
    assertEquals("Redirect to incorrect page URL", loginPage.getExpectedUrl(), driver.getCurrentUrl());
    loginPage.login(testUser.getEmail(), testUser.getPassword());
    Thread.sleep(1000);
    assertEquals("Redirect to incorrect page URL", mainPage.getExpectedUrl(), driver.getCurrentUrl());
  }
}
