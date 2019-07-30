package algorithm.metric;


import java.util.*;

//notice
/*
这道题首先要由一个Tree ，或者叫一个context  他的里面有 Trie， Trie 其实呢是里面带一个Map 的 1对多的树 多叉树？
里面用一个map 对应了每一层的character 和下一层所有character 的node  当character 到了最后一层，保留那个单词
这个是insert 时候要做的

Search 的话  这个是在matric 里面search  所以上下左右走就行了， 当node 里面带着word 给打印出来，没有就继续遍历，知道node
没有子node了
* */
public class WordSaerchII_Mine {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */

    TreeNode treeNode = new TreeNode();

    public static void main(String[] args) {
        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}

        };
        String[] words = new String[]{"oath", "pea", "eat", "rain"};
        WordSaerchII_Mine wordSearchIIJz = new WordSaerchII_Mine();
        List<String> res = wordSearchIIJz.wordSearchII(board, Arrays.asList(words));
        System.out.println("done");
    }

    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> result = new ArrayList<String>();
        if (board.length == 0) {
            return result;
        }

        int rowLength = board.length;
        int colLength = board[0].length;

        init(words);

        for (int row = 0; row < rowLength; row++) {
            for (int col = 0; col < colLength; col++) {
                search(board, treeNode.root, row, col, result);
            }
        }
        return result;
    }

    public void search(char[][] board, Trie trie, int row, int col, List<String> result) {
        if (!trie.children.containsKey(board[row][col])) {
            return;
        }
        trie = trie.children.get(board[row][col]);
        if (trie.word != null) {
            if (!result.contains(trie.word)) {
                result.add(trie.word);
            }
        }
        char tmp = board[row][col];
        board[row][col] = 0;
        if (row - 1 >= 0) {
            search(board, trie, row - 1, col, result);
        }
        if (row + 1 < board.length) {
            search(board, trie, row + 1, col, result);
        }
        if (col - 1 >= 0) {
            search(board, trie, row, col - 1, result);
        }
        if (col + 1 < board[0].length) {
            search(board, trie, row, col + 1, result);
        }
        board[row][col] = tmp;
    }


    public void init(List<String> words) {
        for (String word : words) {
            treeNode.insert(word);
        }
    }

}

/*
* Step
* -. 如何做一个trie
* 1. 又一个context root
* 2 Trie 的结构式  Map<Character,Trie>
* 3. 当进来一个单词，从一个字母开始，往上一层的trie  trie.map.get(char)->Trie if null create new
* 4. 跟treeNode一样，node = node.next
* */

class TreeNode {
    Trie root = new Trie();

    public void insert(String word) {
        Trie node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.children.containsKey(word.charAt(i))) {
                node.children.put(word.charAt(i), new Trie());
            }
            node = node.children.get(word.charAt(i));
        }
        node.word = word;
    }
}

class Trie {
    public String word;
    public Map<Character, Trie> children = new HashMap<>();
}