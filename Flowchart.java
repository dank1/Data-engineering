/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenrick_d_program2;

import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * @author daniel.kenrick
 */
public class Flowchart 
{
    public Queue<Event> events;
    private int flowchartNum;
    public Graph graph;
    
    public Flowchart(int num)
    {
        flowchartNum = num; 
        events = new PriorityQueue<>();
        graph = new Graph();
    }

    public int getFlowchartNum() {
        return flowchartNum;
    }
    
    public void addNodes()
    {
        while(!events.isEmpty())
        {
            //System.out.println(events.size());//for debugging purposes
            
            Event temp = events.poll();
            boolean hasNodes = true;
            System.out.println(temp);
            if(temp.getSubscribe().isEmpty())
            {
                graph.addIfEmpty(temp);
            }
            else
            {
                for(Event s: temp.getSubscribe())
                {
                    if(!s.getFlowNames().contains(flowchartNum))
                    {
                        continue;
                    }
                
                    if(!graph.hasNode(s, graph.root))
                    {
                        
                        hasNodes = false;
                        events.add(temp);
                        //System.out.println("add");
                        break;
                    }
                }
            }
            if(hasNodes)
            {
                for(Event s: temp.getSubscribe())
                {
                    if(s.getFlowNames().contains(flowchartNum))
                    {
                        graph.addToRoot(temp, s);
                    }
                }
            }
        }
    }
}
