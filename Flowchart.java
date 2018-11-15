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
public class Flowchart 
{
    public ArrayList<Event> eventList;
    private final ArrayList<Event> startNodes;//nodes with no subscribers
    private final String flowchartNum;
    public ArrayList<ArrayList<Boolean>> dependancies= new ArrayList();//adjacency matrix
    
    public Flowchart(String num)
    {
        flowchartNum = num; 
        eventList = new ArrayList();
        startNodes = new ArrayList();
    }

    public String getFlowchartNum() {
        return flowchartNum;
    }
    
    public void addEvent(Event e)
    {
        eventList.add(e);
        if(e.getSubscribe().isEmpty())
        {
            startNodes.add(e);
        }
    }
    
    public void createDependencies()
    {
        for(Event e: eventList)
        {
            ArrayList<Boolean> temp = new ArrayList();
            for(int i = 0; i < eventList.size(); ++i)
            {
                    try
                    {
                        if(e.hasSubscriber(eventList.get(i)))
                        {
                         temp.add(true);
                        }
                        else
                        {
                            temp.add(false);
                        }
                    }
                    catch(NullPointerException ex)
                    {
                        if(i == 0)
                        {
                            startNodes.add(e);
                        }
                        temp.add(false);
                    }
                
            }
            dependancies.add(temp);
        }
    }
    
    //this method was used for debugging purposes for the adjacency matrix
    public void printDependancies()
    {
        for(ArrayList<Boolean> al: dependancies)
        {
            for(Boolean b: al)
            {
                if(b)
                {
                    System.out.print(1);
                }
                else
                {
                    System.out.print(0);
                }
            }
            System.out.print("\n");
        }
    }

    /*
    This method contains the logic 
    */
    @Override
    public String toString() {
        String temp = flowchartNum + ":\n";
        
        for(Event e: startNodes)
        {
            temp += e.getPublish();
            int current = eventList.indexOf(e);
            for(int i = 0; i < eventList.size(); ++i)
            {
                if(dependancies.get(i).get(current))
                {
                    temp += "->" + eventList.get(i).toString();
                    current = i;
                    i = 0;
                }
            }
            temp += "\n";
        }
        
        return temp; //To change body of generated methods, choose Tools | Templates.
    }
}
