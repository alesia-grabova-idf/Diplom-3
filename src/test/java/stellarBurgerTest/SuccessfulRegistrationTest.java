package stellarBurgerTest;

import static org.junit.Assert.assertEquals;

import stellarBurger.LoginPage;
import utils.generators.UserGenerator;
import driver.WebDriverCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import stellarBurger.RegistrationPage;
import utils.generators.model.User;

public class SuccessfulRegistrationTest {

  private WebDriver driver;
  private WebDriverWait wait;
  private RegistrationPage registrationPage;
  private LoginPage loginPage;
  private User testUser;

  @Before
  public void startUp() {
    driver = new WebDriverCreator().setup();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
  public void successfulRegistration() {
    registrationPage.fillRegisterData(testUser);
    registrationPage.clickRegisterButton();
    wait.until(ExpectedConditions.urlToBe(loginPage.getExpectedUrl()));
    assertEquals("Redirect to incorrect page URL", loginPage.getExpectedUrl(), driver.getCurrentUrl());
  }
}
