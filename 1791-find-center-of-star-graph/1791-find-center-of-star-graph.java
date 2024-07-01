class Solution {
    public int findCenter(int[][] edges) {
        int[] e1 = edges[0];
        int[] e2 = edges[1];
        if(e2[0]==e1[0] || e2[0]==e1[1])return e2[0];
        return e2[1];
    }
}