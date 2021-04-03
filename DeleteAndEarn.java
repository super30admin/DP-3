    /*
     *  Time Complexity: O(N+M) Where N is the size of nums array and M is the range of values in nums.
     *  Space Complexity: O(M) where M is the range of values in nums.
     *
     *  Did this code successfully run on Leetcode : Yes
     *  Any problem you faced while coding this : Design the approach to hold the min element.
     *
     *  Explanation:We need to first find the max element in the nums array. Then we create a dp array of max element size. For each index in the dp array we store the corresponding sum of all the occurance of that index in the nums array. Once we have the dp array filled we simply need to find the max sum skipping the next index, similar to the paint house problem. 
     */
    class Solution {
        public int deleteAndEarn(int[] nums) {
            if(nums==null||nums.length==0) return 0;

            int maxValue=Integer.MIN_VALUE;
            for(int i=0;i<nums.length;i++){
                maxValue=Math.max(maxValue, nums[i]);            
            }

            int dp[]=new int[maxValue+1];
            for(int i=0;i<nums.length;i++){
                dp[nums[i]]+=nums[i];
            }

            int prev=dp[0], curr=dp[1];
            for(int i=2;i<dp.length;i++){
                int temp= curr;
                curr=Math.max(curr, prev+dp[i]);
                prev=temp;
            }
            return curr;
        }
    }
