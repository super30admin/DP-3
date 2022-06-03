// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : I am stuck with creating hashmap
// and traverse in hashmap

class Main {

    public static int deleteAndEarn(int[] nums) {

        // initial size of hashmap;
        int n = 10001;
        int[] map = new int[n];

        // store values*frequency in map.
        for (int i = 0; i < nums.length; i++) {
            map[nums[i]] += nums[i];
        }
        // here conditon given that we are going to delete nums[i]+ 1 and nums[i] - 1
        // in map array it means we cannot select consecutive index values as our final
        // answer
        // dp array
        int[] dp = new int[n];
        // intial dp value.
        dp[0] = map[0];
        for (int i = 1; i < n; i++) {
            // take at perticular index
            int take = map[i];

            // if we not Take value at this index we can add previos index value.
            int notTake = 0 + dp[i - 1];

            // if index > 1 we are adding previous previos value as it is not consider as
            // consecutive number
            if (i > 1)
                take += dp[i - 2];

            // store it in current dp array
            dp[i] = Math.max(take, notTake);
        }
        // return final value
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 3, 3, 4 };
        System.out.println("maximum amount is: " + deleteAndEarn(nums));
    }
}
