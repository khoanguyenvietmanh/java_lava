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
public class SearchingUtils {
  public static Queue Sequential_Search(int search_value,int[] a)
  {
      Queue q = new Queue();
      int status;
      ArrayList<Integer> index;
      State s1;
      for(int i=0 ; i < a.length; i++)
      {
          index = new ArrayList<Integer>();
          status = Constants.Sequential_Status.CHOOSING_STATUS;
          index.add(i);
          s1 = new State(status,index);
          q.getList().add(s1);
          if(a[i] == search_value)
          {
              index = new ArrayList<Integer>();
              status = Constants.Sequential_Status.FOUND_VALUE_STATUS;
              index.add(i);
              s1 = new State(status,index);
              q.getList().add(s1);
              break;
          }
          else
          {
              index = new ArrayList<Integer>();
              status = Constants.Sequential_Status.NOT_STATUS;
              index.add(i);
              s1 = new State(status,index);
              q.getList().add(s1);
          }
      }
      return q;
  }
  public static Queue Binary_Search(int search_value,int[] a,int l,int r)
  {
      Queue q = new Queue();
      int status;
      ArrayList<Integer> index;
      State s;
      
      while(l <= r)
      {
        int mid = l + (r-l)/2; // same as (l+r)/2 but avoid overflow;
        
        
        //Save the range of array after each loop(left index,right index)
        status  = Constants.Binary_Search_Status.RANGE_STATUS;
        index = new ArrayList<Integer>();
        index.add(l);
        index.add(r);
        s = new State(status,index);
        q.getList().add(s);
        
        
        //Store the value of "mid" index
        status = Constants.Binary_Search_Status.MID_STATUS;
        index = new ArrayList<Integer>();
        index.add(mid);
        s = new State(status,index);
        q.getList().add(s);
        
        if(search_value == a[mid])
        {
            //When Found the value,store the index!!!
            index = new ArrayList<Integer>();
            status = Constants.Binary_Search_Status.FOUND_VALUE_STATUS;
            index.add(mid);
            s = new State(status,index);
            q.getList().add(s);
            return q;
        }
        else
        {
            status = Constants.Binary_Search_Status.NOT_MID_STATUS;
            index = new ArrayList<Integer>();
            index.add(mid);
            s = new State(status,index);
            q.getList().add(s);
            
            status = Constants.Binary_Search_Status.DELETE_STATUS;
            index = new ArrayList<Integer>();
            index.add(l);
            index.add(r);
            s = new State(status,index);
            q.getList().add(s);
            
            if(search_value < a[mid])
            {
               r = mid - 1;
            }
            else
            {
               l = mid +1 ;
            }
        }
       }
      return q;
    }
}
