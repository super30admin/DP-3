// Time Complexity : O(N log N) (due to sorting)  
// Space Complexity : O(N) (for HashMap and array storage)  
// Did this code successfully run on Leetcode : Yes  
// Any problem you faced while coding this : No


//Approach:
// 1. Use a HashMap to count occurrences of each number in nums.  
// 2. Sort unique numbers and use two variables (`del`, `ndel`) to track max points.  
// 3. If consecutive, update `del` using `ndel`; otherwise, add to the max of previous results and return the maximum.  


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteandEarn {
    public int deleteAndEarn(int[] nums) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(map.containsKey(nums[i]))
            {
                int get = map.get(nums[i]);
                map.put(nums[i],get+1);
            }
            else
            {
                map.put(nums[i],1);
            }
        }
        int[] ar = new int[map.size()];
        int mapi = 0;
        for(Map.Entry<Integer,Integer> m:map.entrySet())
        {
            ar[mapi] = m.getKey();
            mapi++;
        }
        Arrays.sort(ar);
        int del = ar[0]*map.get(ar[0]);
        int ndel = 0;
        for(int i=1;i<ar.length;i++)
        {
            if(ar[i-1]+1 == ar[i])
            {
                int max = Math.max(ndel,del);
                del = ndel+(ar[i]*map.get(ar[i]));
                ndel = max;
            }
            else
            {
                int max = Math.max(ndel,del);
                del = max+(ar[i]*map.get(ar[i]));
                ndel = max;
            }
        }
        return Math.max(ndel,del);
    }
}
