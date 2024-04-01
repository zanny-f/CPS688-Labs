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
 * Problem 5
 *
 */

public class LIS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the length of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter the array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // create b[] array
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(arr[i]);
        }
        int[] b = new int[set.size()];
        int k = 0;
        for (int num : set) {
            b[k++] = num;
        }
        int m = b.length;
        
        // create dp[] and parent[] arrays
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        
        // fill dp[] and parent[] arrays
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
        }
        
        // find the index of the maximum value in dp[]
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }
        
        // print the LIS and the elements that formed it
        System.out.println("Length of the LIS: " + dp[maxIndex]);
        System.out.print("LIS is: ");
        List<Integer> lis = new ArrayList<>();
        int currIndex = maxIndex;
        while (currIndex != -1) {
            lis.add(arr[currIndex]);
            currIndex = parent[currIndex];
        }
        Collections.reverse(lis);
        for (int num : lis) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
