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
 */
public class Event implements Comparable{
    
    private String dslName;
    private String category;
    private String subCategory;
    private ArrayList<Integer> flowNames;
    private String publish;
    private ArrayList<Event> subscribe;
    
    public Event()
    {
    }
    
    public Event(String name)
    {
        publish = name;
        flowNames = new ArrayList();
        subscribe = new ArrayList();
    }
    
    public Event(String dslName, String category, String subCategory, ArrayList<Integer> flowNames, String publish, ArrayList<Event> subscribe) {
        this.dslName = dslName;
        this.category = category;
        this.subCategory = subCategory;
        this.flowNames = flowNames;
        this.publish = publish;
        this.subscribe = subscribe;
    }

    public String getCategory() {
        return category;
    }

    public String getDslName() {
        return dslName;
    }

    public ArrayList<Integer> getFlowNames() {
        return flowNames;
    }

    public String getPublish() {
        return publish;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public ArrayList<Event> getSubscribe() {
        return subscribe;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDslName(String dslName) {
        this.dslName = dslName;
    }

    public void setFlowNames(ArrayList<Integer> flowNames) {
        this.flowNames = flowNames;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public void setSubscribe(ArrayList<Event> subscribe) {
        this.subscribe = subscribe;
    }
    
    public boolean hasFlowName(int flowName)
    {
        for(int f: flowNames)
        {
            if(f == flowName)
            {
                return true;
            }
        }
        return false;
    }
    
    public void addFlowName(int... flowname)
    {
        for(int i: flowname)
        {
            flowNames.add(i);
        }
    }
    
    public void addSubscriber(Event... s)
    {
        for(Event e: s)
        {
            subscribe.add(e);
        }
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

    @Override
    public int compareTo(Object o) {
        return 0; //To change body of generated methods, choose Tools | Templates.
    }
}
