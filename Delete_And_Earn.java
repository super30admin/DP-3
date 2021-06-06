// Time complexity  - O(N)
//Space Complexity - O(N) Creating simplified array of max length



class Solution {
    public int deleteAndEarn(int[] nums) {

        int max = 0;
        if(nums == null) return 0;

        for(int num: nums) {

            max = Math.max(num,max);

        }

        //we create simplified array

        int [] arr = new int[max+1];

        for(int i = 0; i<nums.length; i++) {

            int index = nums[i];
            arr[index] += nums[i];

        }

        // Now we have simplified array with following elements [0,0,4,9,4]

        // now robbers problem dp algorithm to follow

        int skip = 0, take = arr[0];

        for(int i = 0; i < arr.length; i++) {

            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + arr[i];

        }


        return Math.max(skip, take);


    }
}