/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Zanny
 * Farzaan Rahim
   CPS 688
   Section 05
   501038746
 */
public class graph {
    private int V; // number of vertices
    private LinkedList<Integer> adj[]; // adjacency list

    // constructor
    graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    // function to add an edge to the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // for undirected graph
    }

    // function to compute the degree of a vertex
    int degreeVertex(int v) {
        return adj[v].size();
    }

    // function to print the adjacent vertices of a vertex
    void printAdjVertices(int v) {
        System.out.print("Adjacent vertices of vertex " + v + ": ");
        for (Integer i : adj[v]) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // function to perform BFS
    void BFS(int s) {
        boolean visited[] = new boolean[V];
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[s] = true;
        queue.add(s);
        while (queue.size() != 0) {
            s = queue.poll();
            System.out.print(s + " ");
            for (Integer i : adj[s]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    // function to perform DFS
    void DFS(int v, boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        for (Integer i : adj[v]) {
            if (!visited[i]) {
                DFS(i, visited);
            }
        }
    }
}