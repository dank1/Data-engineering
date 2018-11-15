/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenrick_d_program2;

import java.util.ArrayList;

/**
 *
 * @author daniel.kenrick
 * this class is for the object representation of the dsl files to be sorted
 */
public class Event {
    
    private String dslName;
    private String category;
    private String subCategory;
    private ArrayList<String> flowNames;
    private String publish;
    private ArrayList<String> subscribe;
    
    public Event()
    {
        flowNames = new ArrayList();
        subscribe = new ArrayList();
    }
    /*
    public Event(String name)
    {
        publish = name;
        flowNames = new ArrayList();
        subscribe = new ArrayList();
    }*/
    
    /*getters and setters*/
    public String getCategory() {
        return category;
    }

    public String getDslName() {
        return dslName;
    }

    public ArrayList<String> getFlowNames() {
        return flowNames;
    }

    public String getPublish() {
        return publish;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public ArrayList<String> getSubscribe() {
        return subscribe;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDslName(String dslName) {
        this.dslName = dslName;
    }

    public void setFlowNames(ArrayList<String> flowNames) {
        this.flowNames = flowNames;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public void setSubscribe(ArrayList<String> subscribe) {
        this.subscribe = subscribe;
    }
    
    
    public boolean hasFlowName(String flowName)
    {
        for(String f: flowNames)
        {
            if(f.equals(flowName))
            {
                return true;
            }
        }
        return false;
    }
    
    
    public void addFlowName(String... flowname)
    {
        for(String i: flowname)
        {
            flowNames.add(i);
        }
    }
    
    
    public void addSubscriber(String... s)
    {
        for(String e: s)
        {
            subscribe.add(e);
        }
    }
    
    public boolean hasSubscriber(Event e)
    {
        for(String i: subscribe)
        {
            if(e.getPublish().equals(i))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean hasSubscribers()
    {
        if(subscribe.isEmpty())
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return publish; //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean equals(Object obj) {
        Event other = (Event) obj;
        return other.getPublish().equals(this.publish); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return publish.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }
}
