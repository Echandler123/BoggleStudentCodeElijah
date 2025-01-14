import java.util.ArrayList;
import java.util.Arrays;
public class Boggle {
    public static String[] findWords(char[][] board, String[] dictionary) {
        Trie trieDict = new Trie();
        ArrayList<String> goodWords = new ArrayList<String>();
        // Creates trie of dictionary of words
        for (String s : dictionary) {
            trieDict.insert(s);
        }
        // Map of visited squares
        boolean [][] visited = new boolean[board.length][board[0].length];
        // Loop through each square on the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                    // Dfs of the current square on the board
                    dfs(board,i, j, trieDict.getRoot(), "", visited,goodWords);
            }
        }
        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }
    public static void dfs(char[][] board,int row, int col, Trie.Node root, String prefix, boolean[][] visited, ArrayList<String> goodWords){
        // Base case of if the square is out of bounds or has already been visited then return
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return;
        }
        // Move to the next node in the trie
        root = root.getNext()[board[row][col]];
        // Add the next character to the current prefix
        prefix += board[row][col];
        // If the current path is not a word then return
        if(root == null){
            return;
        }
        // If the current path is a word  and is not already part of the list of good words then
        // add it to the list of good words
        if (root.isWord() && !goodWords.contains(prefix)) {
            goodWords.add(prefix);
        }
        // Mark the current square as visited
        visited[row][col] = true;
        // Dfs of the squares around the current square
        dfs(board, row - 1, col, root, prefix, visited, goodWords);
        dfs(board, row + 1, col, root, prefix, visited, goodWords);
        dfs(board, row, col - 1, root, prefix, visited, goodWords);
        dfs(board, row, col + 1, root, prefix, visited, goodWords);
        // Unmark the current square as visited for other paths
        visited[row][col] = false;
    }
}

