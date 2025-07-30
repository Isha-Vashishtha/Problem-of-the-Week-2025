// package Word Search in 2D Matrix;
import java .util.*;
public class WordSearch {
    public boolean bruteExist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        List<List<int[]>> allPaths = new ArrayList<>();        
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    generatePaths(new ArrayList<>(), allPaths, board, i, j, word.length());
                }
        }
        for (List<int[]> path : allPaths) {
            StringBuilder sb = new StringBuilder();
            boolean[][] visited = new boolean[m][n];
            boolean valid = true;
            for (int[] pos : path) {
                int x = pos[0], y = pos[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
                    valid = false;
                    break;
                }
                sb.append(board[x][y]);
                visited[x][y] = true;
            }
            if (valid && sb.toString().equals(word)) return true;
        }
        return false;
    }
    private void generatePaths(List<int[]> currentPath, List<List<int[]>> allPaths,
                               char[][] board, int x, int y, int length) {
        if (currentPath.size() == length) {
            allPaths.add(new ArrayList<>(currentPath));
            return;
        }
        currentPath.add(new int[]{x, y});
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int[] dir : dirs) {
            int newX = x + dir[0], newY = y + dir[1];
            generatePaths(currentPath, allPaths, board, newX, newY, length);
        }
        currentPath.remove(currentPath.size() - 1); 
    }
    public static void main(String[] args) {
        WordSearch solution = new WordSearch();
        char[][] board = {{'A','B','C','E'},
                          {'S','F','C','S'},
                          {'A','D','E','E'}};
        String word1 = "ABCCED";
        String word2 = "SEE";
        String word3 = "ABCB";
        System.out.println("Word: " + word1 + " → " + solution.bruteExist(board, word1)); // true
        System.out.println("Word: " + word2 + " → " + solution.bruteExist(board, word2)); // true
        System.out.println("Word: " + word3 + " → " + solution.bruteExist(board, word3)); // false
    }
}
