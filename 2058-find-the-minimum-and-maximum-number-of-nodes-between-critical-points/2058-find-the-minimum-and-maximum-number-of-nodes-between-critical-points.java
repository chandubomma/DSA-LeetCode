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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        ans[0]=-1;ans[1]=-1;
        int min=Integer.MAX_VALUE;
        ListNode prev = head,curr=head.next;
        int prevInd=-1,currInd=0,firstInd=-1;
        while(curr.next!=null){
            currInd++;
            if((curr.val>prev.val && curr.val>curr.next.val) ||
              (curr.val<prev.val && curr.val<curr.next.val)){
                if(prevInd!=-1){
                    min = Math.min(min,currInd-prevInd);
                }else firstInd=currInd;
                prevInd=currInd;
            }
            prev=curr;
            curr=curr.next;
        }
        if(prevInd==firstInd)return ans;
        ans[0]=min;
        ans[1]=prevInd-firstInd;
        return ans;
    }
}