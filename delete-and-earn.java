//Time complexity: O(N)
//Space complexity: O(max(N))
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        //iterate over the array to find the maximum value in the array
        for(int num: nums) {
            max = Math.max(max, num);
        }
        //create an array with size max + 1
        int[] count = new int[max + 1];
        //the element at the index num will be current element at index  + count[num]
        for(int num: nums) {
            count[num] = count[num] + num;
        }
        int skip = 0, take = 0;
        for(int i = 0; i < count.length; i++) {
            int temp = skip;
            skip = Math.max(skip, take);
            take = temp + count[i];
        }
        return Math.max(skip, take);
    }
}