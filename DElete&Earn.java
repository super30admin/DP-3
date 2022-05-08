// Time Complexity : O(N*2^N) N = number of elements
// Space Complexity : O(2N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> mapTotal = new HashMap<>();
        HashMap<Integer, Integer> mapCalculate = new HashMap<>();
        int max = 0;
        for(int n:nums){
            mapTotal.put(n, mapTotal.getOrDefault(n,0)+n);
            max = Math.max(max, n);
        }
        return helper(max, mapTotal, mapCalculate);
    }
    
    private int helper(int num, HashMap<Integer, Integer> mapTotal, HashMap<Integer, Integer> mapCalculate){
        //base
        if(num==0){
            return 0;
        }
        if(num==1){
            return mapTotal.getOrDefault(1,0);
        }
        if(mapCalculate.containsKey(num)){
            return mapCalculate.get(num);
        }
        //logic
        int gain = mapTotal.getOrDefault(num,0);
        //choose
        int case1 = gain+helper(num-2, mapTotal, mapCalculate);
        //dont choose
        int case2 = helper(num-1, mapTotal, mapCalculate);
        
        mapCalculate.put(num, Math.max(case1,case2));
        
        return mapCalculate.getOrDefault(num,0);
    }
}