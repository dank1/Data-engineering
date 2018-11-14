/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenrick_d_program2;

import java.io.FileReader;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
 
public class DataEngine {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        JSONParser parser = new JSONParser();
        try {
            Object obj1 = parser.parse(new FileReader(
                    "C:\\Users\\patri\\Desktop\\IPG Week 4\\DSL\\F1.json"));
 
            JSONObject jsonObject1 = (JSONObject) obj1;
 
            String name1 = (String) jsonObject1.get("dslName");
            JSONArray flowName1 = (JSONArray) jsonObject1.get("flowNames");
            JSONObject event = (JSONObject) jsonObject1.get("event");
            JSONArray subscriber = (JSONArray) event.get("subscribe");
            JSONArray publish = (JSONArray) event.get("publish");
 
            System.out.println("Name: " + name1);
            System.out.println("\nFlow Name:");
            System.out.println("\nSubscriber "+subscriber);
            System.out.println("\nPublish "+publish);
            
            Iterator<String> iterator = flowName1.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}