/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mini.project;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author admin
 */
public class Queue{
    private ArrayList<State> list = new ArrayList<State>();
    public void add(State e)
    {
        list.add(e);
    }
   
    /**
     * @return the list
     */
    public ArrayList<State> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<State> list) {
        this.list = list;
    }
}
