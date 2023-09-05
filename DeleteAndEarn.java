//TC:O(n+k) SC:O(n+k) k = max num in nums
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        //null
        if(nums == null || nums.length == 0) return 0;
        int max = 0;
        for(int num: nums) {
            max = Math.max(max, num);
        }
        int[] dp = new int[max+1];
        for(int num : nums) {
            dp[num] += num;
        }
        int prev = 0;
        int curr = dp[0];
        for(int i = 1; i < dp.length;i++) {
            int temp = curr;
            curr = Math.max(curr, prev+dp[i]);
            prev = temp;
        } 
        return curr;
    }
}