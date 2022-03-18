// Time Complexity : O(max in nums) + O(nums.length)
// Space Complexity : O(max in nums)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int deleteAndEarn(int[] nums) {

        int max=0;

        //find max in the array
        for(int i : nums)
        {
            max = Math.max(max, i);
        }

        //make an array with length max
        int[] arr = new int[max+1]; //to keep a 0 index so that numbers from nums are correctly mapped as indices to their value

        //fill each index with the total value that index has in nums array
            /*
            nums = {1,3,3,4,3,6,7,1,2,8,7}
            at index 3, arr will have value 9
            */
        for(int i=0; i<nums.length; i++)
        {
            arr[nums[i]] += nums[i];
        }

        //now if we choose to use i index of arr, i-1 and i+1 are finished - can't be used
        //problem is reduced to house robber

        int skip=0, take=0, temp=0;

        for(int i=1; i<arr.length; i++)
        {
            skip = Math.max(skip, take);
            take = arr[i] + temp;
            temp = skip;
        }

        return Math.max(skip, take);

    }
}
