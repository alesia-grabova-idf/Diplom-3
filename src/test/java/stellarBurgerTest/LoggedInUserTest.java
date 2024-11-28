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
import utils.generators.model.User;

public class LoggedInUserTest {
  private WebDriver driver;
  private LoginPage loginPage;
  private MainPage mainPage;
  private HeaderMenu headerMenu;
  private ProfilePage profilePage;
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
    profilePage = new ProfilePage(driver);
    Response response = clientUser.registerUser(testUser);
    token = clientUser.extractToken(response);
  }

  @After
  public void tearDown() {
    clientUser.deleteUser(token);
    driver.quit();
  }

  @Test
  public void enterToProfileByHeaderMenu() throws Exception {
    loginPage.openPage();
    loginPage.login(testUser.getEmail(), testUser.getPassword());
    Thread.sleep(1000);
    assertEquals("Redirect to incorrect page URL", mainPage.getExpectedUrl(), driver.getCurrentUrl());
    headerMenu.clickPrivateAreaButton();
    Thread.sleep(1000);
    assertEquals("Redirect to incorrect page URL", profilePage.getExpectedUrl(), driver.getCurrentUrl());
  }
  @Test
  public void logoutInProfilePage() throws Exception {
    loginPage.openPage();
    loginPage.login(testUser.getEmail(), testUser.getPassword());
    Thread.sleep(1000);
    headerMenu.clickPrivateAreaButton();
    Thread.sleep(1000);
    assertEquals("Redirect to incorrect page URL", profilePage.getExpectedUrl(), driver.getCurrentUrl());
    profilePage.clickExitButton();
    Thread.sleep(1000);
    assertEquals("Redirect to incorrect page URL", loginPage.getExpectedUrl(), driver.getCurrentUrl());
  }


}
