
//TC: O(N) N - largest Number in nums
//SC: O(N)
class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer,Integer> sumMap = new HashMap<>();
        int maxNum =0;

        for(int num: nums){
            sumMap.put(num,sumMap.getOrDefault(num,0)+num);
            maxNum = Math.max(maxNum,num);
        }

        int[] dp = new int[maxNum+1];

        dp[0] = 0;
        dp[1] = sumMap.getOrDefault(1,0);

        for(int i=2; i<= maxNum; i++){
            int gain = sumMap.getOrDefault(i,0);
            dp[i] = Math.max(dp[i-1],dp[i-2]+ gain);
        }

        return dp[maxNum];
    }
}