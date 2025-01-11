public class Trie {
    public class Node {
        boolean isWord;
        Node[] next;
        public Node() {
            this.isWord = false;
            this.next = new Node[256];
        }
        public boolean isWord() {
            return isWord;
        }
        public void setWord() {
            isWord = true;
        }
        public Node[] getNext() {
            return next;
        }
    }
    public Trie() {
        root = new Node();
    }
    private Node root;
    public void insert (String s){
        Node N = root;
        // Loop through each letter of the string
        for(int i = 0; i < s.length(); i++){
            // If there is no node where the next character should be the create a new word there
            if(N.getNext()[s.charAt(i)] == null) {
                N.getNext()[s.charAt(i)]= new Node();
            }
            // Set current node as the next one
            N = N.getNext()[s.charAt(i)];
        }
        // Set the final node as the end of the word
        N.setWord();
    }
    public boolean lookup(String s) {
        Node N = root;
        // Loop through each character of the string
        for (int i = 0; i < s.length(); i++) {
            // If the character's node isn't there then it isn't a word
            if(N.getNext()[s.charAt(i)] == null) {
                return false;
            }
            // Go to next word
            N = N.getNext()[s.charAt(i)];
        }
        return N.isWord();
    }
}
