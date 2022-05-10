Time Complexity : 0(N)
 Space Complexity : 0(n)+ dp array.
Did this code successfully run on Leetcode : yes

/**
 * @param {number[]} nums
 * @return {number}
 */
var deleteAndEarn = function(nums) {
    if(nums.length<2)
     { return nums[0]; }
    var dp=new Array(10001).fill(0);
   for(let i=0;i<nums.length;i++)
   {
       dp[nums[i]]+=nums[i];
   }
   dp[0]=0;
   dp[1]=Math.max(dp[0],dp[1]);
   for(let i=2;i<dp.length;i++)
   {
       dp[i] = Math.max(dp[i-1], dp[i-2]+dp[i]);
   }
   return dp[10000];  
};