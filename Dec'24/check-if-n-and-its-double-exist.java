// https://leetcode.com/problems/check-if-n-and-its-double-exist/description/

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> a=new HashSet<>();
        for(int i:arr){
            if(a.contains(i*2) || (i%2==0 && a.contains(i/2))){
                return true;
            }
            a.add(i);
        }
        return false;
    }
}