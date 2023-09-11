// Time Complexity : O(n * k) where n is the number of elements in num and k is the maxValue in num
// Space Complexity : O(k) we store maxpoints for all elements upto k
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class Problem1 {
    public int deleteAndEarn(int[] nums) {
        //base case
        if(nums.length == 0 || nums == null) return 0;

        HashMap<Integer, Integer> points = new HashMap<>();
        int maxValue = 0;

        for(int num : nums){
            points.put(num, points.getOrDefault(num, 0) + num);
            maxValue = Math.max(maxValue, num);
        }

        int dp[] = new int[maxValue+1];
        dp[1] = points.getOrDefault(1, 0);

        for(int i = 2; i < maxValue+1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+points.getOrDefault(i, 0));
        }

        return dp[maxValue];

    }

}
