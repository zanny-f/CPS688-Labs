/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cps688lab3;
import java.util.*;

/**
 *
 * @author farza
 */
import java.util.Scanner;

public class RodCutting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            int[] p = new int[n+1];
            for (int i = 1; i <= n; i++) {
                p[i] = scanner.nextInt();
            }
            int[] r = new int[n+1];
            for (int i = 1; i <= n; i++) {
                int maxRevenue = 0;
                for (int j = 1; j <= i; j++) {
                    maxRevenue = Math.max(maxRevenue, p[j] + r[i-j]);
                }
                r[i] = maxRevenue;
            }
            System.out.println(r[n]);
            break;
        }
        scanner.close();
        
    }
}