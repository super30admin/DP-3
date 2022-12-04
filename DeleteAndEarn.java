// Time Complexity : O(n) + O(k) where n is length of nums array, k is max number of nums array+1
// Space Complexity : O(k)

//https://leetcode.com/problems/delete-and-earn

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==1) return nums[0];
        int max= nums[0];
        for(int i : nums){
            max = Math.max(max,i);
        }
        int[] arr = new int[max+1];
        for(int i=0; i<nums.length;i++){
            arr[nums[i]]+=nums[i];
        }
        int prevPrev = arr[0];
        int prev = Math.max(prevPrev,arr[1]);
        for(int i=2;i<arr.length;i++){
            int temp = prev;
            prev = Math.max(prevPrev+arr[i],prev);
            prevPrev = temp;
        }
        return prev;
    }
}
