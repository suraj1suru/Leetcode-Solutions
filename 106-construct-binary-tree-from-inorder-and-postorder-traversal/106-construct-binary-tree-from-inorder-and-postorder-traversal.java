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
    int postIdx;
    HashMap<Integer, Integer> hm ;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         hm  = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
         hm.put(inorder[i], i);
        }
        postIdx = postorder.length - 1;
        return postorderTraversal(postorder ,0, postorder.length - 1);
    }
    
    
        public TreeNode postorderTraversal(int[] postorder ,int left, int right){
        if(left > right) return null;
        
        int rval = postorder[postIdx--];
        TreeNode root = new TreeNode(rval);
        int idx = hm.get(rval);
        
       root.right = postorderTraversal(postorder,  idx +1, right);     
        root.left = postorderTraversal(postorder,  left, idx-1);
        
        
        return root;
    }
}