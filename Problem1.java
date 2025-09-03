// Time Complexity : O(n+max)
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
Applying the concepts of House robber problem where we arent allowed to rob adjacent house
Similarly element+1 and element-1 gets eliminated if we choose the element
choose the max earning using the above selection 
*/
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        //maximum size of elements in an array
        for(int num: nums) {
            if(num > max) max = num;
        }

        int[] arr = new int[max+1];
        for(int num: nums) arr[num] += num;

        int prev = arr[0], curr = Math.max(prev, arr[1]);
        //either skip the current element and take the previous or take max of current and two element above it
        for(int i = 2; i<arr.length ;i++) {
            int temp = curr;
            curr = Math.max(temp, arr[i]+prev);
            prev = temp;
        }
        return curr;
    }
}
