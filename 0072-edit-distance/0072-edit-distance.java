class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row:dp)Arrays.fill(row,-1);
        return solve(word1,word2,word1.length()-1,word2.length()-1,dp);
    }
    
    public int solve(String s,String w,int i,int j,int[][] dp){
        if(i<0 || j<0){
            if(i<0 && j<0)return 0;
            else if(i>=0)return i+1;
            else return j+1;
        }
        if(dp[i][j]!=-1)return dp[i][j];
        int deletion = 1+solve(s,w,i-1,j,dp);
        int replace=solve(s,w,i-1,j-1,dp);
        if(s.charAt(i)!=w.charAt(j))replace++;
        int insertion = 1+solve(s,w,i,j-1,dp);
        return dp[i][j]=Math.min(deletion,Math.min(insertion,replace));
    }
}