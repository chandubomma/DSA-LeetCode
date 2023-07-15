class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp =new int[text1.length()][text2.length()];
        for(int[] row : dp)Arrays.fill(row,-1);
        return lcs(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
    
    public int lcs(String text1,String text2,int n1,int n2,int dp[][]){
        if(n1<0 || n2<0)return 0;
        if(dp[n1][n2]!=-1)return dp[n1][n2];
        if(text1.charAt(n1)==text2.charAt(n2))dp[n1][n2]=1+lcs(text1,text2,n1-1,n2-1,dp);
        else dp[n1][n2]=Math.max(lcs(text1,text2,n1,n2-1,dp),lcs(text1,text2,n1-1,n2,dp));
        return dp[n1][n2];
    }
}