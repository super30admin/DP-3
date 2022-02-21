// Time Complexity : O(M) where M = maximum number in the nums array
// Space Complexity : O(M) where M = maximum number in the nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Problem1 {

    public static int deleteAndEarn(int[] nums) {
        // To make the problem similar to House Robber, 
        // I make a temp array with index from 0 to maximum number in nums array
        int maxm = Integer.MIN_VALUE;
        for (int num:nums) {
            maxm = Math.max(maxm, num);
        }
        int[] temp = new int[maxm+1];
        // Initially all values in temp array is 0
        // Set value at index of temp array to total sum of elements equal to index in nums array
        for (int num: nums) {
            temp[num]+=num;
        }        
        int[] dp = new int[temp.length + 2];
        for (int i = temp.length-1; i >= 0; i--) {
            // If I select the present element, add value at present index to value for index+2
            int select = temp[i] + dp[i+2];
            // If I don't select the present element, the value is equal to the value for index+1
            int notselect = dp[i+1];
            // Set the calculated value (max of select and notselect) at corresponmding index in the dp array
            dp[i] = Math.max(select, notselect);
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,2};
        int ans = deleteAndEarn(nums);
        System.out.println(ans);
    }
}