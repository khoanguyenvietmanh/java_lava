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
public class MiniProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] a = {0,1,2,3,4,5,6};
        Queue q = new Queue();
        q = SearchingUtils.Binary_Search(6, a,0,a.length - 1);
        //q = SearchingUtils.Sequential_Search(6, a);
        for(int i = 0;i < q.getList().size();i++)
        {
          System.out.println(q.getList().get(i).getStatus() + " " + q.getList().get(i).getIndex());
        }
    }
    
}
