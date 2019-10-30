package tree;

import model.TreeNode;

import java.util.*;

public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
//        TreeNode t3 = new TreeNode(3);
//        TreeNode t9 = new TreeNode(9);
//        TreeNode t20 = new TreeNode(20);
//        TreeNode t15 = new TreeNode(15);
//        TreeNode t7 = new TreeNode(7);
//
//        t3.left = t9;
//        t3.right = t20;
//        t20.left = t15;
//        t20.right = t7;

        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t1.left = t2;
        t2.right = t6;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        t5.left = t7;
        t5.right = t8;
//        System.out.println(t3);
        SerializeAndDeserializeBinaryTree s = new SerializeAndDeserializeBinaryTree();
        System.out.println(s.serialize(t1));
        System.out.println(s.deserialize(s.serialize(t1)));


    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "{}";
        }

        List<String> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode tmp = q.poll();
            if (tmp == null) {
                list.add("#");
            } else {
                list.add(String.valueOf(tmp.val));
                q.add(tmp.left);
                q.add(tmp.right);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int index = 0; index < list.size(); index++) {
            sb.append(list.get(index));
            sb.append(",");
        }

        int length = sb.toString().length();
        String tmp = sb.toString();
        for (int index = length - 2; index >= 0; ) {
            if (tmp.substring(index, index + 2).equals("#,")) {
                tmp = sb.substring(0, index);
            } else {
                break;
            }
            index -= 2;
        }

        return tmp.substring(0, tmp.length() - 1) + "}";
    }

    // 正确答案
    public TreeNode deserialize(String data) {
        if (data.equals("{}")) {
            return null;
        }
        String[] vals = data.substring(1, data.length() - 1).split(",");
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.add(root);
        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < vals.length; i++) {
            if (!vals[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
                if (isLeftChild) {
                    queue.get(index).left = node;
                } else {
                    queue.get(index).right = node;
                }
                queue.add(node);
            }
            if (!isLeftChild) {
                // important 这个地方画图理解
                // treeNode serialize 以后变成这样的
                //{1,2,3,#,6,4,5,#,#,#,#,7,8}
                //    {1,2,3,(#),6,4,5,#,#,#,#,7,8 这个是string 表达式
                //    [1,2,3,    6,4,5         7,8] 这个是ArrayList
                //        |     |   |   |   |   |
                //对应    (1)  (2)  (3) (6) (4) (5)
                //index   0    1    2   3   4   5
                index++;
            }
            //有left 就一定有right， 所以每一次loop 这个flag 都切换一次
            isLeftChild = !isLeftChild;
        }
        return root;
    }

    // 这个是我自己写的，是错的
//    public TreeNode deserialize(String[] str, int index) {
//        if (index >= str.length)
//            return null;
//        if (str[index].equals("#")) {
//            return null;
//        }
//        TreeNode root = new TreeNode(Integer.valueOf(str[index]));
//        TreeNode left = deserialize(str, index + 1);
//        TreeNode right = deserialize(str, index + 2);
//        root.left = left;
//        root.right = right;
//        return root;
//    }

}
