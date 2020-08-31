//Time complexity: O(N)
//Space complexity:(N);

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0 || nums == null)
            return 0;

        int max = Arrays.stream(nums).max().getAsInt();
        int dp[] = new int[max + 1];
        for (int num : nums) {

            dp[num] += num;
        }
        int C = 0;
        int DC = 0;

        for (int i = 0; i < dp.length; i++) {

            int t = DC;
            DC = Math.max(C, DC);
            C = t + dp[i];
        }

        return Math.max(C, DC);
    }
}