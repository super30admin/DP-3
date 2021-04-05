// Time Complexity : O(max(N,max(nums))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
            
        }
        int max = 0;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int[] newNums = new int[max+1];
        for(int num:nums){
            newNums[num]+= num;
        }
        int pick = newNums[0], notPick = 0;
        
        for(int i = 0 ; i < max+1; i++){
            int temp = pick;
            pick = notPick + newNums[i];
            notPick = Math.max(notPick,temp);
        }
        return Math.max(pick,notPick);
    }
}
