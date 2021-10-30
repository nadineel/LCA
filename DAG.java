//uses DFS to find the common Ancestor for 2 nodes
//https://favtutor.com/blogs/depth-first-search-java used as reference for the DFS

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class DAG {
    private int V;
    private LinkedList<Integer> adj[];
    

    DAG(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i){
          adj[i] = new LinkedList();
    	}
    }
 
    void addEdge(int v, int w){
        adj[v].add(w);                              
    }


    public ArrayList<Integer> DFS(int start, int end) {
        ArrayList<Integer> list=new ArrayList<>();
        if(start>=0 && end<=V){
            boolean nodes[] = new boolean[V]; 
            
            int n=start;

            Stack<Integer> stack = new Stack<>(); 
            
            stack.push(n);                                    
            int a = 0;
            
            while(!stack.empty()) 
            { 
                n = stack.peek();                       
                stack.pop();

                
                if(n==end){
                    break;
                }

                if(nodes[n] == false) 
                {  
                    //System.out.print(n+" ");
                    list.add(n);
                    nodes[n] = true; 
                } 
                
                for (int i = adj[n].size()-1; i >=0 ; i--)  
            {
                a = adj[n].get(i);
                if (!nodes[a])                    
                {
                    stack.push(a);                          
                }
            }  
                
            }
        } 
        return list;
    } 


    public int findLCA(int root,int n1, int n2){

        try{
            ArrayList<Integer> node1=DFS(root,n1);
            //System.out.println();
            ArrayList<Integer> node2=DFS(root,n2);

            if(node1.contains(n2)){
                return n2;
            }
            if(node2.contains(n1)){
                return n1;
            }
            if(node1.retainAll(node2)){
                return node1.get(node1.size()-1);
            }
            return -1;
        }
        catch(Exception e){
            return -1;
        }
        

    }

}