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
    public ListNode removeNodes(ListNode head) {
        ListNode temp=head,prev;
        int len=0,i=0;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        int[] arr = new int[len];
        temp=head;
        while(temp!=null){
            arr[i]=temp.val;
            i++;
            temp=temp.next;
        }
       for(i=len-2;i>=0;i--){
           arr[i]=Math.max(arr[i],arr[i+1]);
       }
        i=0;temp=head;prev=head;
        while(temp.next!=null){
            if(temp==head){
                if(temp.val<arr[i]){
                    head=temp.next;
                    temp=prev=head;
                }else {
                    prev=temp;
                    temp=temp.next;
                }
            }else{
                if(temp.val<arr[i]){
                    prev.next=temp.next;
                    temp=temp.next;
                }else{
                    prev=temp;
                    temp=temp.next;
                }
            }
            i++;
        }
        return head;
    }
}