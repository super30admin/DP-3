// Time Complexity : O(N^2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        for(int i = matrix.length - 1; i >= 0; i--){
            for(int j = matrix[0].length - 1; j >= 0; j--){
                if(i != matrix.length - 1){
                    if(j == matrix[0].length - 1)
                        matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                    else if(j == 0)
                        matrix[i][j] += Math.min(matrix[i + 1][0], matrix[i + 1][1]);
                    else
                        matrix[i][j] += Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j - 1], matrix[i + 1][j + 1]));
                }
                if(i == 0)
                    ans = Math.min(ans, matrix[i][j]);
            }
        }
        return ans;
    }
}


//Time complexity: O(N+W) W is the allowable range
//Space complexity: O(W) w is the size of the count

class Solution {
    public int deleteAndEarn(int[] nums) {
        //we have the choice to delete the last element or not delete it
        //also note that it makes sense to group all the same number together
		//let n = number of groups of distinct number
        //dp[n] = Math.max(curr_num * count + (dp[n-1] or dp[n-2]), dp[n-1]);
        //need to sort it first since we are grouping them

        Arrays.sort(nums);

        int[] prev = new int[2];
        int[] cur = new int[2];
        int idx = 0;
        while(idx < nums.length){
            int n = nums[idx];
            int count = 0;
            while(idx < nums.length && nums[idx] == n){count++; idx++;}
            int picked = (n == cur[0] + 1)? n * count + prev[1] : n * count + cur[1]; //if we pick the last element
            int next = Math.max(cur[1], picked); //current max = Math.max(if we pick the last element, or we don't)
            prev = cur;
            cur = new int[]{n, next};
        }

        return cur[1];
    }
}
