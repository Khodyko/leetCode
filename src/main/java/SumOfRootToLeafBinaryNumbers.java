import java.util.ArrayList;
import java.util.List;

public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {

    }

    //You are given the root of a binary tree where each node has a value 0 or 1. Each root-to-leaf path represents a binary number starting with the most significant bit.
    //
    //For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.
    //For all leaves in the tree, consider the numbers represented by the path from the root to that leaf. Return the sum of these numbers.
    //
    //The test cases are generated so that the answer fits in a 32-bits integer.
    //
    //
    //
    //Example 1:
    //
    //
    //Input: root = [1,0,1,0,1,0,1]
    //Output: 22
    //Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
    //Example 2:
    //
    //Input: root = [0]
    //Output: 0
    //
    //
    //Constraints:
    //
    //The number of nodes in the tree is in the range [1, 1000].
    //Node.val is 0 or 1.

    // https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/description/?envType=daily-question&envId=2026-02-24


    public class TreeNode {
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


    public int sumRootToLeaf(TreeNode root) {
        int result = 0;
        List<Integer> str = new ArrayList<>();
        fillList(str, root, new StringBuilder());
        for (Integer i : str) {
            result += i;
        }
        return result;
    }

    public void fillList(List<Integer> intList, TreeNode root, StringBuilder builder) {
        if (root != null) {
            builder.append(String.valueOf(root.val));
        }
        if (root.left == null && root.right == null) {
            if (builder != null && !builder.isEmpty()) {
                intList.add(Integer.parseInt(builder.toString(), 2));
            }
            return;
        }
        if (root.left != null) {
            fillList(intList, root.left, new StringBuilder(builder.toString()));
        }
        if (root.right != null) {
            fillList(intList, root.right, new StringBuilder(builder.toString()));
        }
    }


}
