package Controller;

import Model.EightQueensSql;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;


public class EightQueensLogics {

    String answer;
    int userid;
    String userName;

    List<int[][]> solutions = new ArrayList<>();// Initialize an empty list to store solutions
    
    

    public EightQueensLogics(String answer, int userid, String userName) {
        this.answer = answer;
        this.userid = userid;
        this.userName = userName;
        // Solve the Eight Queens puzzle and save solutions to the list
        solveNQueens(new int[BOARD_SIZE][BOARD_SIZE], 0, solutions);

        // Print the solutions
        int numSolutions = solutions.size();
        System.out.println("Total number of solutions: " + numSolutions);
        for (int i = 0; i < numSolutions; i++) {
            System.out.println("Solution " + (i + 1) + ":");
            int[][] solution = solutions.get(i);
            for (int j = 0; j < BOARD_SIZE; j++) {
                for (int k = 0; k < BOARD_SIZE; k++) {
                    System.out.print(solution[j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        
        
    }

    public void checkSolution(int answerArray[][]) {

        boolean found = false;
        for (int[][] arr : solutions) {
            if (Arrays.deepEquals(arr, answerArray)) {
                found = true;
                break;
            }
        }

        // Print the result
        if (found) {
            EightQueensSql eqsql = new EightQueensSql(userid, answer, userName);
            eqsql.checkCount();
            eqsql.checkAnswer(answer);

        } else {
            JOptionPane.showMessageDialog(null, "Wrong Answer.", "Try Again!", JOptionPane.ERROR_MESSAGE);
        }
    }
    private static final int BOARD_SIZE = 8;

    // Returns true if a queen can be placed at row i and column j
    private static boolean isSafe(int[][] board, int i, int j) {
        // Check row on left side
        for (int k = 0; k < j; k++) {
            if (board[i][k] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (int k = i, l = j; k >= 0 && l >= 0; k--, l--) {
            if (board[k][l] == 1) {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (int k = i, l = j; k < BOARD_SIZE && l >= 0; k++, l--) {
            if (board[k][l] == 1) {
                return false;
            }
        }

        return true;
    }

    // Recursive function to solve the Eight Queens puzzle
    private static void solveNQueens(int[][] board, int col, List<int[][]> solutions) {
        // Base case: all queens have been placed
        if (col == BOARD_SIZE) {
            // Add a copy of the board to the solutions list
            int[][] solution = new int[BOARD_SIZE][BOARD_SIZE];
            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {
                    solution[i][j] = board[i][j];
                }
            }
            solutions.add(solution);
            return;
        }

        // Try placing a queen in each row of the current column
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (isSafe(board, i, col)) {
                // Place queen in board[i][col]
                board[i][col] = 1;

                // Recurse to place queens in subsequent columns
                solveNQueens(board, col + 1, solutions);

                // Remove queen from board[i][col]
                board[i][col] = 0;
            }
        }
    }
    
    
    
}

