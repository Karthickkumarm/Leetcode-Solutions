// https://leetcode.com/problems/maximum-average-pass-ratio/description/ 

class Solution {
    public double maxAverageRatio(int[][] c, int e) {
        int x=0,y=0,n=c.length;
        double tot=0;
        PriorityQueue<double[]> h=new PriorityQueue<>((a,b) -> Double.compare(b[0],a[0]));
        for(int i=0;i<n;i++){
            x=c[i][0];y=c[i][1];
            double p=(double)x/y,q=(double)(x+1)/(y+1);
            h.offer(new double[]{q-p,x,y});
        }
        x=0;y=0;
        while(e>0){
            e-=1;
            double[] t=h.poll();
            x=(int)t[1]+1;y=(int)t[2]+1;
            double p=(double)x/y,q=(double)(x+1)/(y+1);
            h.offer(new double[]{q-p,x,y});
        }
        while(!h.isEmpty()){
            double[] t=h.poll();
            tot+=t[1]/t[2];
        }
        tot/=n;
        return tot;
    }
}