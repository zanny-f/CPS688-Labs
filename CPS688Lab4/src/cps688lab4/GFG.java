/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cps688lab4;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 *
 * @author Zanny
 */


class GFG {
    static final int M = 6;
    static final int N = 6;

    boolean bpm(boolean bpGraph[][], int u,
                boolean seen[], int matchR[]) {
        for (int v = 0; v < N; v++) {
            if (bpGraph[u][v] && !seen[v]) {
                seen[v] = true;
                if (matchR[v] < 0 || bpm(bpGraph, matchR[v],
                                         seen, matchR)) {
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    int maxBPM(boolean bpGraph[][]) {
        int matchR[] = new int[N];
        for (int i = 0; i < N; ++i)
            matchR[i] = -1;
        int result = 0;
        for (int u = 0; u < M; u++) {
            boolean seen[] = new boolean[N];
            for (int i = 0; i < N; ++i)
                seen[i] = false;
            if (bpm(bpGraph, u, seen, matchR))
                result++;
        }
        return result;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        boolean bpGraph[][] = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                bpGraph[i][j] = (sc.nextInt() == 1);
            }
        }
        GFG m = new GFG();
        System.out.println("Maximum number of applicants that can get job is " + m.maxBPM(bpGraph));
    }
}
