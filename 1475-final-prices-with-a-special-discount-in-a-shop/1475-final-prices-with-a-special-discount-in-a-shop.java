class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[prices.length];
        for(int i=prices.length-1;i>=0;i--){
            while(st.size()>0 && st.peek()>prices[i])st.pop();
            if(st.size()>0){
                ans[i] = prices[i]-st.peek();
            }else ans[i] = prices[i];
            st.push(prices[i]);
        }
        return ans;
    }
}