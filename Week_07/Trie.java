class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root= new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(!node.containsKey(c)){
                node.put(c,new TrieNode());
            }
            node=node.get(c);
        }
        node.setEnd(true);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node= root;
        for(char c: word.toCharArray()){
            if(node.containsKey(c)) node=node.get(c);
            else return false;
        }
        return node.getEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node= root;
        for(char c: prefix.toCharArray()){
            if(node.containsKey(c)) node=node.get(c);
            else return false;
        }
        return true;
    }

   static class TrieNode{
        public TrieNode[] link;
        public int R=26;
        public boolean isEnd;

        public TrieNode(){
            link=new TrieNode[R];
        }

        public void put(char c, TrieNode node){
            link[c-'a']=node;
        }

        public TrieNode get(char c){
            return link[c-'a'];
        }

        public boolean containsKey(char c){
            return link[c-'a'] != null;
        }

        public void setEnd(boolean isEnd){
            this.isEnd=isEnd;
        }

        public boolean getEnd(){
            return isEnd;
        }
    }
}