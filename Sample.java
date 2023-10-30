// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//Delete and Earn
class Solution {
    //Using 1 D Dp
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
        }
        int[] arr = new int[max + 1];
        for(int num : nums){
             arr[num]+= num;
        }

        //Now it is same as robber house
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i=2;i<arr.length;i++){
             dp[i] = Math.max(dp[i-1],arr[i]+ dp[i-2]);

        } 

        return dp[arr.length-1];
    }
}


//Minimum falling path sum
class Solution {
    //Using Recursion
    public int minFallingPathSum(int[][] matrix) {

        int min = Integer.MAX_VALUE;
        for(int i=0;i<matrix[0].length;i++){
            min = Math.min(min,helper(matrix,0,i,0));
        }

        return min;
        
    }
    private int helper(int[][] matrix,int row,int col,int sum){
        //base
        if(row == matrix.length) return sum;

        if(col < 0 || col == matrix[0].length) return Integer.MAX_VALUE;

        //logic
        //choose element directly below diagonal
        int case1 = Integer.MAX_VALUE;
        if(col>= 0 && col<matrix[0].length){
            case1 = helper(matrix,row + 1,col-1,sum + matrix[row][col]);
        }
        //choose element directly below diagonal
        int case2 = Integer.MAX_VALUE;;
        if(col>= 0 && col<matrix[0].length){
            case2 = helper(matrix,row + 1,col,sum + matrix[row][col]);
        }

        //choose element directly below diagonal
        int case3 = Integer.MAX_VALUE;;
        if(col>= 0 && col<matrix[0].length){
            case3 = helper(matrix,row + 1,col+1,sum + matrix[row][col]);
        }

        return Math.min(Math.min(case1,case2),case3);
    }
}
class Solution {
    //Using 2d DP
    public int minFallingPathSum(int[][] matrix) {
        

        //Creating a 2D array matrix
        int noOfrows = matrix.length;

        int noOfColumns = matrix[0].length;

        int[][] dp = new int[noOfrows][noOfColumns];

        //We will fill the last row frst 
        for(int i = 0;i<noOfColumns;i++){
            dp[noOfrows - 1][i] = matrix[noOfrows-1][i]; //filling all the values in the last column with values itself
        }

        for(int i = noOfrows -2 ;i>=0;i--){
            for(int j = 0;j<noOfColumns;j++){
                if(j ==0){
                    dp[i][j] = matrix[i][j]+Math.min(dp[i+1][j],dp[i+1][j+1]);
                }
                else if(j == noOfColumns - 1){
                    dp[i][j] = matrix[i][j]+ Math.min(dp[i+1][j],dp[i+1][j-1]);
                }
                else{
                    dp[i][j] = matrix[i][j]+ Math.min(Math.min(dp[i+1][j],dp[i+1][j-1]),dp[i+1][j+1]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<noOfColumns;i++){
            min = Math.min(min,dp[0][i]);
        }

        return min;
        
    }
    
}



