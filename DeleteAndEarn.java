/*TC : O(n) where N maximum of max Element in the array and the length of the array
SC : O(N) array to store values
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 */
public class DeleteAndEarn {

    /*
    The approach here taken is that we maintain an array where we store the frequency*element at index=element.
    Then we start iterating the array and at every index update the value by taking max among sum[i-1] & sum[i-2] + sum[i]
    as one is the case where we choose the element and other is the case where we skip the element.
    So, value at every index is the max value we can get at the index.
     */
    public int deleteAndEarn(int[] nums) {
        int[] sum = new int[10002];

        for(int i = 0; i < nums.length; i++)
        {
            sum[nums[i]] += nums[i];
        }

        for(int i = 2; i < sum.length; i++)
        {
            sum[i] = Math.max(sum[i-1], sum[i-2] + sum[i]);
        }
        return sum[10001];
    }
}
