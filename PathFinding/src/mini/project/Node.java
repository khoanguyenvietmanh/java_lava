/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.project;

/**
 *
 * @author admin
 */
public class Node{
    private int x,y;
    private double f,g,h;
    private Node Parent;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Node()
    {
        
    }
    public Node(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    public boolean check_overlap(Node e)
    {
        if(this.getX() == e.getX() && this.getY() == e.getY())
        {
            return true;
        }
        return false;
    }
    public void setParent(Node Parent)
    {
        this.Parent = Parent;
    }

    /**
     * @return the f
     */
    public double getF() {
        return f;
    }

    /**
     * @param f the f to set
     */
    public void setF(double f) {
        this.f = f;
    }

    /**
     * @return the g
     */
    public double getG() {
        return g;
    }

    /**
     * @param g the g to set
     */
    public void setG(double g) {
        this.g = g;
    }

    /**
     * @return the h
     */
    public double getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(double h) {
        this.h = h;
    }

    /**
     * @return the Parent
     */
    public Node getParent() {
        return Parent;
    }
}
