// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no



class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=0;
        int take=0; int skip=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+nums[i]);
            }else{
                map.put(nums[i],nums[i]);
                max = Math.max(max,nums[i]);
            }
        }
        while(!map.isEmpty()){
            if(!map.containsKey(max)){
                map.put(max,0);
            }
            int temp = take;
            take = map.get(max)+skip;
            skip = Math.max(skip,temp);
            map.remove(max);
            max--;
        }
        return Math.max(skip,take);
    }
}
