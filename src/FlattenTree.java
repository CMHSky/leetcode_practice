import java.util.ArrayList;

/**
*给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。

 * 示例 1：
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]

 * 示例 2：
 * 输入：root = []
 * 输出：[]

 * 示例 3：
 * 输入：root = [0]
 * 输出：[0]

 * 题号：114

 * 知识点：二叉树，先序遍历
* */

public class FlattenTree {
    ArrayList<TreeNode> nodes = new ArrayList<>();
    public void flatten(TreeNode root) {
        findNode(root);

        for (int i = 0; i < nodes.size() - 1; i++) {
            TreeNode node = nodes.get(i);
            node.left = null;
            node.right = nodes.get(i + 1);
        }
    }

    private void findNode(TreeNode root) {
        if (root == null) {
            return;
        }

        nodes.add(root);
        findNode(root.left);
        findNode(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
