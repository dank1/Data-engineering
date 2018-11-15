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
public class Kenrick_D_program2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Flowchart> flowcharts = new ArrayList<>();
        ArrayList<Event> events2 = new ArrayList<>();
        int numFlowCharts = 2;
        
        Event e11 = new DataEngine().readFile("F1.json");
        Event e12 = new DataEngine().readFile("F2.json");
        Event e13 = new DataEngine().readFile("F3.json");
        Event e14 = new DataEngine().readFile("F4.json");
        Event e15 = new DataEngine().readFile("F5.json");
        Event e16 = new DataEngine().readFile("F6.json");
        Event e17 = new DataEngine().readFile("F7.json");
        Event e18 = new DataEngine().readFile("F8.json");
        events2.add(e11);
        events2.add(e12);
        events2.add(e13);
        events2.add(e14);
        events2.add(e15);
        events2.add(e16);
        events2.add(e17);
        events2.add(e18);
        /*
        flowcharts.add(new Flowchart("F1"));
        flowcharts.add(new Flowchart("F2"));*/
        
        for(Event e: events2)
        {
            for(String s: e.getFlowNames())
            {
                 boolean foundMatch = false;
                 for(Flowchart f: flowcharts)
                 {
                     if(f.getFlowchartNum().equals(s))
                     {
                         //f.addEvent(e);
                         foundMatch = true;
                         break;
                     }
                 }
                 if(!foundMatch)
                 {
                     flowcharts.add(new Flowchart(s));
                 }
            }
        }
        
        
        
        for(Flowchart f: flowcharts)
        {
            
            for(Event e: events2)
            {
                if(e.hasFlowName(f.getFlowchartNum()))
                {
                    f.addEvent(e);
                }
            }
            f.createDependencies();
            //f.printDependancies();
            System.out.println(f);
        }
        
        
        /*
        for(Flowchart f: flowcharts)
        {
            f.addNodes();
            System.out.print(f.graph);
        }*/
    }
}
