class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] scount = new int[mat.length][2];
        int count;
        for(int i=0;i<mat.length;i++){
            count=0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==1)count++;
                else break;
            }
            scount[i][0] = i;
            scount[i][1] = count;
        }
        Arrays.sort(scount,(a,b)->Integer.compare(a[1],b[1]));
        int[] kweak = new int[k];
        for(int i=0;i<k;i++){
            kweak[i] = scount[i][0];
        }
        return kweak;
    }
}