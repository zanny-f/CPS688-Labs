/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;
import java.util.*;

/**
 *
 * @author Zanny
 * Problem 2
 * 
 */
public class Acyclic_Graph {
    

    static class Graph {
        int V;
        List<List<Integer>> adjList;

        public Graph(int V) {
            this.V = V;
            adjList = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        public void addEdge(int u, int v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        public boolean hasCycle() {
            boolean[] visited = new boolean[V];
            for (int v = 0; v < V; v++) {
                if (!visited[v]) {
                    if (hasCycleUtil(v, visited, -1)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean hasCycleUtil(int v, boolean[] visited, int parent) {
            visited[v] = true;

            for (int adj : adjList.get(v)) {
                if (!visited[adj]) {
                    if (hasCycleUtil(adj, visited, v)) {
                        return true;
                    }
                } else if (adj != parent) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt(); // number of vertices
            int e = sc.nextInt(); // number of edges

            Graph graph = new Graph(n);
            
            for (int i = 0; i < e; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph.addEdge(u, v);
            }
            
            if (graph.hasCycle()) {
                System.out.println("no");
            } 
            
            else {
                System.out.println("yes");
            }
            break;
        }
    }
}

