package com.thealgorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] board = new int[n]; // board[i] represents the row of the queen in column i
        solveNQueensRecursive(solutions, board, 0, n);
        return solutions;
    }

    private static void solveNQueensRecursive(List<List<String>> solutions, int[] board, int col, int n) {
        if (col == n) {
            solutions.add(generateSolution(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(board, col, row)) {
                board[col] = row;
                solveNQueensRecursive(solutions, board, col + 1, n);
            }
        }
    }

    private static boolean isSafe(int[] board, int col, int row) {
        for (int prevCol = 0; prevCol < col; prevCol++) {
            int prevRow = board[prevCol];
            if (prevRow == row || Math.abs(prevRow - row) == Math.abs(prevCol - col)) {
                return false;
            }
        }
        return true;
    }

    private static List<String> generateSolution(int[] board) {
        List<String> solution = new ArrayList<>();
        for (int row : board) {
            StringBuilder rowString = new StringBuilder();
            for (int i = 0; i < board.length; i++) {
                rowString.append(i == row ? "Q" : ".");
            }
            solution.add(rowString.toString());
        }
        return solution;
    }

    public static void main(String[] args) {
        int n = 4; // Adjust this to the desired board size
        List<List<String>> solutions = solveNQueens(n);
        if (solutions.isEmpty()) {
            System.out.println("No solutions found for a " + n + "x" + n + " board.");
        } else {
            System.out.println("Solutions for a " + n + " queens puzzle:");
            for (List<String> solution : solutions) {
                for (String row : solution) {
                    System.out.println(row);
                }
                System.out.println();
            }
        }
    }
}
