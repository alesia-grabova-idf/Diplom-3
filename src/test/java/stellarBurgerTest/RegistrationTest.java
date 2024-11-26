package stellarBurgerTest;

import driver.WebDriverCreator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import stellarBurger.RegistrationPage;

public class RegistrationTest {

  private WebDriver driver;
  private RegistrationPage registrationPage;

  @Before
  public void startUp() {
    driver = new WebDriverCreator().setup();
    registrationPage = new RegistrationPage(driver);
    registrationPage.verifyPageEndpoint();
  }

  @Test
  public void successfulRegistration(){
    registrationPage.fillRegisterData("Test User111", "testuser111@example.com", "password123");
    registrationPage.clickRegisterButton();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}


