/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *

 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
          // Create a graph given in the above diagram 
       // Create a graph given in the above diagram
        Graph g = new Graph(4);
        // e and n
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
 
        System.out.println("Degree of 0: " + g.degreeVertex(0));
        System.out.println("Adjacent vertices of 0:");
        g.printAdjVertices(0);
 
        System.out.println("\nBFS traversal of the graph:");
        g.bfs(2);
 
        System.out.println("\nDFS traversal of the graph:");
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[4];
        g.dfs(2, visited);
    }
        
   
    }
    