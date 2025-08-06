// By creating a new array of numbers from 0 to max and store the count of numbers
// in this array. Now the problem turns into finding the maximum count in a sub set of array
// such that the if a element chosen to be a part of sub set, then its adjacent elements are not allowed
// to be part of the set and the sum should be maximum.

// Idea is to use DP to store the maximum sum possible for each subset, choose maximum value and
// use it for final evaluation in bottom -up approach.
// Time Complexity - O(n)
// Space Complexity - O(n)

public class DeleteandEarn {

    public int deleteAndEarn(int[] nums){
        int max = 0;

        for(int num:nums)
        {
            max = Math.max(max,num);
        }

        int[] arr = new int[max+1];

        for(int num: nums)
        {
            arr[num] += num;
        }

        int[] dp = new int[max+1];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);

        for(int i=2;i<=max;i++)
        {
            dp[i] = Math.max(dp[i-1], arr[i]+dp[i-2]);
        }
        return dp[max];
    }
}
