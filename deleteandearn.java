// Time Complexity : o(max(m))+O(n)
// Space Complexity : o(max(m))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no




// Your code here along with comments explaining your approach


class Solution {
    public int deleteAndEarn(int[] nums) {
        //in this we used robber pattern alternate skipping but to convert it
        //we need to get all elements to index and as it is sum increase index
        int max = Integer.MIN_VALUE;
        for(int num : nums){
            max=Math.max(num,max);
        }
        int[] array=new int[max+1];
        for(int i=0;i<nums.length;i++){
            array[nums[i]]=array[nums[i]]+nums[i];
        }
        int skip=0;
        int take=array[0];
        
        for(int i=0;i<array.length;i++){
            int temp=skip;
            skip=Math.max(skip,take);
            take=temp+array[i];
        }
    return Math.max(skip,take);
    }
}

