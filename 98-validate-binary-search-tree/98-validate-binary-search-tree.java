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
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, long lb, long rb){
        if(root == null) return true;
        
        boolean isBstLeft= helper(root.left, lb, root.val);
        boolean isBstRight= helper(root.right, root.val, rb);
        
        boolean ans = root.val > lb && root.val < rb && isBstLeft && isBstRight;
        
        return ans;
    }
}