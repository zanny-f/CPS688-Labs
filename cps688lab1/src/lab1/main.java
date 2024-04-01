/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;
import java.io.File;
import java.util.*;

/* @author Zanny
    Farzaan Rahim
    CPS 688
    Section 05
    501038746
*/

 
public class main {

    //@param args the command line arguments
    public static void main(String[] args) {
        // TODO code application logic here
    //
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int e = scanner.nextInt();
        graph g = new graph(n);
        for (int i = 0; i < e; i ++){
            int node1 = scanner.nextInt();
            int node2 = scanner.nextInt();
            g.addEdge(node1, node2);
        }

        
        
    System.out.println();
    System.out.println("BFS: ");
    g.BFS(0);
    System.out.println();
    System.out.println();
    System.out.println("DFS: ");
    boolean visited[] = new boolean[n];
    g.DFS(0, visited);


    }

}