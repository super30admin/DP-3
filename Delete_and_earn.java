class Solution {
    public int deleteAndEarn(int[] nums) {
         if(nums == null) return 0;
        
        int max = Integer.MIN_VALUE;
        for(int i =0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }
        
        int [] arr = new int[max + 1];
        for(int num:nums){
            arr[num] += num;
        }
        int skip = 0;
        int take = 0;
        
        for(int i = 1; i< arr.length; i++){
            int temp= skip;
            skip = Math.max(skip,take);
            take = arr[i] + temp;
        }
        return Math.max(skip,take);
        
    }
}
