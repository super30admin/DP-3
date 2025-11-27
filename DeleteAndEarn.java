// Time Complexity : O(Max(max element in array, length of array) => O(n) average
// Space Complexity : O(max element in array)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        // find Max element in the array
        int max = Integer.MIN_VALUE;
        for(int num: nums){
            max = Math.max(max, num);
        }

        // create sum array
        int[] arr = new int[max + 1];
        for(int num: nums){
            arr[num] += num;
        }

        // using prev, curr pointers to maintain max variable
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for(int i=2; i<arr.length; i++){
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev);
            prev = temp;
        }
        return curr;
    }
}