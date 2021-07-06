// Time Complexity : O(n + max(val))
// Space Complexity : O(max*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        // look for the maximum value in the array to an array that has accumulative sum of elements in the nums array and store it to their respective indices
        for(int i: nums){
            if(i > max){
                max = i;
            }
        }
        
        int[] sum = new int[max+1];
        for( int i=0; i< nums.length; i++){
            sum[nums[i]] += nums[i];  
        }
        
        int[][] dp = new int[sum.length][2];
        dp[0][0] = 0; // Initially the profit to be made is 0 when the first element is ignored. [0][0] is the skip col
        dp[0][1] = sum[0]; // if the element is not ignored, it will has its value in the dp array's 'accept' columns
        for(int i=1; i< sum.length; i++){ // starting from one because we have already made a decision for the 1st row/col
            
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]); // if skipping the current element, take whatever we have profitted so far
            dp[i][1] = sum[i] + dp[i-1][0]; // if accepting the cur elmnt, choose its cur val and the val from the col when the previous value was skipped                  
        }
        
        return Math.max(dp[dp.length-1][0],dp[dp.length-1][1] );
        
    }
}

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    public int minFallingPathSum(int[][] A) {
        
        for(int i=1; i< A.length; i++){
            for(int j=0; j < A[0].length; j++){
                
                //starting col
                if(j == 0){
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j+1]);

                }else if(j == A[0].length-1){ // end col
                    A[i][j] = A[i][j] + Math.min(A[i-1][j], A[i-1][j-1]);
                }else{  // every col in between
                    A[i][j] = A[i][j] + Math.min( A[i-1][j], Math.min(A[i-1][j-1], A[i-1][j+1]));
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for( int i=0; i< A[0].length; i++){
            int cur = A[A.length-1][i];
            
            if( cur < min){
                min = cur;
            }
        }
        return min;
        
    }
}
