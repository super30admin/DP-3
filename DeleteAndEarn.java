// Time Complexity : O(3n) to get max ,to form tmp array and to find the prev in house robber or it can be maximum of (max element, max_nums_length)
// Space Complexity : O(n) where n is the maximum element in the array
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// we first convert the given array into an array where the count of each element say 2 is stored at tmp[2]
// since if we select 2 no matter how many 3 or 4s are present we have to delete all of them 
// becuase this can be converted into house robber prob 
class Solution {
    public int deleteAndEarn(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        // create an array with length as the max value
        int[] tmp = new int[getMax(nums) + 1];

        // for a integer i store the total of a particular element in the tmp[i]
        for (int n : nums) {
            tmp[n] += n;
        }

        // House robber
        int prev = 0, prev2prev = 0;
        int placeholder;
        // for each index i in the newly created array we continuously update the prev
        // and prev2prev so if everytime we either choose or not choose the element
        // choose - prev2prev+ tmp[i]
        // not choose prev

        for (int i = 1; i < tmp.length; i++) {
            placeholder = prev;
            prev = Math.max(tmp[i] + prev2prev, prev);
            prev2prev = placeholder;
        }

        return prev;

    }

    // function to return the maximum value in the array
    private int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int n : arr) {
            max = Math.max(max, n);
        }
        return max;
    }
}