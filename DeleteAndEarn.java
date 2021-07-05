class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max = Math.max(nums[i],max);
        }
        int [] buckets = new int[max+1];
        for(int num : nums){
            buckets[num] +=num;
        }
        int dp[] = new int[max+1];
        dp[0] = buckets[0];
        dp[1] = buckets[1];
        for(int i=2;i<buckets.length;i++){
            dp[i] = Math.max(buckets[i]+dp[i-2],dp[i-1]);
        }
        return dp[max];
    }
    public static void main(String[] args){
        DeleteAndEarn d = new DeleteAndEarn();
        int nums[] = {2,2,3,3,3,3,4,4};
        System.out.println(d.deleteAndEarn(nums));
    }
}