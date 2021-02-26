class DeleteAndEarn {
    
    // Time Complexity: O(n) (where n -> max value in the array)
    // Space Complexity: O(n)
    
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] dp = new int[getMax(nums) + 1];
        
        for(int i : nums){
            dp[i] += i;
        }
        
        int p1 = dp[0];
        int p2 = Math.max(p1,dp[1]);
        for(int i = 2; i < dp.length; i++){
            int temp = p2;
            p2 = Math.max(p2, p1+dp[i]);
            p1 = temp;
        }
        return p2;
    }
    
    private int getMax(int[] nums){
        int maxVal = Integer.MIN_VALUE;
        for(int i: nums)
            maxVal = Math.max(maxVal, i);
        
        return maxVal;
    }
}