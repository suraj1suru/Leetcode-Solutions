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
    public List<Double> averageOfLevels(TreeNode root) {
       List< Double > res = new ArrayList <> ();
       Queue < TreeNode > queue = new LinkedList<>();
       queue.add(root);
        
        while(!queue.isEmpty()) {
            long count = queue.size();
            long sum = 0;
            
            for(long i = 0; i < count; i++){
                TreeNode n = queue.remove();
                sum += n.val;
                
                if(n.left != null) queue.add(n.left);
                if(n.right != null) queue.add(n.right);
            }
            
            res.add(sum * 1.0 / count);
        }
        
        return res;
    }
}



 