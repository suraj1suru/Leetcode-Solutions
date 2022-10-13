/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //so i am assigning givin node to = to next node value
        node.val  = node.next.val;
        //and i am doing assign the address to next node to current node
        node.next = node.next.next;
    }
}