import java.util.*;
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        backtrack(0, board, result, new HashSet<>(), new HashSet<>(), new HashSet<>());
        return result;
    }
    private void backtrack(int row, char[][] board, List<List<String>> result,  Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
        int n = board.length;
        if (row == n) {
            List<String> currentBoard = new ArrayList<>();
            for (char[] r : board) {
                currentBoard.add(new String(r));
            }
            result.add(currentBoard);
            return;
        }
        for (int col = 0; col < n; col++) {
            int diag = row - col;
            int antiDiag = row + col;
            if (cols.contains(col) || diagonals.contains(diag) || antiDiagonals.contains(antiDiag)) {
                continue;
            }
            board[row][col] = 'Q';
            cols.add(col);
            diagonals.add(diag);
            antiDiagonals.add(antiDiag);
            backtrack(row + 1, board, result, cols, diagonals, antiDiagonals);
            board[row][col] = '.';
            cols.remove(col);
            diagonals.remove(diag);
            antiDiagonals.remove(antiDiag);
        }
    }
    public static void main(String[] args) {
        NQueens nq = new NQueens();
        List<List<String>> solutions = nq.solveNQueens(4);
        for (List<String> board : solutions) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
