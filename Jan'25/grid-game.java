//https://leetcode.com/problems/grid-game/description/ 
class Solution {
    public long gridGame(int[][] grid) {
        long up=0,down=0;
        for(int i :grid[0]){
            up+=i;
        }
        for(int i=0;i<grid[0].length-1;i++){
            up-=grid[0][i];down+=grid[1][i];
            if(down>=up){
                return Math.max(up,down-grid[1][i]);
            }
        }
        return down;
    }
}