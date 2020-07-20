/* Time complexity : O(max(num)), where max(num) is the highest value of the array
Space complexity : O(max(num))
1. Using dynamic programming to calculate the maximum amount that can be earned using delete and earn.
2. In this approach, a new array of size 0 to max(num)-1 is created and updated with values present in given array depending on whether the element present in corresponding index is present of or. If present twice, we add it twice and place it at that particular index and if not present, put zero.
3. To do it with dynamic programming, we create a table with each elements in the new array bas row elements and 0 or 1 as column elements.

*/ 

class Solution{
    public int deleteAndEarn(int[] nums){
        if(nums == null || nums.length){
            return 0;
        }
        int m = -99999;
        for(int i=0; i<nums.length; i++){
            m = Math.max(m, nums[i]);
        }

        int[] earned = new int[m+1];
        for(int n: nums){
            earned[n] += n;
        }
        int[][] dp = new int[m+1][2];
        for(int i=1; i<=m; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
            dp[i][1] = earned[i] + dp[i-1][0];

        }
        return Math.max(dp[m][0], dp[m][1]]);
    }
}