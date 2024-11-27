package stellarBurgerTest;

import utils.generators.UserGenerator;
import driver.WebDriverCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import stellarBurger.RegistrationPage;
import utils.generators.model.User;

public class RegistrationTest {

  private WebDriver driver;
  private RegistrationPage registrationPage;
  private User testUser;

  @Before
  public void startUp() {
    driver = new WebDriverCreator().setup();
    registrationPage = new RegistrationPage(driver);
    registrationPage.verifyPageEndpoint();
    testUser = UserGenerator.randomUser();
  }

  @Test
  public void successfulRegistration() {
    registrationPage.fillRegisterData(testUser);
    registrationPage.clickRegisterButton();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
