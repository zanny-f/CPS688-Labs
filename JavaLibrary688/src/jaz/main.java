/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaz;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//** @author 
 
public class main {

    //@param args the command line arguments
     //*/
    public static void main(String[] args) {
        // TODO code application logic here
    //
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        Graph g = new Graph(n);
        for (int i = 0; i < e; i ++){
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            g.addEdge(node1, node2);
        }
    
        
           
        //Graph g = new Graph(7);
//        g.addEdge(6, 6);
//        g.addEdge(0, 1);
//        g.addEdge(0, 3);
//        g.addEdge(1, 2);
//        g.addEdge(2, 4);
//        g.addEdge(3, 4);
//        g.addEdge(3, 5);
       

    System.out.println("Degree of vertex 2: " + g.degreeVertex(0));
    g.printAdjVertices(0);
    System.out.println("BFS: ");
    g.BFS(0);
    System.out.println();
    System.out.println("DFS: ");
    boolean visited[] = new boolean[7];
    g.DFS(0, visited);


    }

}