class Solution {
    public int maxChunksToSorted(int[] arr) {
        HashMap<Integer,Boolean> map = new HashMap<>();
        int ans=0,i=0,j=0,count;
        while(j<arr.length && i<arr.length){
            map.put(arr[j],true);
            count=0;
            for(int k=i;k<=j;k++){
                if(map.getOrDefault(k,false))count++;
            }
            if(count==j-i+1){
                ans++;
                i=j+1;
            }
            j++;
        }
        return ans;
    }
}