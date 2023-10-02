class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) { 
        if(nums == null || nums.length==0) return 0;
        int max = 0;
        for(int num: nums){
            max = Math.max(num,max);
        }
        int[] arr = new int[max+1];
        for(int num : nums){ // Here we are calculating sum of the numbers.
            arr[num] = arr[num] + num;
        }

        int dp[] = new int[arr.length];
        int dp[1] = arr[1];
        int dp[2] = Math.max(arr[1], arr[2]);

        for(int i=3; i<dp.length; i++){
            dp[i] = Math.max(dp[i-1], nums[i]+dp[i-2]); //Zeroth case lies one step back, for on case it lies two stepback.

        }
        return dp[n-1];   
    }
}