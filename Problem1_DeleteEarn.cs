// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
public class Solution {
    public int DeleteAndEarn(int[] nums) {
        int maxNum = Int32.MinValue;
        //Find the maximum number in the array nums
        foreach(var num in nums) {
            maxNum = num > maxNum ? num : maxNum;
        }
        int n = maxNum + 1;
        //Create new array of length maxNum
        int[] arr = new int[n];
        //Element at each index is the sum of all the occurances of that index in nums array
        for(int i = 0; i < nums.Length; i++) {
            arr[nums[i]] += nums[i];
        }

        // Iterate through the new array
        int prev = arr[0];
        int curr = Math.Max(prev, arr[1]);
        for(int i = 2; i < n; i++) {
            //Find maximum of previous max (temp) or the sum of current element (arr[i]) and previous alternate max value (prev)
            int temp = curr;
            curr = Math.Max(temp, arr[i] + prev);
            prev = temp;
        }
        return curr;
    }
}
