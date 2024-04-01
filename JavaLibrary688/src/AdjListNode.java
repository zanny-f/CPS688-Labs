/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 *
 */
public class AdjListNode {
     int dest;
    AdjListNode next;
 
    AdjListNode(int dest){
        this.dest = dest;
        this.next = null;
    }
}
 
// a structure to represent an adjacency list

 
// a structure to represent a graph. A graph is an array of adjacency lists.
// Size of array will be V (number of vertices in graph)
