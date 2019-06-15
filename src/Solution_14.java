import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 */
public class Solution_14 {

    private class Node{
        public char value;
        public Map<Character, Node> map;
        public boolean isWord;

        public Node(char value) {
            this.value = value;
            this.map = new HashMap<>();
            this.isWord = false;
        }
    }

    private class Trie{

        private Node root;

        public Trie() {
            this.root = new Node(',');
        }

        public void add(String str){
            if (str.length() == 0) return;
            __add(root, str, 0);
        }

        //向node节点中添加 str[index]字符
        private void __add(Node node, String str, int index){
            if (index >= str.length()){
                node.isWord = true;
                return;
            }
            //如果node节点中包含要存储的字符
            if (!node.map.containsKey(str.charAt(index))){
                node.map.put(str.charAt(index), new Node(str.charAt(index)));
            }
            __add(node.map.get(str.charAt(index)), str, index+1);
        }

        public String findPrex(){
            if (root.map.isEmpty()) return "";
            StringBuilder res = new StringBuilder();
            res.append("");
            Node cur = root;
            while (cur.map.size() == 1){
                Collection<Node> values = cur.map.values();
                for (Node node : values){
                    cur = node;
                    res.append(node.value);
                }
                if (cur.isWord) break;
            }

            return res.toString();
        }
    }

    //使用Trie字典树解决
    public String longestCommonPrefix(String[] strs) {
        Trie trie = new Trie();
        for (String str : strs){
            if (str.equals("") || str.length() == 0) return "";
            trie.add(str);
        }
        return trie.findPrex();
    }
}
