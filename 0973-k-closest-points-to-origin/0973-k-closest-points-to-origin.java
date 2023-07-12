class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Point[] point = new Point[points.length];
        PriorityQueue<Point> q = new PriorityQueue<>(new customComparator());
        for(int i=0;i<points.length;i++){
            point[i]=new Point(points[i][0],points[i][1]);
            q.add(point[i]);
        }
        int[][] kpoints = new int[k][2];Point p;
        for(int i=0;i<k;i++){
            p=q.poll();
            kpoints[i][0]=p.x;
            kpoints[i][1]=p.y;
        }
        return kpoints;
    }
    
}

class Point{
    int x;
    int y;
    double dist;
    public Point(){};
    public Point(int x,int y){
        this.x=x;
        this.y=y;
        this.dist=Math.sqrt(x*x+y*y);
    }
}

class customComparator implements Comparator<Point>{
    public int compare(Point p1,Point p2){
        if(p1.dist>p2.dist)return 1;
        if(p1.dist<p2.dist)return -1;
        return 0;
    }
}