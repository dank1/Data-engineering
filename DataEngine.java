/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenrick_d_program2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class DataEngine {
    
    public String fileName;

    public DataEngine() {
    }
    
    public Event readFile(String fileName)
    {
        this.fileName = fileName;
        Event data = new Event();
        
        JSONParser parser = new JSONParser();
        try {
            Object obj1 = parser.parse(new FileReader(
                    "C:\\Users\\daniel.kenrick\\Documents\\NetBeansProjects\\" + this.fileName));
 
            JSONObject jsonObject1 = (JSONObject) obj1;
 
            String name1 = (String) jsonObject1.get("dslName");
            JSONArray flowName1 = (JSONArray) jsonObject1.get("flowNames");
            JSONObject event = (JSONObject) jsonObject1.get("event");
            JSONArray subscriber = (JSONArray) event.get("subscribe");
            JSONArray publish = (JSONArray) event.get("publish");
            
            
            data.setDslName(name1);
            data.setCategory(flowName1.toString());
            
            Iterator<String> iterator = flowName1.iterator();
            while (iterator.hasNext()) {
                data.addFlowName(iterator.next());
            }
            try
            {
            for(int i = 0; i < subscriber.size(); ++i)
            {
                data.addSubscriber((String)subscriber.get(i));
            }
            Iterator<String> iterator2 = subscriber.iterator();
            while (iterator.hasNext()) {
                data.addSubscriber(iterator2.next());
            }
            }
            catch(NullPointerException e)
            {
                
            }
            
            data.setPublish((String)publish.get(0));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        
        return data;
    }
}