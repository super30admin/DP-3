// Time Complexity:  Max[O(n) and O(max)] where n is the length of given input array & max is the maximum value in given input array
// Space Complexity: O(max)

class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int n: nums){
            max = Math.max(max, n);
        }
        
        int[] arr = new int[max+1];
        
        for(int i=0; i< nums.length; i++){
            arr[nums[i]] += nums[i];
        }
        
        int skip = 0; int take = arr[0];
        for(int i=0; i< arr.length; i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp + arr[i];
        }
        
        return Math.max(skip,take);
        
    }
}