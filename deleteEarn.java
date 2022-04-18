//Time Complexity : O(n)
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public int deleteAndEarn(int[] nums) {
        //base case
        if(nums==null||nums.length==0)
            return 0;
        //find the max values
        int max=Integer.MIN_VALUE;
        //iterate over the arrays
        for(int num:nums){
            max=Math.max(max,num);
        }
        int[] k=new int[max+1];
        //iterate again over the array
        for(int num:nums){
            k[num]=k[num]+num;
        }
        int skip=0,take=k[0];
        for(int i=1;i<k.length;i++){
            int j=skip;
            skip=Math.max(skip,take);
            take=j+k[i];
        }
        return Math.max(skip, take);
    }
}