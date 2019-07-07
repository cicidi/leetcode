package src.algorithm.matric;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class TrieNode {            //定义字典树的节点
    String word;
    HashMap<Character, TrieNode> children;   //使用HashMap动态开节点

    public TrieNode() {
        word = null;
        children = new HashMap<Character, TrieNode>();
    }
};


class TrieTree {
    TrieNode root;

    public TrieTree(TrieNode TrieNode) {
        root = TrieNode;
    }

    public void insert(String word) {        //字典树插入单词
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.children.containsKey(word.charAt(i))) {
                node.children.put(word.charAt(i), new TrieNode());
            }
            node = node.children.get(word.charAt(i));
        }
        node.word = word;
    }
}

public class WordSearchII_JZ {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public int[] dx = {1, 0, -1, 0};   //搜索方向
    public int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}

        };
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        WordSearchII_JZ wordSearchIIJz = new WordSearchII_JZ();
        List<String> res = wordSearchIIJz.wordSearchII(board, Arrays.asList(words));
        System.out.println("done");
    }

    public void search(char[][] board,            //在字典树上dfs查找
                       int x,
                       int y,
                       TrieNode root,
                       List<String> results) {
        if (!root.children.containsKey(board[x][y])) {
            return;
        }

        TrieNode child = root.children.get(board[x][y]);

        if (child.word != null) {      //如果访问到字典树叶子，将字符串压入result即可
            if (!results.contains(child.word)) {
                results.add(child.word);
            }
        }

        char tmp = board[x][y];
        board[x][y] = 0;  // mark board[x][y] as used

        for (int i = 0; i < 4; i++) {      //向四个方向dfs搜索
            if (!isValid(board, x + dx[i], y + dy[i])) {
                continue;
            }
            search(board, x + dx[i], y + dy[i], child, results);
        }

        board[x][y] = tmp;  // revert the mark
    }

    private boolean isValid(char[][] board, int x, int y) {     //检测搜索位置合法
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }

        return board[x][y] != 0;
    }

    public List<String> wordSearchII(char[][] board, List<String> words) {
        List<String> results = new ArrayList<String>();

        TrieTree tree = new TrieTree(new TrieNode());
        for (String word : words) {
            tree.insert(word);
        }

        for (int i = 0; i < board.length; i++) {                //遍历字母矩阵，将每个字母作为单词首字母开始搜索
            for (int j = 0; j < board[i].length; j++) {
                search(board, i, j, tree.root, results);
            }
        }

        return results;
    }
}