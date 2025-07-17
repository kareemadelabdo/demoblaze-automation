package Utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;

public class JsonUtil {
    public static String[] getCredentials(String path) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(new FileReader(path));

            String username = (String) json.get("username");
            String password = (String) json.get("password");

            return new String[]{username, password};
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
