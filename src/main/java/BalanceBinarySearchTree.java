import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree {
    public static void main(String[] args) {

    }


    //   Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        fillList(root, list);
        return prepareBalancedTree(list, 0, list.size() - 1);
    }

    public static void fillList(TreeNode root, List<Integer> list) {
        if(root==null) return;
        fillList(root.left, list);
        list.add(root.val);
        fillList(root.right, list);
    }

    public static TreeNode prepareBalancedTree(List<Integer> list, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right + left) / 2;
        TreeNode node = new TreeNode();
        node.val=list.get(mid);
        node.left = prepareBalancedTree(list, left, mid - 1);
        node.right = prepareBalancedTree(list, mid + 1, right);
        return node;
    }


}
