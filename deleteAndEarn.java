//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }

        int[] dp = new int[max+1];

        for(int i = 0; i < nums.length; i++) {
            index = nums[i];
            dp[index] = dp[index] + nums[i];
        }

        int skip = 0;
        int take = 0;
        int temp;
       for(int i = 0; i < max + 1; i++) {
            temp = skip;
            skip = Math.max(skip, take);
            take = dp[i] + temp;
       }

       return Math.max(skip, take);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums = {2,2,3,3,3,4};
        int result = sol.deleteAndEarn(nums);
        System.out.println(result);
    }
}

