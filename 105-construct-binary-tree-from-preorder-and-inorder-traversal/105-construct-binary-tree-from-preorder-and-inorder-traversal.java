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
    int preIdx;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIdx = 0;
        return preOrderTraversal(preorder, inorder, 0, preorder.length - 1);
    }
    
    public int findOrderTraversal(int[] inorder, int left, int right, int val){
        while(left <= right){
            if(inorder[left] == val) return left;
            left++;
        }
        return -1;
    }
    public TreeNode preOrderTraversal(int[] preorder, int[] inorder, int left, int right){
        if(left > right) return null;
        
        int rval = preorder[preIdx++];
        TreeNode root = new TreeNode(rval);
        int idx = findOrderTraversal(inorder, left, right, rval);
        
        root.left = preOrderTraversal(preorder, inorder, left, idx-1);
        root.right = preOrderTraversal(preorder, inorder, idx +1, right);
        
        return root;
    }
}