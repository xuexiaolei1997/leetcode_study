package Basic.BinaryTree.Example;

/**
 * @Author: xuexiaolei
 * @DATE: 2021/9/18 16:33
 * 前缀树
 */
public class TrieTree {
    public static class TrieNode{
        public int pass;
        public int end;
        public TrieNode[] nexts;

        public TrieNode(){
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }

    public static class Trie{
        private TrieNode root;

        public Trie(){
            root = new TrieNode();
        }

        public void insert(String word){
            if (word==null) return;
            char[] chs = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null){
                    node.nexts[index] = new TrieNode();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word){
            if (search(word) != 0){
                char[] chs = word.toCharArray();
                TrieNode node = root;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        public int search(String word){
            if (word==null) return 0;
            char[] chs = word.toCharArray();
            TrieNode node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) return 0;
                node = node.nexts[index];
            }
            return node.end;
        }
    }
}
