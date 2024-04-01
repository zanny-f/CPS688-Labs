/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *

 */
public class Graph {
     // map to store graph values 
     int V;
    AdjList[] array;
 
    // Constructor
    Graph(int V){
        this.V = V;
        array = new AdjList[V];
        // Create an array of adjacency lists.  Size of array will be V
        for (int i = 0; i < V ; i++){
            array[i] = new AdjList();
            array[i].head = null;
        }
    }
 
    // add an edge to the graph
    void addEdge(int src, int dest){
        // Add an edge from src to dest.  A new node is added to the adjacency
        // list of src.  The node is added at the begining
        AdjListNode newNode = new AdjListNode(dest);
        newNode.next = array[src].head;
        array[src].head = newNode;
 
        // Since graph is undirected, add an edge from dest to src also
        newNode = new AdjListNode(src);
        newNode.next = array[dest].head;
        array[dest].head = newNode;
    }
 
    // compute the degree of a vertex
    int degreeVertex(int v){
        int degree = 0;
        AdjListNode temp = array[v].head;
        while (temp != null){
            degree++;
            temp = temp.next;
        }
        return degree;
    }
 
    // prints the adjacency list of each vertex
    void printAdjVertices(int v){
        AdjListNode temp = array[v].head;
        while (temp != null){
            System.out.print(temp.dest + " ");
            temp = temp.next;
        }
        System.out.println();
    }
 
    // prints the BFS traversal of the graph
    void bfs(int s){
        // Mark all the vertices as not visited(false)
        boolean visited[] = new boolean[V];
 
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
 
        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);
 
        while (queue.size() != 0){
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            AdjListNode temp = array[s].head;
            while (temp != null){
                if (!visited[temp.dest]){
                    visited[temp.dest] = true;
                    queue.add(temp.dest);
                }
                temp = temp.next;
            }
        }
    }
 
    // prints the DFS traversal of the graph
    void dfs(int v, boolean visited[]){
        // Mark the current node as visited
        visited[v] = true;
        System.out.print(v + " ");
 
        // Recurse for all the vertices adjacent to this vertex
        AdjListNode temp = array[v].head;
        while (temp != null){
            if (!visited[temp.dest])
                dfs(temp.dest, visited);
            temp = temp.next;
        }
    
    
    
}
}
