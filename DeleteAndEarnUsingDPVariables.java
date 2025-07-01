// Time Complexity: O(n) + O(max(n))
// Space Complexity: O(max(n))
//    - For frequency array and DP array of size (max + 1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Your code here along with comments explaining your approach:
// - DP approach with variables
// - First, convert the nums array into a frequency array `arr` where arr[i] holds the total points you can get by selecting number i.
// - Use two variables `prev` and `curr` to keep track of maximum points till (i-2) and (i-1) respectively.
// - For each i from 2 to max:
//     - Either skip i → curr stays the same.
//     - Or pick i → arr[i] + prev.
//     - Choose the max of the two.
// - Return `curr` as the maximum points achievable.
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n = nums.length;

        //Loop to find the max value in the array
        int max = 0;
        for(int num : nums){
            max = Math.max(max,num);
        }

        //Create the frequency array
        int[] arr = new int[max+1];
        //Find the frequiencies
        for(int num : nums){
            arr[num] += num;
        }

        //Populate the dp variables
        int prev = arr[0];
        int curr =  arr[1];
        for(int i=2; i<=max; i++){
            int temp = curr;
            curr = Math.max(curr,arr[i]+prev);
            prev = temp;
        }

        return curr;
    }
}