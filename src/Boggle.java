import java.util.ArrayList;
import java.util.Arrays;


public class Boggle {


    public static String[] findWords(char[][] board, String[] dictionary) {
        Trie trieDict = new Trie();
        ArrayList<String> goodWords = new ArrayList<String>();
        for (int i = 0; i < dictionary.length; i++) {
            trieDict.insert(dictionary[i]);
        }
        boolean [][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
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
//        if we have been here before, return
//        if this word is not a valid prefix, return
//                mark this square as visited
//        recurse up, down, left, right with updated word
//        mark this square as not visited
        if(visited[row][col] == true){
            return;
        }
    }
}

