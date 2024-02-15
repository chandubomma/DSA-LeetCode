class Solution {
    public String longestPalindrome(String s) {
      char[] arr = s.toCharArray();
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++)dp[i][i]=true;
        boolean temp = isPalindrome(arr,0,s.length()-1,dp);
        if(temp)return s;
        for(int l=s.length()-2;l>0;l--){
            for(int i=0;i<s.length()-l;i++){
                if(dp[i][i+l]!=null && dp[i][i+l])return s.substring(i,i+l+1);
            }
        }
        return s.substring(0,1);
    }
    public boolean isPalindrome(char[] arr,int i,int j,Boolean[][] dp){
        if(i==j || i>j)return true;
        if(dp[i][j]!=null)return dp[i][j];
        if(arr[i]==arr[j])dp[i][j]=isPalindrome(arr,i+1,j-1,dp);
        else dp[i][j]=false;
        isPalindrome(arr,i+1,j,dp);
        isPalindrome(arr,i,j-1,dp);
        return dp[i][j];
    }
}