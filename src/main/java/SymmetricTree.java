public class SymmetricTree {

    public static void main(String[] args) {

    }


// https://leetcode.com/problems/symmetric-tree/description/
   public class TreeNode {
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


    public boolean isSymmetric(TreeNode root) {
       return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode left, TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }
        return left.val==right.val && isMirror(left.right, right.left) && isMirror(right.right, left.left);
    }


}
