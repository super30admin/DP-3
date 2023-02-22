class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        int earn=0;
        for(int i:nums){
            max=Math.max(max,i);
        }
        int [] sum= new int[max+1];
       for(int num : nums){
           sum[num]+=num;
       }
       
        int prev= 0;
        int curr=sum[1];
        for(int i=2;i<sum.length;i++){
           int temp = curr;
           curr=Math.max(curr,sum[i]+prev);
           prev=temp;
            
        }
        return curr;
    }
}