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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode root = head;
        ListNode prevNode1 = null;
        int c = k;
        while(root!=null && k>=2){
            root = root.next;
            k--;
        }
        
        ListNode node1 = root;
        root = head;
        
        int count = countNodes(head);
        int node2Pos = count - c + 1;
        ListNode prevNode2 = null;
        while(root!=null && node2Pos>=2){
            root = root.next;
            node2Pos--;
        }
        
        ListNode node2 = root;
        
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
        
        return head;
        
        
    }
    
    int countNodes(ListNode head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
}