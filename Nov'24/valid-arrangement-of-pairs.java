//https://leetcode.com/problems/valid-arrangement-of-pairs/description/

class Solution {
    public int[][] validArrangement(int[][] p) {
        Map<Integer,Integer> d=new HashMap<>();
        Map<Integer, List<Integer>> g=new HashMap<>();
        List<Integer> ans= new ArrayList<>();
        Deque<Integer> ss=new ArrayDeque<>();
        int s=p[0][0];
        for(int[] k :p){
            int x=k[0],y=k[1];
            g.computeIfAbsent(x,t->new ArrayList<>()).add(y);
            d.put(x,d.getOrDefault(x,0)+1);
            d.put(y,d.getOrDefault(y,0)-1);
        }
        for(Map.Entry<Integer,Integer> k:d.entrySet()){
            if(k.getValue()==1){
                s=k.getKey();break;
            }
        }
        ss.push(s);
        while(!ss.isEmpty()){
            int n=ss.peek();
            if(g.containsKey(n) && !g.get(n).isEmpty()){
                ss.push(g.get(n).remove(g.get(n).size()-1));
            }else{
                ans.add(ss.pop());
            }
        }
        int[][] a=new int[ans.size()-1][2];
        Collections.reverse(ans);
        for(int i=0;i<ans.size()-1;i++){
            a[i][0]=ans.get(i);
            a[i][1]=ans.get(i+1);
        }
        return a;
    }
}