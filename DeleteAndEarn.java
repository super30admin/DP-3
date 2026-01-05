// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach :

// We need the values to be sorted. Also we need the frequency of the values. So we can use an array(let's call it buckets)
// where the index represents the number value, and the value at that index is the total points you get from that number (count * value).
// By using the number as an index in an array, the values are automatically sorted. Now, the problem is identical to
// House Robber. You cannot "rob" (earn from) two adjacent indices because picking i means you must delete i-1 and i+1.
import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num: nums){  // O(N)
            max = Math.max(max, num);
        }

        int[] buckets = new int[max+1];
        for (int num: nums){  // O(max(N))
            buckets[num] += 1;
        }

        int maxProfit = deleteAndEarnRecursive(buckets, 1);
        System.out.println("Max profit with recursion: "+ maxProfit);

        maxProfit = deleteAndEarnMemo(buckets,1, new HashMap<>());
        System.out.println("Max profit with memo: "+ maxProfit);

        maxProfit = deleteAndEarnTabulation(buckets);
        System.out.println("Max profit with tabulation: "+ maxProfit);

        maxProfit = deleteAndEarnSpaceOptimized(buckets);
        System.out.println("Max profit with space optimized: "+ maxProfit);
        return maxProfit;
    }

    private int deleteAndEarnSpaceOptimized(int[] buckets) {
        // Time Complexity : O(max(N)+ N), N is the size of input array, M is max value in the array
        // Space Complexity : O(max(N)), size of buckets array created additionally
        int size = buckets.length;
        int prev = 0;
        int neighbor = buckets[1];

        for (int i = 2; i < size; i++){
            int currentProfit = Math.max(neighbor, i*buckets[i]+ prev);
            prev = neighbor;
            neighbor = currentProfit;
        }
        return neighbor;
    }

    private int deleteAndEarnTabulation(int[] buckets) {
        // Time Complexity : O(max(N)+ N), N is the size of input array, M is max value in the array
        // Space Complexity : O(max(N)), N is the size of the input array
        int size = buckets.length;
        int[] table = new int[size];
        table[1] = buckets[1];
        for (int i = 2; i < size; i++){
            table[i] = Math.max(table[i-1], i*buckets[i]+ table[i-2]);
        }
        return table[size-1];
    }

    private int deleteAndEarnMemo(int[] buckets, int index, Map<Integer, Integer> memo) {
        // Time Complexity : O(N), N is number of values in the bucket array, N = max(input array)
        // Space Complexity : O(N), N frames on the recursion stack
        if(index >= buckets.length) return 0;

        if(memo.containsKey(index)) return memo.get(index);

        int include = buckets[index]* index + deleteAndEarnMemo(buckets, index+2, memo);
        int exclude = deleteAndEarnMemo(buckets, index+1, memo);
        memo.put(index, Math.max(include, exclude));
        return memo.get(index);
    }

    private int deleteAndEarnRecursive(int[] buckets, int index) {
        // Time Complexity : O(2^N), N is number of values in the bucket array, N = max(input array)
        // Space Complexity : O(N), N frames on the recursion stack
        if(index >= buckets.length) return 0;

        int include = buckets[index]*index + deleteAndEarnRecursive(buckets, index+2);
        int exclude = deleteAndEarnRecursive(buckets, index+1);
        return Math.max(include, exclude);
    }
}
