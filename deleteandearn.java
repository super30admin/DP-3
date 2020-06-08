// Time Complexity :O(m)
// Space Complexity :O(m)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums==null || nums.length==0)return 0;
        int max =0;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int [] arr =new int [max+1];
        for (int num:nums){
            arr[num] = arr[num]+num;
        }
        int skip = 0;
        int take = 0;
        for(int i =1 ; i<arr.length;i++){
            int temp =skip;
            skip = Math.max(skip,take);
            take = temp +arr[i];
            
        }
        return Math.max(skip,take);
    }
}