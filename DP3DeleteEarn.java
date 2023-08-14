// TC:SC:O(n)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int n= nums.length;
        int max=0;
        for(int i=0;i<n;i++){
            if(nums[i]>max) max= nums[i];
        }
        System.out.print(max);
        int dp[]= new int[max+1];
        for(int num: nums){
            dp[num]+= num;
        }
        
        int prev=0;
        int curr= dp[1];
        for(int i=2; i<max+1; i++){
            int temp= curr;
            curr= Math.max(curr, prev+ dp[i]);
            prev= temp;
        }
        return curr;
    }
}
