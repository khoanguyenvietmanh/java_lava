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
public class State {
    private int status;
    
    private ArrayList<Integer> index = new ArrayList<Integer>();
    
    public State()
    {
        
    }
    public State(int status,ArrayList<Integer> index)
    {
        this.status = status;
        
        this.index = index;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the index
     */
    public ArrayList<Integer> getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(ArrayList<Integer> index) {
        this.index = index;
    }
}
