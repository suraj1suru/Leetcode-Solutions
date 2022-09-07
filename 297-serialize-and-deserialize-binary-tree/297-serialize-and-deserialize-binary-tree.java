/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
     private void serializeHelper(TreeNode root, StringBuilder sb){
     if(root == null){
         sb.append("null ");
          return;
     }     
         sb.append(root.val+" ");
         serializeHelper(root.left, sb);
         serializeHelper(root.right, sb);
     }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] input = data.split(" ");
        this.idx = 0;
        return deserializeHelper(input);
    }
    
    static int idx = 0;
    
    private TreeNode deserializeHelper(String input[]){
        if(idx == input.length) return null;
        
        if(input[idx].equals("null")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(input[idx]));
        idx++;
        node.left = deserializeHelper(input);
        idx++;
        node.right = deserializeHelper(input);
        
        return node;
        
        
        
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));