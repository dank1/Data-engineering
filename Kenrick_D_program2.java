/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kenrick_d_program2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

/**
 *
 * @author daniel.kenrick
 */
public class Kenrick_D_program2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Event> events = new ArrayList<>();
        ArrayList<Flowchart> flowcharts = new ArrayList<>();
        int numFlowCharts = 1;
        
        Event e1 = new Event("e1");
        e1.addFlowName(1, 2);
        
        Event e2 = new Event("e2");
        e2.addFlowName(1, 2);
        e2.addSubscriber(e1);
        
        Event e3 = new Event("e3");
        e3.addFlowName(2);
        
        Event e4 = new Event("e4");
        e4.addFlowName(1, 2);
        e4.addSubscriber(e2);
        
        Event e5 = new Event("e5");
        e5.addFlowName(2);
        e5.addSubscriber(e3);
        
        Event e6 = new Event("e6");
        e6.addFlowName(2);
        e6.addSubscriber(e4, e5);
        
        Event e7 = new Event("e7");
        e7.addFlowName(1);
        e7.addSubscriber(e4);
        
        Event e8 = new Event("e8");
        e8.addFlowName(2);
        e8.addSubscriber(e6);
        
        events.add(e1);
        events.add(e2);
        events.add(e3);
        events.add(e4);
        events.add(e5);
        events.add(e6);
        events.add(e7);
        events.add(e8);
        
        for(Event e: events)
        {
            for(int i: e.getFlowNames())
            {
                if(i > numFlowCharts)
                {
                    numFlowCharts = i;
                }
            }
        }
        
        for(int i = 0; i < numFlowCharts; ++i)
        {
            flowcharts.add(new Flowchart(i + 1));
        }
        
        for(Flowchart f: flowcharts)
        {
            for(Event e: events)
            {
                if(e.hasFlowName(f.getFlowchartNum()))
                {
                    f.events.add(e);
                }
            }
        }
        
        for(Flowchart f: flowcharts)
        {
            f.addNodes();
            System.out.print(f.graph);
        }
    }
}
