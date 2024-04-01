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
 * Problem 4
 * 
 */


public class CandyShop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //This initializes the # of candies
        int[] values = new int[n];
        int[] weights = new int[n];

        //This will consist of the input sentimental values of candies
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        //This will consist of the input weights of candies
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        int maxWeight = sc.nextInt(); //The maximum weight will essentially be carried by the bag

        int[][] candies = new int[n + 1][maxWeight + 1]; //This is implemented as the dynamic programming array

        // The following was filled for the dynamic programming array
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                //The condition implemented verifies if the current candy can fit in the bag
                if (weights[i - 1] <= j) {
                    candies[i][j] = Math.max(candies[i - 1][j], values[i - 1] + candies[i - 1][j - weights[i - 1]]);
                } 
                else {
                    candies[i][j] = candies[i - 1][j];
                }
            }
        }
        System.out.print ("Candies: ");
        // This will then output highest sentimental aggregated value
        System.out.println (candies[n][maxWeight]); 
    }
}