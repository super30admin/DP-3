// TC :- O(n)
//SC:- O(max(d)) -- where d is largest number.
class Solution {
    public int deleteAndEarn(int[] nums) {
         if(nums == null || nums.length == 0) {
            return 0;
        }
        int max_len = 0;
        for(int i = 0 ; i < nums.length; i++) {
            if(nums[i] >  max_len) {
                max_len = nums[i];
            }
        }
        int[] arr = new int[max_len + 1];
        for(int i = 0 ; i < nums.length; i++) {
            arr[nums[i]] += nums[i];
        }
        int skip = 0, take = 0;
        for(int i = 0; i < arr.length; i++) {
            int temp = Math.max(skip, take);
            take = skip + arr[i];
            skip = temp;
        }
        return Math.max(skip, take);
    }
}