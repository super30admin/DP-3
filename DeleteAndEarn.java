/*
* Approach:
*  1. First, we try to find the frequency of the elements using counting sort.
* 
*  2. Now, we are having number in the sorting order along with frequency.
        Therefore, we start from the last and try to choose or not choose.
* 
*  3. After counting sort, this is similar to house robber problem.
        We optimize by applying DP.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
* 
* Space Complexity: O(max_value)
    auxilary array used for frequency and as dp array.
* 
*/
public class DeleteAndEarn {
    // private int deleteAndEarn(int[] arr, int index) {
    // if (index < 0) {
    // return 0;
    // }

    // return Integer.max(
    // deleteAndEarn(arr, index - 1),
    // arr[index] + deleteAndEarn(arr, index - 2));
    // }

    public int deleteAndEarn(int[] nums) {
        int range = Integer.MIN_VALUE;

        for (int num : nums)
            range = Integer.max(range, num);

        int[] freqArr = new int[range + 1];

        for (int num : nums) {
            if (freqArr[num] != 0)
                freqArr[num] += num;
            else
                freqArr[num] = num;
        }

        // return deleteAndEarn(freqArr, range);

        // tabulation
        int[] dp = new int[range + 1];

        for (int index = 1; index <= range; index++) {
            if (index >= 2)
                dp[index] = Integer.max(dp[index - 1],
                        freqArr[index] + dp[index - 2]);
            else
                dp[index] = Integer.max(dp[index - 1], freqArr[index]);
        }

        return dp[range];
    }
}
