//Amazon interview question
//Time complexity = O(max(n))+O(n)
//Space complexity = O(max(n))
//Greedy approach -pick any number for that
//pickednumber+1;pickednumebr-1 from given deleted but it is not giving correct result

//So going for Exhasutive approach-using 0 for choose 1 for not choose
//given array zero's cannot be skipped, if we are skipping zero then it will give  incorrect result.
//using DParray to store in 0 index initial with zero and 1 index initizalied with the value of o index +current index
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int[] dp = new int[max+1];
        for(int num:nums){//select from given array values to the current value number
            dp[num] = dp[num]+num;
        }
        int skip = 0,take = dp[0];//skip for choose 0 and choose 1 for take
        for(int i =1; i<max+1;i++){
            int temp = skip;
            skip = Math.max(skip,take);
            take = temp+dp[i];
        }
        return Math.max(skip,take);
        
    }
}