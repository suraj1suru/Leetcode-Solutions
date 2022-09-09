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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
         if(root == null) return ans;
        q.add(root);
        
       
        
        while(q.size() > 0){
            int s = q.size();
            
            while(s > 0){
                TreeNode rem = q.remove();
                if(s == 1) ans.add(rem.val);
                
                if(rem.left != null) q.add(rem.left);
                if(rem.right != null) q.add(rem.right);
                
                s--;
            }
        }
       return ans;
    }
}