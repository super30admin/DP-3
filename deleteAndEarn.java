// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        //use treemap to maintain order
        final Map<Integer, Integer> map = new TreeMap<>();
        
        //fill map with all the values in nums
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }
        
        //go through sorted keyset:
        //if map contains num-1
        //      choose max from previous choose and previous not_choose+current_val
        //else
        //      current val notchoose will prev choose val
        //      choose will choose plus value of num
        int nc = 0, c = 0;
        for (int num : map.keySet()) {
            
            if (map.containsKey(num - 1)) {
                
                int temp = Math.max(nc + map.get(num), c);
                nc = c;
                c = temp;
               
                
            } else {
                
                nc = c;
                c += map.get(num);
                
            }
        }
        return c;
    }
}
