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
        APathFinding obj = new APathFinding(8,5);
        
        Node x = new Node(6,1);
        Node y = new Node(5,1);
        Node z = new Node(4,1);
        Node w = new Node(2,0);
        Node t = new Node(2,1);
        obj.getBlock().add(x);
        obj.getBlock().add(y);
        obj.getBlock().add(z);
        obj.getBlock().add(w);
        obj.getBlock().add(t);
        
        obj.find_Path();   
    }
    
}
