package stellarBurgerTest;

import driver.WebDriverCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import stellarBurger.RegistrationPage;
import utils.generators.UserGenerator;
import utils.generators.model.User;

public class RegistrationWithInvalidPasswordTest {

  private WebDriver driver;
  private RegistrationPage registrationPage;
  private String accessToken;
  private User testUser;

  @Before
  public void startUp() {
    driver = new WebDriverCreator().setup();
    registrationPage = new RegistrationPage(driver);
    registrationPage.verifyPageEndpoint();
    testUser = UserGenerator.randomUser();
  }

  @Test
  public void failRegistrationWith() {
    testUser.setPassword("1234");
    registrationPage.fillRegisterData(testUser);
    registrationPage.clickRegisterButton();
    registrationPage.isValidationMessageVisible();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
