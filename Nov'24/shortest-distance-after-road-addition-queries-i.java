// https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/description/

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] ans=new int[queries.length];
        Map<Integer,List<Integer>> m=new HashMap<>();
        for(int i=1;i<n;i++){
            m.put(i,new ArrayList<>(Arrays.asList(i-1)));
        }
        for(int i=0;i<queries.length;i++){
            int[] d=new int[n];
            Arrays.fill(d,n);
            d[0]=0;
            m.get(queries[i][1]).add(queries[i][0]);
            for(int k=1;k<n;k++){
                for(int x:m.get(k)){
                    d[k]=Math.min(d[x]+1,d[k]);
                }
            }
            ans[i]=d[n-1];
        }
        return ans;
    }
}