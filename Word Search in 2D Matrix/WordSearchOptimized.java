// package Word Search in 2D Matrix;

public class WordSearchOptimized {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int idx, int x, int y) {
        if (idx == word.length()) return true;
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length 
            || board[x][y] != word.charAt(idx)) return false;
        char temp = board[x][y];
        board[x][y] = '#'; 
        boolean found = dfs(board, word, idx + 1, x + 1, y)
            || dfs(board, word, idx + 1, x - 1, y)
            || dfs(board, word, idx + 1, x, y + 1)
            || dfs(board, word, idx + 1, x, y - 1);
        board[x][y] = temp; // backtrack
        return found;
    }
    public static void main(String[] args) {
        WordSearchOptimized solution = new WordSearchOptimized();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(solution.exist(board,word)); 

        char[][] board1 = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String words = "ABCB";
        System.out.println(solution.exist(board1,words)); 
    }
}
