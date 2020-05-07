// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//delete and earn
//TC - O(n), SC - 
//SC - O(n)

class Solution {
    public int deleteAndEarn(int[] nums) {
        
        if(nums == null || nums.length ==0)
            return 0;
        int size = Integer.MIN_VALUE;
        
        for(int i : nums)
            size = Math.max(size, i);
        
        int[] temp = new int[size+1];
        
        for(int i=1 ; i<=nums.length; i++){
            temp[nums[i-1]] += nums[i-1];
        }
        
        int[] dp = new int[temp.length];
        dp[0] = temp[0];
        dp[1] = Math.max(temp[0], temp[1]);
        
        for(int i=2; i<dp.length; i++){
            dp[i] = Math.max(temp[i] + dp[i-2], dp[i-1]);
        }
        return dp[dp.length-1];
        
        
        
    }
}

//Minimum Falling Path sum
// TC - O(n^2) SC - O(1)

class Solution {
    public int minFallingPathSum(int[][] A) {
        
        for(int i=1; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                
            if (j==0)
                A[i][j]+= Math.min(A[i-1][j], A[i-1][j+1]);
                
            else if (j==A[0].length-1)
                A[i][j]+= Math.min(A[i-1][j], A[i-1][j-1]);
                
            else
                A[i][j] += Math.min(Math.min(A[i-1][j-1],A[i-1][j+1]), A[i-1][j]);
            
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i : A[A.length-1]){
            if( i < min)
                min = i;
        }
        return min;
    }
}