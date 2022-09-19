class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        if(root == null) return root;
        Queue<TreeNode> q = new LinkedList<>();
        int level = -1;
        q.add(root);
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            TreeNode[] arr = new TreeNode[size];// creating the treeNode array from which i can easily swap the node values.
            
            for(int i = 0; i < size; i++){
                TreeNode temp = q.poll();
                if(temp.left != null){
                    q.add(temp.left);
                }
                if(temp.right != null){
                    q.add(temp.right);
                }
                arr[i] = temp;
            }
            
            if(level % 2 != 0){
                reverse(arr);
            }
        }
        return root;
    }
    public void reverse(TreeNode[] arr){
        int i = 0, j = arr.length - 1;
        while(i < j){
            int temp = arr[i].val;
            arr[i].val = arr[j].val;
            arr[j].val = temp;
            i++;
            j--;
        }
    }
}