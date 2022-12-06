/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
       if(head == null || head.next == null)  return head; 
        
           ListNode d1 = new ListNode(0);
       ListNode d2 = new ListNode(1);
       ListNode p1 = d1;
       ListNode p2 = d2;
       ListNode ptr = head;
       
        boolean flag = true;
       while(ptr != null){
           if(flag== true ){
               p1.next = ptr;
               p1 = p1.next;
           }else{
               p2.next = ptr;
               p2 = p2.next;
           }
           ptr = ptr.next;
           flag = !flag;
       }
       p1.next = null;
       p2.next = null;
       
       p1.next = d2.next;
       
       return d1.next;
    }
}