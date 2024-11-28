package stellarBurgerTest;

import static org.junit.Assert.assertEquals;

import stellarBurger.LoginPage;
import utils.generators.UserGenerator;
import driver.WebDriverCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import stellarBurger.RegistrationPage;
import utils.generators.model.User;

public class SuccessfulRegistrationTest {

  private WebDriver driver;
  private RegistrationPage registrationPage;
  private LoginPage loginPage;
  private User testUser;

  @Before
  public void startUp() {
    driver = new WebDriverCreator().setup();
    registrationPage = new RegistrationPage(driver);
    registrationPage.openPage();
    testUser = UserGenerator.randomUser();
    loginPage = new LoginPage(driver);
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void successfulRegistration() throws Exception {
    registrationPage.fillRegisterData(testUser);
    registrationPage.clickRegisterButton();
    Thread.sleep(1000);
    assertEquals("Redirect to incorrect page URL", loginPage.getExpectedUrl(), driver.getCurrentUrl());
  }
}
