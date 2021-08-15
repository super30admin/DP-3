class Solution1 {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = 0;
        for (int num : nums){
            max = Math.max(max, num);
        }
        int [] dp = new int[max + 1];
        for(int num : nums){
            dp[num] += num;
        }
        int skip = 0, take = dp[0];

        for (int i = 1; i< dp.length; i++){
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + dp[i];
        }
        return Math.max(skip, take);

    }
}