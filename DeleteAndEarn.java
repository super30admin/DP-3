// This program converts the given space into a house robber style problem where adjacent houses cannot be robbed but in this case adjacent numbers cannot be picked if a number is picked
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length==1) return nums[0];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap();
        // Iterate throught the elements and fetch min and max values
        for(int i:nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
            // Keep a counter of each element
            map.put(i, map.getOrDefault(i,0)+i);
        }
        // Prev for tracking the previous max sum
        int prev = map.get(min);
        // Prev for tracking the current max sum
        int curr = prev;
        if(map.containsKey(min+1)) {
            // Updating curr if min+1 exist
            curr = Math.max(map.get(min+1), prev);
        }
        for(int i=min+2;i<=max;i++) {
            int temp = curr;
            // Updating the curr to the max curr or prev plus curr number
            if(map.containsKey(i)){
              curr = Math.max(curr, prev+map.get(i));
            }
            prev = temp;
        }
        return curr;
    }
}
