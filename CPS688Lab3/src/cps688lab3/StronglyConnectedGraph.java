package cps688lab3;
import java.util.*;
/**
 *
 * @author farza
 */
public class StronglyConnectedGraph {
    static int n,e;
    static List<Integer>[] adj;
    public static void main(String[] args) {
        System.out.println("Please enter number of antennas and cables: ");
        Scanner s1 = new Scanner(System.in);
        String input1 = s1.nextLine();
        String [] splitInput1 = input1.split(" ");
        n = Integer.parseInt(splitInput1[0]);
        e = Integer.parseInt(splitInput1[1]);
        adj = new List[n];
        for(int a = 0; a < n; a++){ 
            adj[a] = new ArrayList<>();
        }
        System.out.println("Please enter the edges: ");
        for(int a = 0; a < e; a++){
            Scanner s2 = new Scanner(System.in);
            String edge = s2.nextLine();
            String [] splitEdge = edge.split(" ");
            int antenna1 = Integer.parseInt(splitEdge[0]);
            int antenna2 = Integer.parseInt(splitEdge[1]);
            adj[antenna1].add(antenna2);
            
        }
        
        boolean a = isStronglyConnected(n);
        if(!a){
            System.out.println("No");
        }
        else{
            System.out.println("Yes");
            
        }
        
    }
    
    
    public static void reverseGraph(){
        ArrayList<Integer>[] rev = new ArrayList[n];
        for(int a = 0; a < n; a++){
            rev[a] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            for(int j: adj[i]){
                rev[j].add(i);
            }    
        }
        adj=rev;
    }
    
    public static boolean isStronglyConnected(int n) {
        boolean[] visited = new boolean[n];
        dfs(adj, visited, 0); // start from vertex 0
        for (boolean v : visited) {
            if (!v) {
                return false; // not all vertices are reachable from 0
            }
        }
        reverseGraph();
        visited = new boolean[n];
        dfs(adj, visited, 0); // start from vertex 0 in the reversed graph
        for (boolean v : visited) {
            if (!v) {
                return false; // not all vertices can reach 0
            }
        }
        return true; // the graph is strongly connected
    }

    public static void dfs(List<Integer>[] adj, boolean[] visited, int v) {
        visited[v] = true;
        for (int u : adj[v]) {
            if (!visited[u]) {
                dfs(adj, visited, u);
            }
            break;
        }

    }
  
}