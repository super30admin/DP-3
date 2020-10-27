// Time Complexity : O(2n+m) where n is nums.length and m is max number in nums array
// Space Complexity : O(m) m is max number in nums array
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*Approach
 * We preprocess the data to create new array, where where we keep the index value to the sum of elements in the existing array.
 * We see it has a repetitive sub problem and use DP bottom up approach to solve it.
 * */

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {

        //edge
        if(nums==null || nums.length==0) return 0;

        //preprocess the data
        //find the max element in the array
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(max, num);
        }
        //Create a array with size = max+1 and fill in the values by adding the value from
        //nums[i] at array index
        int arr[] = new int[max+1];
        for(int i=0; i<nums.length; i++){
            arr[nums[i]] += nums[i];
        }

        //now the problem is same as hoses rob problem
        int skip = 0, take = arr[0];
        for(int i=1; i<arr.length; i++){
            int temp = skip;
            //we dont choose
            skip = Math.max(skip, take);
            // we choose
            take = temp+arr[i];
        }

        return Math.max(skip, take);
    }

}