/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.project;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class APathFinding {
    private Node start_node;
    
    private Node end_node;
    
    private ArrayList<Node> Block =  new ArrayList<>();
    
    private ArrayList<Node> OpenList = new ArrayList<>();
    
    private ArrayList<Node> CloseList = new ArrayList<>();
    
    private ArrayList<ArrayList<Node>> Map;
    
    public APathFinding(int ROW,int COL)
    {
        start_node = new Node(7,0);
        end_node = new Node(0,0);
        Map = new ArrayList<ArrayList<Node>>(ROW);
        
        for(int i = 0;i  < ROW;i++)
        {
            ArrayList<Node> temp = new ArrayList<Node>(COL);
            for(int j = 0 ;j < COL ; j++)
            {
                temp.add(new Node(i,j));
            }
            Map.add(temp);
        }
        
    }
    public Node getStart_node() {
        return start_node;
    }

    public void setStart_node(Node start_node) {
        this.start_node = start_node;
    }

    public Node getEnd_node() {
        return end_node;
    }

    public void setEnd_node(Node end_node) {
        this.end_node = end_node;
    }

    public ArrayList<Node> getBlock() {
        return Block;
    }

    public void setBlock(ArrayList<Node> Block) {
        this.Block = Block;
    }

    public ArrayList<Node> getOpenList() {
        return OpenList;
    }

    public void setOpenList(ArrayList<Node> OpenList) {
        this.OpenList = OpenList;
    }

    public ArrayList<Node> getCloseList() {
        return CloseList;
    }

    public void setCloseList(ArrayList<Node> CloseList) {
        this.CloseList = CloseList;
    }

    public ArrayList<ArrayList<Node>> getMap() {
        return Map;
    }

    public void setMap(ArrayList<ArrayList<Node>> Map) {
        this.Map = Map;
    }
    
    public boolean isValid(int x,int y)
    {
        return x >=0 && x < getMap().size() && y >= 0 && y < getMap().get(0).size();
    }
    public boolean isValid(Node x)
    {
        return x.getX()>=0 && x.getX() < getMap().size() && x.getY() >= 0 && x.getY() < getMap().get(0).size();
    }
    public boolean isDestination(Node x)
    {
        return x.check_overlap(getEnd_node());
    }
    public boolean isBlocked(Node x)
    {
        for(int i = 0;i < getBlock().size() ; i++)
        {
            if(x.check_overlap(getBlock().get(i)))
            {
                return true;
            }
        }
        return false;
    }
    public boolean isClosed(Node x)
    {
        for(int i = 0;i < getCloseList().size(); i++)
        {
            if(x.check_overlap(getCloseList().get(i)))
            {
                return true;
            }
        }
        return false;
    }
    public double calculate_H_value(Node x)
    {
        return ((double) Math.sqrt(Math.pow(x.getX() - getEnd_node().getX(),2) + Math.pow(x.getY() - getEnd_node().getY(), 2)));
    }
    public double calculate_G_value(Node x,Node y)
    {
        return ((double) Math.sqrt(Math.pow(x.getX() - y.getX(),2) + Math.pow(x.getY() - y.getY(), 2)));
    }
    public void Trace_Path()
    {
        int row = getEnd_node().getX();
        int col = getEnd_node().getY();
        ArrayList<Node> Path = new ArrayList<Node>();
        while(!(Map.get(row).get(col).getParent().getX() == -1 && Map.get(row).get(col).getParent().getY() == -1))
        {
            Node X = new Node(row,col);;
            Path.add(X);
            int temp_row = getMap().get(row).get(col).getParent().getX();
            int temp_col = getMap().get(row).get(col).getParent().getY();
            row = temp_row;
            col = temp_col;
        }
        Path.add(getStart_node());
        for(int i = Path.size()-1;i >= 0 ;i--)
        {
            if(i != 0)
            {
                System.out.printf("(%d %d)--->",Path.get(i).getX(),Path.get(i).getY());
            }
            else
            {
                System.out.printf("(%d %d)",Path.get(i).getX(),Path.get(i).getY());
            }
        }
    }
    public void find_Path()
    {
        // check src and dest is valid or not
        if(!isValid(start_node) || !isValid(end_node))
        {
            return;
        }
       
        // check src and dest is blocked or not
        if(isBlocked(getStart_node()) || isBlocked(getEnd_node()))
        {
            return;
        }
        
        // check src and dest equal so we are already at the destination
        if(isDestination(getStart_node()))
        {
            System.out.println("We are already at the destination!!!");
            return;
        }
        
        // Initialise all parameters for each node in map
        for(int i = 0; i < getMap().size() ; i++)
        {
            for(int j = 0 ; j < getMap().get(0).size(); j++)
            {
                getMap().get(i).get(j).setF(Double.MAX_VALUE);
                getMap().get(i).get(j).setH(Double.MAX_VALUE);
                getMap().get(i).get(j).setG(Double.MAX_VALUE);
                Node parent = new Node(-1,-1);
                getMap().get(i).get(j).setParent(parent);
                getMap().get(i).get(j).setParent(parent);
            }
        }
        
        // Initialize value for start node
        start_node.setF(0.0);
        start_node.setG(0.0);
        start_node.setH(0.0);
        
        Node start_node_parent = new Node();
        start_node_parent.setX(start_node.getX());
        start_node_parent.setY(start_node.getY());
 
        start_node.setParent(start_node_parent);
        
        // Add to the open list the start node
        getOpenList().add(getStart_node());
        
        boolean found_dest = false;
        
        Node x = new Node();
        
        while(getOpenList().size() != 0)
        {
            Node temp = new Node();
            
            // pop the node have lowest value f
            temp = getOpenList().get(0);
            
            getOpenList().remove(0);
            
            getCloseList().add(temp);
            
            int i = temp.getX();
         
            int j = temp.getY();
            
            Node Parent = new Node(i,j);
            
            double NewG,NewH,NewF;
            // Check the next node at position [i-1,j]
            if(isValid(i-1,j))
            {
                x = getMap().get(i-1).get(j);
                if(isDestination(x))
                {
                     x.setParent(Parent);
                    // trace path(print path)
                    System.out.println("The destination is found");
                    this.Trace_Path();
                    found_dest = true;
                    return;
                }
                else
                {
                    if(!isClosed(x) && !isBlocked(x))
                    {
                        NewG = temp.getG() + calculate_G_value(x, temp);
                        NewH = calculate_H_value(x);
                        NewF = NewG + NewH;
                        if(x.getF() == Double.MAX_VALUE || x.getF() > NewF)
                        {
                            x.setF(NewF);
                            getOpenList().add(x);
                            
                            getMap().get(i-1).get(j).setG(NewG);
                            getMap().get(i-1).get(j).setH(NewH);
                            
                            getMap().get(i-1).get(j).setParent(Parent);
                            getMap().get(i-1).get(j).setParent(Parent);
                            
                        }
                    }
                }
            }
            // Check the next node at position [i+1,j]
            if(isValid(i+1,j))
            {
                x = getMap().get(i+1).get(j);
                if(isDestination(x))
                {
                    x.setParent(Parent);
                    // trace path(print path)
                    System.out.println("The destination is found");
                    this.Trace_Path();
                    found_dest = true;
                    return;
                }
                else
                {
                    if(!isClosed(x) && !isBlocked(x))
                    {
                        NewG = temp.getG() + calculate_G_value(x, temp);
                        NewH = calculate_H_value(x);
                        NewF = NewG + NewH;
                        if(x.getF() == Double.MAX_VALUE || x.getF() > NewF)
                        {
                            x.setF(NewF);
                            getOpenList().add(x);
                            
                            getMap().get(i+1).get(j).setG(NewG);
                            getMap().get(i+1).get(j).setH(NewH);
                            getMap().get(i+1).get(j).setParent(Parent);
                            getMap().get(i+1).get(j).setParent(Parent);
                        }
                    }
                }
            }
            //Check the node at position [i,j-1]
            if(isValid(i,j-1))
            {
                x = getMap().get(i).get(j-1);
                if(isDestination(x))
                {
                    x.setParent(Parent);
                    // trace path(print path)
                    System.out.println("The destination is found");
                    this.Trace_Path();
                    found_dest = true;
                    return;
                }
                else
                {
                    if(!isClosed(x) && !isBlocked(x))
                    {
                        NewG = temp.getG() + calculate_G_value(x, temp);
                        NewH = calculate_H_value(x);
                        NewF = NewG + NewH;
                        if(x.getF() == Double.MAX_VALUE || x.getF() > NewF)
                        {
                            x.setF(NewF);
                            getOpenList().add(x);
                            
                            getMap().get(i).get(j-1).setG(NewG);
                            getMap().get(i).get(j-1).setH(NewH);
                            getMap().get(i).get(j-1).setParent(Parent);
                            getMap().get(i).get(j-1).setParent(Parent);
                        }
                    }
                }
            }
            //Check the node at position [i,j+1]
            if(isValid(i,j+1))
            {
                x = getMap().get(i).get(j+1);
                if(isDestination(x))
                {
                    x.setParent(Parent);
                    // trace path(print path)
                    System.out.println("The destination is found");
                    this.Trace_Path();
                    found_dest = true;
                    return;
                }
                else
                {
                    if(!isClosed(x) && !isBlocked(x))
                    {
                        NewG = temp.getG() + calculate_G_value(x, temp);
                        NewH = calculate_H_value(x);
                        NewF = NewG + NewH;
                        if(x.getF() == Double.MAX_VALUE || x.getF() > NewF)
                        {
                            x.setF(NewF);
                            getOpenList().add(x);
                            
                            getMap().get(i).get(j+1).setG(NewG);
                            getMap().get(i).get(j+1).setH(NewH);
                            getMap().get(i).get(j+1).setParent(Parent);
                            getMap().get(i).get(j+1).setParent(Parent);
                        }
                    }
                }
            }
            //Check the node at position [i+1,j+1]
            if(isValid(i+1,j+1))
            {
                x = getMap().get(i+1).get(j+1);
                if(isDestination(x))
                {
                    x.setParent(Parent);
                    // trace path(print path)
                    System.out.println("The destination is found");
                    this.Trace_Path();
                    found_dest = true;
                    return;
                }
                else
                {
                    if(!isClosed(x) && !isBlocked(x))
                    {
                        NewG = temp.getG() + calculate_G_value(x, temp);
                        NewH = calculate_H_value(x);
                        NewF = NewG + NewH;
                        if(x.getF() == Double.MAX_VALUE || x.getF() > NewF)
                        {
                            x.setF(NewF);
                            getOpenList().add(x);
                            
                            getMap().get(i+1).get(j+1).setG(NewG);
                            getMap().get(i+1).get(j+1).setH(NewH);
                            getMap().get(i+1).get(j+1).setParent(Parent);
                            getMap().get(i+1).get(j+1).setParent(Parent);
                        }
                    }
                }
            }
            //Check the node at position [i+1,j-1] 
            if(isValid(i+1,j-1))
            {
                x = getMap().get(i+1).get(j-1);
                if(isDestination(x))
                {
                    x.setParent(Parent);
                    // trace path(print path)
                    System.out.println("The destination is found");
                    this.Trace_Path();
                    found_dest = true;
                    return;
                }
                else
                {
                    if(!isClosed(x) && !isBlocked(x))
                    {
                        NewG = temp.getG() + calculate_G_value(x, temp);
                        NewH = calculate_H_value(x);
                        NewF = NewG + NewH;
                        if(x.getF() == Double.MAX_VALUE || x.getF() > NewF)
                        {
                            x.setF(NewF);
                            getOpenList().add(x);
                            
                            getMap().get(i+1).get(j-1).setG(NewG);
                            getMap().get(i+1).get(j-1).setH(NewH);
                            getMap().get(i+1).get(j-1).setParent(Parent);
                            getMap().get(i+1).get(j-1).setParent(Parent);
                        }
                    }
                }
            }
            //Check the node at position [i-1,j+1]
            if(isValid(i-1,j+1))
            {
                x = getMap().get(i-1).get(j+1);
                if(isDestination(x))
                {
                    x.setParent(Parent);
                    // trace path(print path)
                    System.out.println("The destination is found");
                    this.Trace_Path();
                    found_dest = true;
                    return;
                }
                else
                {
                    if(!isClosed(x) && !isBlocked(x))
                    {
                        NewG = temp.getG() + calculate_G_value(x, temp);
                        NewH = calculate_H_value(x);
                        NewF = NewG + NewH;
                        if(x.getF() == Double.MAX_VALUE || x.getF() > NewF)
                        {
                            x.setF(NewF);
                            getOpenList().add(x);
                            
                            getMap().get(i-1).get(j+1).setG(NewG);
                            getMap().get(i-1).get(j+1).setH(NewH);
                            getMap().get(i-1).get(j+1).setParent(Parent);
                            getMap().get(i-1).get(j+1).setParent(Parent);
                        }
                    }
                }
            }
            //Check the node at position [i-1,j-1]
            if(isValid(i-1,j-1))
            {
                x = getMap().get(i-1).get(j-1);
                if(isDestination(x))
                {
                    x.setParent(Parent);
                    // trace path(print path)
                    System.out.println("The destination is found");
                    this.Trace_Path();
                    found_dest = true;
                    return;
                }
                else
                {
                    if(!isClosed(x) && !isBlocked(x))
                    {
                        NewG = temp.getG() + calculate_G_value(x, temp);
                        NewH = calculate_H_value(x);
                        NewF = NewG + NewH;
                        if(x.getF() == Double.MAX_VALUE || x.getF() > NewF)
                        {
                            x.setF(NewF);
                            getOpenList().add(x);
                            
                            getMap().get(i-1).get(j-1).setG(NewG);
                            getMap().get(i-1).get(j-1).setH(NewH);
                            getMap().get(i-1).get(j-1).setParent(Parent);
                            getMap().get(i-1).get(j-1).setParent(Parent);
                        }
                    }
                }
            }
        }
        // if not finding the path from start_node to end_node
        if(!found_dest)
        {
            return;
        }
    }
}
