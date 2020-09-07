package mapping;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Set;

import static org.junit.Assert.fail;

public class Mapper {

    private static final String BASE_PATH = "mapJSON" + "/";
    private static final String BASE_EXTENSION = ".json";

    /*
     *
     * Json parse ve json'dan veri okutup gelen verileri işlettiğimiz yer
     *
     *
     *
     * */
    private static JsonObject readJSON(MapMethodType eventActivity, String elementFound) {
        Gson gson = new Gson();
        JsonElement jsonObject;
        FileReader reader = null;
        JsonObject jsonElement;
        JsonObject foundElement;
        foundElement = null;
        try {
            reader = new FileReader(BASE_PATH + eventActivity.getValue() + BASE_EXTENSION);
            jsonObject = gson.fromJson(reader, JsonElement.class);
            jsonElement = jsonObject.getAsJsonObject();
            foundElement = jsonElement.get(elementFound).getAsJsonObject();
        } catch (FileNotFoundException e) {
            fail(e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }
        return foundElement;
    }

    public static By foundActivity(MapMethodType eventActivity, String elementFound) {
        Set<Entry<String, JsonElement>> entries = null;
        try {
            entries = readJSON(eventActivity, elementFound).entrySet();
        } catch (NullPointerException e) {
            fail(elementFound + "is not found in JSON file");
        }
        By by = null;
        for (Entry<String, JsonElement> entry : entries) {
            by = generateByElement(entry.getKey(), entry.getValue().getAsString());
        }
        return by;
    }

    static By generateByElement(String byType, String byValue) {
        By byElement = null;
        if (byType.contains(MapValue.ID.getText())) {
            byElement = By.id(byValue);

        } else if (byType.contains(MapValue.CSSSELECTOR.getText())) {
            byElement = By.cssSelector(byValue);
        } else {
            fail("No such selector.");
        }
        return byElement;
    }


}