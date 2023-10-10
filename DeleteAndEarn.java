/* Time Complexity : O(m) + O(n) 
 * 	m - length of the input array - nums
 *  n - length of the created array - arr -> (max value in the input array + 1)*/
/* Space Complexity : O(n)
 * 	n - length of the created array - arr */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//DP Solution
public class DeleteAndEarn {
	
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        //find the max value in the input array
        for(int num: nums){
            max = Math.max(max, num);
        }
        //creating array holding frequency of each value in input array
        int[] arr = new int[max+1];
        for(int num: nums){
            arr[num] += num;
        }

        int n = arr.length;
        //
        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);
        for(int i = 2; i < n; i++){
        	
        	//Max of(value at index - 1(Max at previous index),
        	// value at curr. index +  value at index - 2(Max at last to last index))
            int temp = curr;
            curr = Math.max(curr, arr[i] + prev);
            prev = temp;
        }
        return curr;
        
    }

}
