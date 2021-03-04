class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] dp = new int[getMax(nums)+1];
        int c =0;
        int dc = 0;
        for(int num: nums){
            dp[num]+= num;
        }
        for(int i:dp){
            int temp = dc;
            dc = Math.max(c,dc);
            c = i+temp;
        }
        return Math.max(c,dc);
        
    }
    
    public int getMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for(int x: nums){
            if(x>max)
                max = x;
        }
        return max;
    }
}

//TC:O(n)
//SC:O(n)
