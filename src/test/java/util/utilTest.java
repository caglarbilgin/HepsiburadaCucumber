package util;

import base.BaseTest;
import mapping.MapMethodType;
import mapping.Mapper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileWriter;
import java.util.List;

public class utilTest extends BaseTest {
    public static WebDriverWait wait = new WebDriverWait(driver, 15);

    public static void clickElement(String button) {
        wait.until(ExpectedConditions.elementToBeClickable(Mapper.foundActivity(MapMethodType.CLICK_ELEMENT, button))).click();
    }

    public static void sendKeys(String key, String value) {
        wait.until(ExpectedConditions.elementToBeClickable(Mapper.foundActivity(MapMethodType.INPUT_ELEMENT, key))).sendKeys(value);
    }

    public static void hoverElement(String value) {
        Actions actions = new Actions(driver);
        WebElement hover = wait.until(ExpectedConditions.elementToBeClickable(Mapper.foundActivity(MapMethodType.HOVER_ELEMENT, value)));
        actions.moveToElement(hover);
        actions.click().build().perform();
    }

    public static void writeFile(String key, String logFilePath) {
        try {
            FileWriter myWriter = new FileWriter(logFilePath);
            List<WebElement> logs = driver.findElements(Mapper.foundActivity(MapMethodType.CHECK_ELEMENT, key));
            Assert.assertNotEquals(logs.size(),0);
            myWriter.write("---LOGS---" + "\n");
            for (WebElement element : logs) {
                myWriter.write(element.getText() + "\n");
            }
            myWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
