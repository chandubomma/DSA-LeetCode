class Solution {
    public int maxJump(int[] stones) {
        int cost=Math.abs(stones[0]-stones[1]);
        for(int i=0;i<stones.length-2;i++){
            if(Math.abs(stones[i]-stones[i+2])>cost)cost=Math.abs(stones[i]-stones[i+2]);
        }
        return cost;
    }
}