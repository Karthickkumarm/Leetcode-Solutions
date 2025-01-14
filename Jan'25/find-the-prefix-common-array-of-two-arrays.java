// https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/description/

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        Set<Integer> s=new HashSet<>();
        int[] ans=new int[A.length];
        int p=0;
        for(int i=0;i<A.length;i++){
            if(!s.add(A[i])){
                p+=1;
            }
            if(!s.add(B[i])){
                p+=1;
            }
            ans[i]=p;
        }
        return ans;
    }
}