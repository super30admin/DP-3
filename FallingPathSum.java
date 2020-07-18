/**
 *1st: Recursive Approach then Iterative DP
 *
 * Given a square array of integers A, we want the minimum sum of a falling path through A.
 *  A falling path starts at any element in the first row, and chooses one element from each row.
 *  The next row's choice must be in a column that is different from the previous row's column by at most one.
 *
 *  Logic: similar to paint house: each ele is added with the previous most smallest cell eligible and then from the last row the min is returned
 */
// Time Complexity : O(n*3^m) - m is the size of the rows of the given matrix & n is the size of the coln of the gvn matrix
// Space Complexity : O(m) - m is the size of the rows of the given matrix
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums[0].length;i++){
            min = Math.min(min,helper(nums,0,i,0));
        }
        return min;
    }
    private int helper(int[][] nums, int i, int j, int min){
        if(i == nums.length || j == nums[0].length)
            return min;
        int case1 = Integer.MAX_VALUE;
        if(j==0){
            case1 =Math.min(helper(nums,i+1,j,min+nums[i][j]),helper(nums,i+1,j+1,min+nums[i][j]));
        }
        else if(j==nums[0].length-1){
            case1 =Math.min(helper(nums,i+1,j,min+nums[i][j]),helper(nums,i+1,j-1,min+nums[i][j]));
        }else
            case1 = Math.min(helper(nums,i+1,j-1,min+nums[i][j]),
                    Math.min(helper(nums,i+1,j,min+nums[i][j]),helper(nums,i+1,j+1,min+nums[i]                                                                                                        [j])));
        return case1;
    }
}

// Time Complexity :O(m*n) the size of the matrix
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no --similar to paint house


// Your code here along with comments explaining your approach
class Solution {
    public int minFallingPathSum(int[][] nums) {
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<nums[0].length;j++){
                if(j==0){
                    nums[i][j] += Math.min(nums[i-1][j],nums[i-1][j+1]);
                }else if(j == nums[0].length-1){
                    nums[i][j] += Math.min(nums[i-1][j],nums[i-1][j-1]);
                }else
                    nums[i][j] += Math.min(Math.min(nums[i-1][j],nums[i-1][j-1]),nums[i-1][j-1]);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums[0].length;i++)
            min = Math.min(min,nums[nums.length-1][i]);
        return min;
    }
}