// Time - O(N+W)
// Space - O(W)

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(max<nums[i]) {
                max = nums[i];
            }
        }
        
        int[] arr = new int[max+1];
        
        for(int i=0;i<nums.length;i++) {
            arr[nums[i]] += nums[i];
        }
        int skip = 0, take = 0;
        
        for(int i=0;i<arr.length;i++) {
            int temp = Math.max(skip, take);
            take = skip + arr[i];
            skip = temp;
        }
        
        return Math.max(skip, take);
    } 
}
