class Solution {
    // TC -> For loop for max + For Loop for HashMap + For Loop for DP
    //      = 2 * O(N) + O(max(nums)) = MAX (N, max(nums)) where N is the length of nums
    // SC -> O(max(nums))
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int res = 0;

        // Find the maximum in the nums
        int max = Integer.MIN_VALUE;
        for(int i=0; i< nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        // A 2D DP - max vs 2 (0 & 1)
        /** Eg: [2,2,5,5,5,1,1,4] max = 4

            points      total       0           1
            0           0           0           0
            1           2           0           2
            2           4           max(0,2)    0 + 4
            3           0           max(2,4)    2 + 0
            4           4           max(4,2)    4+4
            5           15          max(4,8)    4+15
                                    
            So dp[i][0] = max(dp[i-1][0], dp[i-1][1])
            && dp[i][1] = dp[i-1][0] + total

            So we need to save total in a hashmap
         */

        // Store points vs total
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], nums[i]);
            }else{
                int sum = map.get(nums[i]) + nums[i];
                map.put(nums[i],sum);
            } 
        }

        int[][] dp = new int[max+1][2];
        //Create DP and calculate res
        for(int i=0; i<=max; i++){
            if(i==0){
                dp[i][0] = 0;
                dp[i][1] = 0;
            }
            else{
                dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
                if(map.containsKey(i))
                    dp[i][1] = map.get(i) + dp[i-1][0];
                else
                    dp[i][1] = dp[i-1][0];
                res = Math.max(res, Math.max(dp[i][0], dp[i][1]));
            }
        }
        return res;
    }
}
