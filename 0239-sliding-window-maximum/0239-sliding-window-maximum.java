class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] maxArray = new int[n-k+1];
        PriorityQueue<Num> queue = new PriorityQueue<>(new CustomComparator());
        for(int i=0;i<k-1;i++)queue.add(new Num(nums[i],i));
        for(int i=0;i<=n-k;i++){
            queue.add(new Num(nums[i+k-1],i+k-1));
            while(queue.peek().index<i)queue.poll();
            maxArray[i]=queue.peek().val;
        }
        return maxArray;
    }
    
    class Num{
        Integer val;
        int index;
        public Num(int val,int index){
            this.val=val;
            this.index=index;
        }
    }
    
class CustomComparator implements Comparator<Num> {

  @Override
  public int compare(Num num1, Num num2) {
    int value = num1.val.compareTo(num2.val);

    // Reverse ordering
    if (value > 0) {
      return -1;
    } else if (value < 0) {
      return 1;
    } 

    return 0;
  }
}
}