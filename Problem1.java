// Time Complexity : 0(n+m)  n is the total elements and m is the maximum element
// Space Complexity : O(n) , creating a 1d array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Problem1 {
    public int deleteAndEarn(int[] nums) {

        //null check
        if(nums== null || nums.length ==0 ) return 0;

        //taking the maximum elemnt from the array
        int max = nums[0];
        for(int num : nums){

            max = Math.max(max, num);
        }

        //creating a 1-d array of size max+1
        //arr will contain he sum of elements of each frequency
        int[] arr = new int[max+1];

        for (int num: nums){

            arr[num] +=num;

        }

        //taking two pointers
        int prev =0;
        int curr= arr[1];
        for(int i=2; i<arr.length; i++){
            int temp = curr;
            curr = Math.max(curr, prev+arr[i]);
            prev = temp;
        }
        return curr;
    }
}
