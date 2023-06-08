
package Controller;



import java.util.Random;

public class TicTacToeLogics {
    
    private static final int sizeLayout = 3;
    private static final char userInput = 'X';
    private static final char aiComputer = 'O';
    private static final char Enull = '-';
    
    private char[][] board;
    private int AIMoveRow;
    private int AIMoveCol;
    
    public TicTacToeLogics() {
        board = new char[sizeLayout][sizeLayout];
        setBoard();
       
    }
    
    private void setBoard() {
        
        for (int i = 0; i < sizeLayout; i++) {
            for (int j = 0; j < sizeLayout; j++) {
                board[i][j] = Enull;
            }
        }
    }
    public boolean isMoveValid(int row, int col) {
        return  board[row][col] == Enull;
    }
    
    public boolean isBoardFull() {
        for (int i = 0; i < sizeLayout; i++) {
            for (int j = 0; j < sizeLayout; j++) {
                if (board[i][j] == Enull) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean tryWinner(char player) {
        // Check rows
        for (int i = 0; i < sizeLayout; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        
        // Check columns
        for (int i = 0; i < sizeLayout; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        
        return false;
    }
    public boolean isGameOver() {
        return isBoardFull() || tryWinner(userInput) || tryWinner(aiComputer);
    }
    
    public void makeMove(int row, int col, char player) {
        board[row][col] = player;
    }
    
    public void undoMove(int row, int col) {
        board[row][col] = Enull;
    }
    
    public int evaluateBoard() {
        if (tryWinner(aiComputer)) {
            return 1;
        }
        if (tryWinner(userInput)) {
            return -1;
        }
        return 0;
    }
        private int minimax(int depth, boolean isMaximizingPlayer) {
        int score = evaluateBoard();
        
        if (score == 1 || score == -1) {
            return score;
        }
        
        if (isBoardFull()) {
            return 0;
        }
        
        if (isMaximizingPlayer) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < sizeLayout; i++) {
                for (int j = 0; j < sizeLayout; j++) {
                    if (board[i][j] == Enull) {
                        board[i][j] = aiComputer;
                        int currentScore = minimax(depth + 1, false);
                        board[i][j] = Enull;
                        bestScore = Math.max(bestScore, currentScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < sizeLayout; i++) {
                for (int j = 0; j < sizeLayout; j++) {
                    if (board[i][j] == Enull) {
                        board[i][j] = userInput;
                        int currentScore = minimax(depth + 1, true);
                        board[i][j] = Enull;
                        bestScore = Math.min(bestScore, currentScore);
                    }
                }
            }
            return bestScore;
        }
    }
        public void makeAIMove() {
        int bestScore = Integer.MIN_VALUE;
        Random random = new Random();
        
        for (int i = 0; i < sizeLayout; i++) {
            for (int j = 0; j < sizeLayout; j++) {
                if (board[i][j] == Enull) {
                    board[i][j] = aiComputer;
                    int currentScore = minimax(0, false);
                    board[i][j] = Enull;
                    
                    if (currentScore > bestScore) {
                        bestScore = currentScore;
                        AIMoveRow = i;
                        AIMoveCol = j;
                    } else if (currentScore == bestScore && random.nextBoolean()) {
                        // If the current score is the same as the best score, randomly choose one of the moves
                        AIMoveRow = i;
                        AIMoveCol = j;
                    }
                }
            }
        }
        
        board[AIMoveRow][AIMoveCol] = aiComputer;
    }
            public int getComputerMoveRow() {
        return AIMoveRow;
    }
    
    public int getComputerMoveCol() {
        return AIMoveCol;
    }
    
    
}
