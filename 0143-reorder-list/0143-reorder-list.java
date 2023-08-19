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
    public void reorderList(ListNode head) {
        int len = 0;
        ListNode temp = head,temp2;
        Stack<ListNode> stack = new Stack<>();
            while(temp!=null){
                stack.push(temp);
                temp=temp.next;
                len++;
            }
        int i=0;
        temp=head;
        while(i<=len/2){
            temp2 = stack.pop();
            temp2.next = temp.next;
            temp.next = temp2;
            temp=temp2.next;
            i++;
        }
        temp.next=null;
    }
}