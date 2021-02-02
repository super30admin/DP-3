// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        final Map<Integer, Integer> map = new HashMap<>();
        //Putting all the number as key and there sum as value in hashmap
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }
        int nc = 0, c = 0;
        for (int num : map.keySet()) {
        // for(Map.Entry m : map.entrySet()){
        //     int num = (Integer)m.getKey();
            System.out.println(num);
            //If the previous number exists in the hashmap,that means we have to add not choose of previous and 
            //the current numbers value present in hashmap and assign it to c,
            //Also we have to update the not choose(nc) with max of c and nc
            if (map.containsKey(num - 1)) {
                // int temp = Math.max(nc + map.get(num), c);
                // nc = c;
                // c = temp;
                int temp = nc;
                nc = Math.max(c,nc);
                c = temp + map.get(num);
            } else {
                //else we have to assing nc as max of c,nc and c as nc + get the value from hashmap
                nc = Math.max(c,nc);
                c = nc+ map.get(num);
            }
        }
        return Math.max(c,nc);
    }
}
