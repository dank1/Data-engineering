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
public class Graph
{
	public Node head;
        public String flowname;
        public Node tail;
        
	public Graph(String flowname)
	{
            head = new Node("head");
            tail = new Node("");
            this.flowname = flowname;
	}
	
	public class Node
	{
		Event data;
		public ArrayList<Node> children;
                public Node(String d)
                {
                    data = new Event(d);
                    children = new ArrayList();
                }
                
		public Node(Event data)
		{
			this.data = data;
			children = new ArrayList<>();
		}
		public void addChild(Node n)
		{
			children.add(n);
		}
		
		public Node removeChild(Event data)
		{
			for(Node n: children)
			{
				if(n.getData().equals(data))
				{
					children.remove(n);
					return n;
				}
			}
                        return null;
		}
		public Event getData()
		{
			return this.data;
		}
	}
        /*
        public void addIfEmpty(Event n)
        {
            this.root.addChild(new Node(n));
        }
        
        public boolean addToRoot(Event n, Event subscriber)
        {
            if(n.getSubscribe().isEmpty())
            {
                this.root.addChild(new Node(n));
                return true;
            }
            else
            {
                if(addNode(n, subscriber, this.root))
                {
                    return true;
                }
            }
            return false;
        }
	
        //returns false if add is not successful
	public boolean addNode(Event n, Event subscriber, Node root)
	{
            if(root.getData().equals(subscriber))
            {
                root.addChild(new Node(n));
                return true;
            }
            else
            {
            try{
            for(Node c: root.children)
            {
                if(addNode(n, subscriber, c))
                {
                    return true;
                }
            }
            }
            catch(NullPointerException e)
            {
                return false;
            }
            //if(n.getPublish().equals())
            /*
            if(root.getData().equals(subscriber))
            {
                root.addChild(new Node(n));
                return true;
            }
            System.out.print(root.getData());
            if(root.getData().toString().equals("e2"))
            {
                System.out.print(root.getData().toString());
            }
            for(Node c: root.children)
            {
                if(addNode(n, subscriber, c))
                {
                    return true;
                }
                /*
                for(Event s: n.getData().getSubscribe())
                {
                    if(s.equals(c.getData()))
                    {
                        root.addChild(n);
                        return true;
                    }
                }
                addNode(n, c);
            }
            return false;
	}
            return false;
        }
        
        public boolean hasNode(String data, Node root)
        {
            
            if(root.getData().equals(data))
            {
                return true;
            }
            else
            {
                try{
                    
                for(Node c: root.children)
                {
                    for(String s: data.getSubscribe())
                    {
                        if(c.getData().getPublish().equals(s))
                        {
                            return true;
                        }
                    }
                    if(hasNode(data, c))
                    {
                        return true;
                    }
                }
                    /*
                if (root.children.stream().anyMatch((c) -> (hasNode(data, c)))) {
                    return true;
                }*/
                /*}
                catch(NullPointerException e)
                        {
                    return false;
                }
            }
            return false;
        }

    @Override
    public String toString() {
        String temp = "";
        for(Node n: head.children)
        {
            temp += n.getData().toString();
            temp += toString(n);
            temp += "\n";
        }
        return temp;
    }
    
    public String toString(Node root)
    {
        String temp = "";
        if(!root.children.isEmpty())
        {
            for(Node c: root.children)
            {
                temp += ("->");
                temp += c.getData().toString();
                temp += toString(c);
                return temp;
            }
        }
        return "";
    }*/
}

