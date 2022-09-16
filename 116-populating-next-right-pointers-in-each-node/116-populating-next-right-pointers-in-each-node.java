/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        
        while (!q.isEmpty()){
           int levelNum =  q.size();
              Node tmp = null;
            for(int i =0; i<levelNum; i++){
               Node rem = q.remove();
                if(tmp == null){
                    tmp = rem;
                }else{
                    tmp.next = rem;
                    tmp = tmp.next;
                }
               
                if(rem.left != null) q.add(rem.left);
                if(rem.right != null) q.add(rem.right);
            }
        }
        return root;
    }
}