// Time Complexity : O(max(n)) n= nums length
// Space Complexity : O(max(n))
// Did this code successfully run on Leetcode : yes
class Solution {
    public int deleteAndEarn(int[] nums) {
    
        int max=0;
        for(int num: nums){
            max=Math.max(max,num);
        }
        int[] values = new int[max+1];
         for(int num: nums){
            values[num]+=num;
        }
       
        int choose = values[0];
        int notChoose= values[1];
        for(int i=2; i<values.length; i++){
            int temp = choose;
            choose = Math.max(choose,notChoose);
            notChoose = temp + values[i];
        }
        return Math.max(choose, notChoose);
        
        
    }
}