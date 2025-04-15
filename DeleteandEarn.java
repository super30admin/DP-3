// we use a hashmap for traversal
// find max among choose, no choose 
// we cannot leave the number which are not present 
// Time : O(n) + O(max(n))
// Average Space : O(max(n))

import java.util.*;

class Solution {
    public int deleteAndEarn(int[] nums) { // using hashmap(space optimised)
        HashMap<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = 0; // max num in arr

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+num);
            max = Math.max(max, num); // identify max
            min = Math.min(min, num);
        }

        int prev = map.get(min);
        int curr = prev;
        if(map.containsKey(min+1)) {
           curr = Math.max(prev, map.get(min+1));
        }

        for(int i=min+2; i<=max; i++) {
            int temp = curr;
            if(map.containsKey(i)) {
            curr = Math.max(curr, map.get(i)+prev); // (nochoose, choose)  
            } else {
                curr = Math.max(curr, 0+prev);
            }
            prev = temp;
        }
        return curr;
    }
}
