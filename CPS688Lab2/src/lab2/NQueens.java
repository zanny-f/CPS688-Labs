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
 * Problem 1
 */
public class NQueens {
    private int[][] board;
    private int n;
    
    

    public NQueens(int n) {
        board = new int[n][n];
        this.n = n;
    }

    public void solve() {
        if (placeQueens(0)) {
            System.out.println("Solution found:");
            printBoard();
        } else {
            System.out.println("No solution found.");
        }
    }

    private boolean placeQueens(int colIndex) {
        if (colIndex == n) {
            return true; // all queens are successfully placed
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(i, colIndex)) {
                board[i][colIndex] = 1; // place the queen
                if (placeQueens(colIndex + 1)) {
                    return true;
                }
                board[i][colIndex] = 0; // remove the queen and try the next row
            }
        }
        return false; // no safe place for the queen in this column
    }

    private boolean isSafe(int row, int col) {
        // Check if there is a queen in the same row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true; // no conflicts found
    }

    private void printBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter Board size: ");
        Scanner scanner = new Scanner(System.in);
        int n;
        n = scanner.nextInt();
        NQueens solver = new NQueens(n);
        solver.solve();
    }
}
