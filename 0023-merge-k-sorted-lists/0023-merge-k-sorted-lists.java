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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        ListNode head;
        for(int i=0;i<lists.length;i++){
            head=lists[i];
            while(head!=null){
                q.add(head.val);
                head=head.next;
            }
        }
        head=null;
        while(!q.isEmpty()){
            ListNode node = new ListNode(q.poll());
            node.next=head;
            head=node;
        }
        return head;
    }
}