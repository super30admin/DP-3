//Time Complexity : O(maximum number in the given array)
//Space Complexity : O(maximum number in the given array) 
//executed on leetcode: yes
//issues faced : no
/*Approach
1.taking a array and grouping the earnings into that the size of the array would be max of nums + 1, so that we can group the earnings os same value as well as delete numerical neighbours
2. we will make a dp array to store the earnings gained till now based on the conditions : 
-dp[i][0] ---> if we are taking an element we have to add its earning and the value gained by not taking its numerical neighbour
-dp[i][1]----->if we are not taking an element then max of what we can get by taking its previous numerical neighbour
*/

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==0) return 0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;++i) max = Math.max(max,nums[i]);
        int[] earned = new int[max+1];
        for(int num : nums) earned[num]+=num;
        int[][] dp = new int[max+1][2];
        dp[0][0] = 0;
        dp[0][1] = 0;
        for(int i=1;i<dp.length;++i)
        {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1] = earned[i] + dp[i-1][0];
        }
        return Math.max(dp[max][0],dp[max][1]);
    }
}