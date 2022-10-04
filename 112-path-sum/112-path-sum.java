/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            if(targetSum-root.val==0) return true;
        }
        if(root.left != null ){
            boolean ans = hasPathSum(root.left, targetSum-root.val);
            if(ans==true) return true;
        }
        if(root.right != null ){
            boolean ansr = hasPathSum(root.right, targetSum-root.val);
            if(ansr==true) return true;
        }
        return false;
    }
}