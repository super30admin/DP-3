// Time Complexity : O (n) where n would be bounded to the maxVal in Nums array
// Space Complexity : O(maxVal in Nums)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// We preprocess the input data by finding the maximum value in the nums array, which helps in determining the size of the auxiliary arrays needed. It iterates through the nums array to calculate the sum of elements with the same value and stores them in the sum array.
// Next, the code initializes a dp array, of the same size as sum, which will store the maximum points that can be earned up to a particular element. Then, the code iterates from index 2 to the maximum value (maxVal) and calculates the maximum points that can be earned up to that element

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        int[] sum = new int[maxVal + 1];
        for (int num : nums) {
            sum[num] += num;
        }

        // Simple HouseRobber logic now
        int[] dp = new int[maxVal + 1];
        dp[0] = 0;
        dp[1] = sum[1];

        for (int i = 2; i <= maxVal; i++) {
            dp[i] = Math.max(dp[i - 2] + sum[i], dp[i - 1]);
        }

        return dp[maxVal];

    }

    public static void main(String[] args) {
        DeleteAndEarn obj = new DeleteAndEarn();
        int[] nums = { 2, 2, 3, 3, 3, 4 };
        System.out.println(" Maximum amount possible: " + obj.deleteAndEarn(nums));
    }
}
