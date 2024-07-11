class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int i=0,j=1,cnt=0,prev=0,ans=1;
        while(j<s.length()){
            if(s.charAt(j)==s.charAt(j-1)){
                if(cnt==0){
                    cnt++;
                    prev=j;
                }else {
                    ans = Math.max(ans,j-i);
                    i=prev;
                    prev=j;
                }
            }
            j++;
        }
        ans = Math.max(ans,j-i);
        return ans;
    }
}