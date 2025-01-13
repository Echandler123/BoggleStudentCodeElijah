import java.util.ArrayList;
import java.util.Arrays;


public class Boggle {


    public static String[] findWords(char[][] board, String[] dictionary) {


        ArrayList<String> goodWords = new ArrayList<String>();
        // TODO: Complete the function findWords(). Add all words that are found both on the board
        //  and in the dictionary.
        boolean [][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < dictionary.length; i++) {
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board[j].length; k++) {
                    if (dictionary[i].charAt(0) == board[j][k]) {
                        visited[j][k] = true;
                        dfs(j, k, dictionary[i],visited);
                    }
                }
            }
        }
        // Convert the list into a sorted array of strings, then return the array.
        String[] sol = new String[goodWords.size()];
        goodWords.toArray(sol);
        Arrays.sort(sol);
        return sol;
    }
    public static void dfs(int row, int col, String word,boolean[][] visited){
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

