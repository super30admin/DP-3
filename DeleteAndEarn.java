// Time Complexity : O(m) where m is the max element from nums
// Space Complexity : O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        if(nums ==null || nums.length ==0) {
            return -1;
        }

        int max = Integer.MIN_VALUE;

        // Find the max element from nums array
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }

        int []dp = new int [max+1];

        // Fill the dp array(at index i) with the total amount that can be obtained if we pick all elements valued i from nums array
        for (int num : nums) {
            dp[num] = dp[num] + num;
        }

        int skip = 0;
        int take = dp[0];

        // Now the problem has reduced to house robber problem
        // Because if we want to choose ith element in dp array, then we are skipping (i-1)th and (i+1)th element


        // Algo goes like -
        // At every ith element, skip represents if we skip the ith element - we take max of the skip and take from (i-th) element in dp array
        // take represents, if we take the current element, then we need to add the current element value with previous element skip
        // because we can't take i-1th element
        for(int i =0; i<(max+1); i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }

        return Math.max(skip, take);
    }
}
