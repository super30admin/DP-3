// Time Complexity : O(max element in nums)
// Space Complexity : O(max element in nums)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE;

        // get the max element in the array, to create an array of that length
        for(int num: nums){
            max = Math.max(max, num);
        }

        // create an array of length max+1
        int[] arr = new int[max+1];

        // calculate sum of like occurring numbers
        for(int num: nums){
            arr[num] += num;
        }

        int[] dp = new int[max+1];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        // now create dp, start from 2 because we have first 2 values
        for(int i = 2; i <= max; i++){
            //                        case0             , case1
            //dp @ current = Math.max(dp val at previous, current arr value + dp[curr - 2]);
            dp[i] = Math.max(dp[i-1], arr[i] + dp[i-2]);
        }
        return dp[max];
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,2,3,3,3,4};
        int result = deleteAndEarn(nums);
    }
}
