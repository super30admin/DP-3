// Time Complexity :  O(m + n) where m = max(nums), n = len of nums
// Space Complexity : O(m) where m = max(nums)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        //convert this problem to house robber pattern
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        //find the max number in the array
        for(int i = 0; i < n; i++) { //O(n)

            max = Math.max(max, nums[i]);
        }

        //create a array and store total cost of each number
        int arr[] = new int[max + 1];
        for(int i = 0; i < n; i++) { 
            
            //cal total cost
            int idx = nums[i];
            arr[idx] += idx;
        }

        //now we have 1D array with total cost (Similar to house robber)
        //if we choose an index, we cannot choose index before it
        int prev = arr[0];
        int curr = Math.max(arr[1] + 0, prev);
        for(int i = 2; i < arr.length; i++) { //O(m) == O(max(n))

            int temp = curr;
            //Max(choose current index, not choose current index)
            curr = Math.max(arr[i] + prev, curr);

            prev = temp;
        }   

        return curr;
    }
}
//TC:- O(Max(n) + n) = O(m + n)