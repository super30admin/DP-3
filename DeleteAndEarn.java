// Time Complexity : O(max(length(nums), max element in nums))
// Space Complexity : O(max(length(nums), max element in nums),2)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : coming up with the logic of sums array

class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        
        int max = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }

        int[] sums = new int[max+1];

        // create the sums array where index represents the nums element, and its value holds the cumulative sum of that element
        for(int i=0; i<nums.length; i++) {
            int currElement = nums[i];
            sums[currElement] = sums[currElement] + currElement;
        }

        int rows = sums.length;

        int[][] dp = new int[rows][2];

        dp[0][0] = 0;
        dp[1][0] = 0;

        for(int i=1; i<rows; i++) {

            // if sum of cost of current element's cumulative sum and cost of not choosing previous element is greater than cost of choosing previous element, choose the current element
            if((sums[i] + dp[i-1][1]) > dp[i-1][0]) {
                dp[i][0] = sums[i] + dp[i-1][1];
            } else {
                 dp[i][0] = dp[i-1][0];
            }

            // cost of not choosing current element is equal to the cost of choosing the previous element
            dp[i][1] = dp[i-1][0];
        }

        if(dp[rows-1][0] > dp[rows-1][1]) {
            return dp[rows-1][0];
        } else {
            return dp[rows-1][1];
        }

    }    
}