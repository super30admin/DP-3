//Time complexity is O(max(nums))
//Space complexity is O(max(nums))

class Solution {
    public int deleteAndEarn(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] dp = new int[max + 1];

        for (int i = 0; i < nums.length; i++) {
            dp[nums[i]] = dp[nums[i]] + nums[i];
        }

        int doNotChooseCase = 0;
        int chooseCase = 0;

        for (int i = 0; i < dp.length; i++) {
            int temp = doNotChooseCase;
            doNotChooseCase = Math.max(doNotChooseCase, chooseCase);
            chooseCase = temp + dp[i];
        }

        return Math.max(chooseCase, doNotChooseCase);

    }
}