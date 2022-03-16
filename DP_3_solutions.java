// Time Complexity : 1- O(n)   2 - O(m*n)
// Space Complexity : 1 - O(1)  2 - O(m*n)  -m*n - size of matrix
// Did this code successfully run on Leetcode : 1 - Yes  2 - Yes


// Your code here along with comments explaining your approach
class Solution1 {
    public int deleteAndEarn(int[] nums) {
        if(nums == null) return 0;
        int max = 0;
        
        for(int num:nums) {
            max = Math.max(num, max);
        }
        
        int[] arr = new int[max+1];
        
        for(int i=0; i < nums.length; i++) {
            arr[nums[i]] += nums[i];
        }
        
        int skip = 0, take = 0;
        for(int i=1; i < arr.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];
        }
        return Math.max(skip, take);
    }
}

class Solution2 {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n == 1) return matrix[0][0];
        
        for(int i=n-2; i>=0; i--) {
            for(int j=0; j<n; j++) {
                if(j==0) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j+1]);
                }
                else if(j==n-1) {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j], matrix[i+1][j-1]);
                }
                else {
                    matrix[i][j] = matrix[i][j] + Math.min(matrix[i+1][j],                                                                                                 Math.min(matrix[i+1][j-1], matrix[i+1][j+1]));
                }
            }
        }
        int minimum = Integer.MAX_VALUE;
        for(int mini: matrix[0]) {
            minimum = Math.min(mini, minimum);
        }
        return minimum;
    }
}