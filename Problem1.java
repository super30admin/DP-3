// Leetcode 740 Delete and Earn
// Time -> O(n)
// Space -> O(n)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = Integer.MIN_VALUE;
        
        for(int i =0; i<nums.length; i++){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        
        int[] hash = new int[max+1];
        
        for(int i=0; i<=max; i++){
            hash[i] = 0;
        }
        
        for(int i=0; i<nums.length; i++){
            hash[nums[i]] += nums[i];
        }
        
        int taken = 0;
        int notTaken = 0;
        
        for(int i=0; i<hash.length;i++){
            
            int temp = taken;
            taken = hash[i] + notTaken;
            notTaken = Math.max(temp, notTaken);
        }
        
        return Math.max(taken, notTaken);
        
    }
}