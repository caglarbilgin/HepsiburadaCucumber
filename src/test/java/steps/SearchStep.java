package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import util.utilTest;

public class SearchStep {

    @And("^Search product$")
    public void hoverToElement(String hoverLoginElement) {
        utilTest.hoverElement(hoverLoginElement);
    }


    @Then("^Write to file \"([^\"]*)\"$")
    public void writeToFile(String key) {
        utilTest.writeFile(key,"log/searchLog.txt");
    }
}
