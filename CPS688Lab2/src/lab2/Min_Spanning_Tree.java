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
 * Problem 3 
 * 
 */


public class Min_Spanning_Tree {
    
    static class Edge implements Comparable<Edge> {
        int v1, v2;
        int weight;
        
        public Edge(int v1, int v2, int weight) {
            this.v1 = v1;
            this.v2 = v2;
            this.weight = weight;
        }
        
        public int compareTo(Edge other) {
            return Double.compare(this.weight, other.weight);
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, e;
        List<Edge>[] graph;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            e = scanner.nextInt();
            graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<Edge>();
            }
            for (int i = 0; i < e; i++) {
                int v1 = scanner.nextInt();
                int v2 = scanner.nextInt();
                int weight = scanner.nextInt();
                graph[v1].add(new Edge(v1, v2, weight));
                graph[v2].add(new Edge(v2, v1, weight));
            }
            List<Edge> mst = primMST(graph);
            int mstWeight = 0;
            System.out.println("Minimum Spanning Tree:");
            for (Edge edge : mst) {
                System.out.println("Edge "+ edge.v1+"-"+ edge.v2+" has a weight of: "+ edge.weight);
                mstWeight += edge.weight;
            }
            System.out.println("MST weight = " +mstWeight);
            break;
        }
        scanner.close();
    }
    
    public static List<Edge> primMST(List<Edge>[] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        List<Edge> mst = new ArrayList<Edge>();
        visited[0] = true;
        for (Edge edge : graph[0]) {
            pq.offer(edge);
        }
        while (!pq.isEmpty()) {
            Edge minEdge = pq.poll();
            if (visited[minEdge.v2]) {
                continue;
            }
            visited[minEdge.v2] = true;
            mst.add(minEdge);
            for (Edge edge : graph[minEdge.v2]) {
                if (!visited[edge.v2]) {
                    pq.offer(edge);
                }
            }
        }
        return mst;
    }
}