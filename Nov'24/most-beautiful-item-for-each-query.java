// https://leetcode.com/problems/most-beautiful-item-for-each-query/description/ 

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[][] q=new int[queries.length][2];
        int[] ans=new int[queries.length];
        int m=0,k=0;
        for(int i=0;i<queries.length;i++){
            q[i][0]=queries[i];
            q[i][1]=i;
        }
        Arrays.sort(items,(a,b) -> Integer.compare(a[0],b[0]));
        Arrays.sort(q,(a,b) -> Integer.compare(a[0],b[0]));
        for(int[] a : q){
            int q1=a[0],q2=a[1];
            while(k<items.length && items[k][0]<=q1){
                m=Math.max(items[k][1],m);
                k+=1;
            }
            ans[q2]=m;
        }
        return ans;
    }
}