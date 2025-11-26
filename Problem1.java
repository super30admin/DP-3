// Time Complexity : O(N)
// Space Complexity : O(N) ~ where N is the sum Array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
You first find the maximum number and build a sumArray where each index stores the total points earned from taking that number.
Then you treat the problem like House Robber, where choosing a number blocks its neighbors.
Finally, you use DP with prev and curr to compute the maximum points possible without picking adjacent values.
*/

public class Problem1 {
    public int deleteAndEarn(int[] nums) {
        int maxNumber = nums[0];
        int n = nums.length;
        for(int i = 1;i<n;i++) {
            if(maxNumber < nums[i]) {
                maxNumber = nums[i];
            }
        }
        int[] sumArray = new int[maxNumber+1];
        for(int i = 0;i<n;i++) {
            sumArray[nums[i]] += nums[i];
        }

        int prev = sumArray[0];
        int curr = Math.max(sumArray[1], prev);
        for(int i = 2;i<sumArray.length;i++) {
            int temp = curr;
            curr = Math.max(curr, prev + sumArray[i]);
            prev = temp;
        }

        return curr;
    }
}
