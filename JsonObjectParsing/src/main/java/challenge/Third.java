package challenge;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Scanner;

public class Third {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter JSON String/Object e.g. {\"a\":{\"b\":{\"c\":\"d\"}}}: ");
        String jsonString = in.nextLine();
        System.out.println("Enter Key/s separated by '/' e.g. a/b/c :");
        String jsonKey = in.nextLine();
        JSONParser parser = new JSONParser();
        JSONObject json = new JSONObject();
        try {
            json = (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            System.out.println("Error: Invalid JSON String/Object!");
        }

        String[] keyArray = jsonKey.split("/");
        JSONObject tempJson = json;
        for(int i = 0; i<keyArray.length;i++){
            String key = keyArray[i];
            if(tempJson.containsKey(key)){
                if(i < keyArray.length - 1) {
                    tempJson = (JSONObject) tempJson.get(key);
                }else{
                    System.out.println("Data Value = " + tempJson.get(key));
                }
            }
            else{
                System.out.println("Key Sequence not found.");
                break;
            }
        }
    }
}
