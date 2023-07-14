class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return ls(arr,difference,arr.length-1,map);
    }
    public int ls(int[] arr,int diff,int n,HashMap<Integer,Integer> map){
      if(n==0)return 1;
        int notTaken = ls(arr,diff,n-1,map);
        int taken=1;
        if(map.get(arr[n]-diff)!=null)taken=1+map.get(arr[n]-diff);
        else{
            for(int i=n-1;i>=0;i--){
                if(arr[n]-arr[i]==diff){
                    taken=1+ls(arr,diff,i,map);
                    break;
                }
            }
        }
        map.put(arr[n],taken);
        return Math.max(taken,notTaken);
    }
}