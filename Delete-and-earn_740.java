// Time Complexity :O(n) : where n = nums.length
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//converted this question to house robber problem by taking a freq array from 0 till Max element in nums
//dp[i] = Math.max(dp[i-1], dp[i-2] + freqArr[i]*i)
class Solution {
    public int deleteAndEarn(int[] nums) {

        if(nums.length<2) return nums[0];
        int maxNum = 0;
        for(int n : nums) {
            maxNum = Math.max(maxNum, n);
        }
        int[] numsFreq = new int[maxNum+1];
        for(int n : nums) {
            numsFreq[n] += 1;
        }

        int prevPrev = numsFreq[1];
        int prev = Math.max(prevPrev, numsFreq[2]*2);

        int curr = prevPrev;
        for (int i=3; i<=maxNum; i++) {
            curr = Math.max(prevPrev + (numsFreq[i]*i), prev);
            prevPrev=prev;
            prev=curr;
        }
        return curr;
    }
}
