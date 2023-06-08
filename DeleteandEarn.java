// Time Complexity o(n) Space Complexity o(n);
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        for(int num : nums){
            max=Math.max(max,num);
        }
        int[] sum = new int[max+1];
        for(int i=0;i<nums.length;i++){
            int curr = nums[i];
            sum[curr]+=curr;
        }
        int prev= sum[0];
        int curr = Math.max(sum[0],sum[1]);
        for(int i=2;i<sum.length;i++){
            int temp=curr;
            curr = Math.max(curr,sum[i]+prev);
            prev=temp;
        }
        return curr;
    }
}