class Solution {
    public int numberOfPairs(int[][] points) {
        int a,b,c,d,e,f,count=0;
        boolean flag=true;
        for(int i=0;i<points.length;i++){
            a=points[i][0];
            b=points[i][1];
            for(int j=0;j<points.length;j++){
                c=points[j][0];
                d=points[j][1];
                if(i==j || c<a || d>b)continue;
                flag=true;
                for(int k=0;k<points.length;k++){
                    if(k==i || k==j)continue;
                    e=points[k][0];
                    f=points[k][1];
                    if((e<=c && e>=a) && (f>=d && f<=b)){
                        flag=false;
                        break;
                    }
                }
                if(flag)count++;
            }
        }
        return count;
    }
}