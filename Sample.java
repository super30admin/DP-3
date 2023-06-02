
//DP-3 problem1
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int[] arr = new int[max + 1];
        for(int i=0; i<nums.length; i++){
            arr[nums[i]] +=nums[i];
        }
        int skip = 0;
        int take = arr[0];
        for(int i=1; i<arr.length; i++){
            int temp = skip;
            //skip
            skip = Math.max(skip,take);
            //take
            take = temp + arr[i];
        }
        return Math.max(skip,take);
    }
}
//DP-3 problem 2
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int [][] grid = matrix;
        if(grid == null || grid.length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = n-2; i>=0; i-- ){
            for(int j = 0; j < m; j++){
                if(j == 0){
                    grid[i][0] += Math.min(grid[i+1][0],grid[i+1][1]);
                }else if(j == m-1){
                    grid[i][m-1] += Math.min(grid[i+1][m-1],grid[i+1][m-2]);
                }else{
                    grid[i][j] += Math.min(grid[i+1][j-1],
                                           Math.min(grid[i+1][j],grid[i+1][j+1]));                         }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0; j<n; j++){
            min = Math.min(min,grid[0][j]);
        }
        return min;
     
    }
}
