// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num,0)+num);
        }

        Set<Integer> keys = map.keySet();

        int prevPrevKey = -1;
        int prevKey = -1;

        for(int key: keys){
            int me = map.get(key);
            //System.out.println(key + " " + me);
            int prevKeyVal = prevKey == key-1 ? map.getOrDefault(prevPrevKey, 0) : map.getOrDefault(prevKey, 0);
            int meminus1 = map.getOrDefault(key-1, 0);
            map.put(key, Math.max(me+prevKeyVal, meminus1));
            prevPrevKey = prevKey;
            prevKey = key;
        }

        return map.get(prevKey);
    }
}
