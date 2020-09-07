package steps;

import base.BaseTest;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.log4j.Logger;
import mapping.MapMethodType;
import mapping.Mapper;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.utilTest;


public class LoginStep extends BaseTest {
    protected static final Logger log = Logger.getLogger(LoginStep.class);


    @Given("^Go to homepage$")
    public void goToHomepage() {
        setUp();
    }

    @And("^Click \"([^\"]*)\" button$")
    public void clickButton(String button) {
        utilTest.clickElement(button);

    }

    @And("^Enter the \"([^\"]*)\" send key \"([^\"]*)\"$")
    public void enterTheSendKeyAndSendKey(String key, String value) {
        utilTest.sendKeys(key,value);
    }

    @And("^wait$")
    public void waitFunc() throws InterruptedException {
        Thread.sleep(5000);
    }

    @And("^Hover to Element \"([^\"]*)\"$")
    public void hoverToElement(String hoverLoginElement) {
        utilTest.hoverElement(hoverLoginElement);
    }

    @Then("^Check the \"([^\"]*)\" information is correct$")
    public void checkTheInformationIsCorrect(String login) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            String element = wait.until(ExpectedConditions.elementToBeClickable(Mapper.foundActivity(MapMethodType.CHECK_ELEMENT, login))).getText();
            Assert.assertEquals("Hesabım", element);
            log.info("Login successfully!!");
        }catch (Exception e){
            log.error("Login failed");
        }
    }
}
