// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
APPROACH: Similar to house robber
create a DP array of length: max value of nums[i]+1
Using nums[i] as the index, just score the maximum points that can be encountered on deleting nums[i]
Now I will update this dp array to accumulate the max point encountered at the end by :
choosing the max of the (i-1th, value or i value + i-2 value)
 */
public class DeleteAndEarn {
    // house robber
    public static int deleteAndEarn(int[] nums) {
        int dp[] = new int[10001];
        for(int i=0; i<nums.length; i++){
            dp[nums[i]] += nums[i];
        }

        for(int i=2; i<dp.length; i++){
            dp[i] = Math.max(dp[i-2]+dp[i], dp[i-1]);
        }
        return dp[10000];
    }

    public static void main(String[] args){
        int[] nums = {3,4,2};
        System.out.println(deleteAndEarn(nums)); //6

        int[] nums2 = {2,2,3,3,3,4};
        System.out.println(deleteAndEarn(nums2)); //9
    }
}
