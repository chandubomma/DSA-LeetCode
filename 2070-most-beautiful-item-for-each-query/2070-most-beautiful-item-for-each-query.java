class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Item[] its = new Item[items.length];
        for(int i=0;i<items.length;i++){
            its[i] = new Item(items[i][0],items[i][1]);
        }
        Arrays.sort(its,(a,b)->Integer.compare(a.price,b.price));
        int max=Integer.MIN_VALUE;
        for(int i=0;i<its.length;i++){
            max = Math.max(max,its[i].beauty);
            its[i].maxBeauty=max;
        }
        int[] ans = new int[queries.length];
        int l,h,mid;
        for(int i=0;i<queries.length;i++){
            l=0;
            h=its.length-1;
            while(l<=h){
                mid=(l+h)/2;
                if(its[mid].price<=queries[i]){
                    ans[i]=its[mid].maxBeauty;
                    l=mid+1;
                }else h=mid-1;
            }
        }
        return ans;
    }

}


class Item{
    int price;
    int beauty;
    int maxBeauty;
    public Item(int price,int beauty){
        this.price = price;
        this.beauty = beauty;
    }
}