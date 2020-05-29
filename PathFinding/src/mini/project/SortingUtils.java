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
public class SortingUtils {
    public static Queue Bubble_Sort(int[] arr)
    {
        Queue q = new Queue();
        String status = new String();
        ArrayList<Integer> index;
        State s1;
        for(int i = 0;i < arr.length - 1;i++)
        {
            status = "Flag";
            index = new ArrayList<Integer>();
            index.add(i);
            
            s1 = new State(status,index);
            
            q.add(s1);
            for(int j = arr.length-1;j > i;j--)
            {
                status = "Choosing";
                index = new ArrayList<Integer>();
                index.add(j-1);
                index.add(j);
                s1 = new State(status,index);
                q.add(s1);
                if(arr[j] < arr[j-1])
                {
                    status = "Change postion";
                    index = new ArrayList<Integer>();
                    index.add(j-1);
                    index.add(j);
                    s1 = new State(status,index);
                    q.add(s1);
                    int temp = arr[j];
                    arr[j] = arr[j-1];;
                    arr[j-1] = temp;
                }
            }
        }
        return q;
    }
    public static Queue Selection_Sort(int[] arr)
    {
        Queue q = new Queue();
        String status = new String();
        ArrayList<Integer> index;
        int min_idx = 0;
        State s1;
        for(int i = 0;i < arr.length-1;i++)
        {
            min_idx = i;
            for(int j = i + 1;j < arr.length;j++)
            {
                status = "Choosing";
            
                index = new ArrayList<Integer>();
                
                index.add(min_idx);
            
                index.add(j);
            
                s1 = new State(status,index);
            
                q.add(s1);
                if(arr[j] < arr[min_idx])
                {
                    min_idx = j;
      
                }
                status = "Min now";
                    
                index = new ArrayList<Integer>();
                    
                index.add(min_idx);
                    
                s1 = new State(status,index);
                    
                q.add(s1);
            }
            //swap
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp; 
            
            status = "Change position";
            
            index = new ArrayList<Integer>();
            
            index.add(i);
                
            index.add(min_idx);
            
            s1 = new State(status,index);
            
            q.add(s1);
        }
        return q;
    }
    public static void Merge(int[] arr,int l,int m,int r)
    {
        int i,j,k;
        int n1 = m - l + 1;
        int n2 = r - m;
        
        int[] L  = new int[n1];
        int[] R  = new int[n2];
        
        for(i = 0; i < n1 ;i++)
        {
            L[i] = arr[l + i]; 
        }
        for(j = 0;j < n2;j++)
        {
            R[j] = arr[m + j +1];
        }
        
        i = 0;
        j = 0;
        k = l;
        
        
        while(i < n1 && j < n2)
        {
            if(L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2)   
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void Merge_Sort(int[] arr,int left,int right)
    {
        if(left < right)
        {
          int mid = left+(right - left)/2;
          
          Merge_Sort(arr,left,mid);
          
          Merge_Sort(arr,mid +1,right);
          
          Merge(arr,left,mid,right);
        }
    }
    public static int Find_max_value(ArrayList<Integer> arr)
    {
        int max_value = arr.get(0);
        for(int i = 1;i < arr.size();i++)
        {
            if(max_value < arr.get(i))
            {
                max_value = arr.get(i);
            }
        }
        return max_value;
    }
    public static void bucket_sort_for_each_part(ArrayList<Integer> arr)
    {
        int max_value = Find_max_value(arr);
        
        int start_pos  = 0;
        
        int[] bucket_array = new int[max_value + 1];
        
        for(int i = 0 ; i < arr.size();i++)
        {
            bucket_array[arr.get(i)]++;
        }
        
        arr.clear();
        
        for(int i = 0 ;i < bucket_array.length;i++)
        {
            for(int j = 0 ; j < bucket_array[i] ; j++)
            {
                arr.add(i);
            }
        }
    }
    public static void Bucket_Sort(int[] arr)
    {
        ArrayList<Integer> Pos = new ArrayList<Integer>();
        
        ArrayList<Integer> Neg = new ArrayList<Integer>();
        
        
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(arr[i] < 0)
            {
                Neg.add(-1 * arr[i]);
            }
            else
            {
                Pos.add(arr[i]);
            }
        }
        
        bucket_sort_for_each_part(Neg);
        bucket_sort_for_each_part(Pos);
        
        for(int i = 0;i < Neg.size();i++)
        {
            arr[i] = -1 * Neg.get(Neg.size() - i -1);
        }
        
        for(int i = Neg.size();i < arr.length;i++)
        {
            arr[i] = Pos.get(i - Neg.size());
        }
    }
}
