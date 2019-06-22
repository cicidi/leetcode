package algorithm.tree;

import algorithm.model.TreeNode;

/**
 * @author cicidi on 5/26/19
 * Lintcode 880. Construct Binary Tree from String
 * url https://www.lintcode.com/problem/construct-binary-tree-from-string/description
 * Description
 * 中文
 * English
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 * <p>
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.
 * <p>
 * You always start to construct the left child node of the parent first if it exists.
 * Example
 * Example 1:
 * <p>
 * Input: "-4(2(3)(1))(6(5))"
 * Output: {-4,2,6,3,1,5}
 * Explanation:
 * The output is look like this:
 * -4
 * /  \
 * 2    6
 * / \   /
 * 3   1 5
 * Example 2:
 * <p>
 * Input: "1(-1)"
 * Output: {1,-1}
 * Explanation:
 * The output is look like this:
 * 1
 * /
 * -1
 */

public class ConstructBinaryTreeFromString {
    /**
     * @param s: a string
     * @return: a root of this tree
     */

    int index = 0;

    public TreeNode str2tree(String s) {
        // write your code here

        if (s == null || s.length() == 0) {
            return null;
        }

        // notice 保留sig
        int length = s.length();
        int sig = 1, k = 0; //可以用一个int 设置两个参数
        if (s.charAt(index) == '-') {
            sig = -1;
            index++; // 记得在这里++一次，因为往前走了一步
        }

        //notice 组成数字
        while (index < length && Character.isDigit(s.charAt(index))) {
            k = k * 10 + s.charAt(index) - '0';  //  array to number   k=k*10+A[i];
            index++;  // 前进一步
        }

        //notice 创建新的treeNode
        // notice 当这种情况发生的时候 (index >= length || s.charAt(index) == ')')  那么代表一个node 的描述已经结束， 需要返回了，
        // 如果不是的话，那么就用recursion node.left = 剩下的， node.right = 剩下的“剩下”的
        TreeNode node = new TreeNode(k * sig);  // 要乘以系数
        if (index >= length || s.charAt(index) == ')') {
            index++; //skip 当前的")"
            return node;
        } else {
            index++;  //这个地方要加一次 skip掉 '(''  // 肯定不会给两个左括号
            node.left = str2tree(s);
            if (index >= length || s.charAt(index) == ')') {
                index++; //skip 当前的")"
                return node;  // 加入刚或得了一个left node 又给我一右括号，那么就是让我继续往上放回
            } else {
                index++; //这个地方要加一次 skip掉 '(''  // 肯定不会给两个左括号   如果没有给我右括号，那么我就继续loop
                node.right = str2tree(s);   // 刚才没有右括号让我返回，那么我看看看看有没有有子树
                if (index >= length || s.charAt(index) == ')') {   //这句话其实已经是必然发生的了
                    index++; //skip 当前的")"
                    return node;
                }
            }
        }
        return null;//这个地方给null都可以；
    }
}
