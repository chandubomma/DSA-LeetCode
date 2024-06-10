class Solution {
    public int heightChecker(int[] heights) {
        int[] copy = new int[heights.length];
        int ans=0;
        for(int i=0;i<heights.length;i++)copy[i]=heights[i];
        Arrays.sort(copy);
        for(int i=0;i<heights.length;i++){
            if(copy[i]!=heights[i])ans++;
        }
        return ans;
    }
}