// Time Complexity : O(N + M)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int max=0;
        int min = Integer.MAX_VALUE;
        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int prev = map.get(min);
        int curr = 0;
        if(map.containsKey(min+1)) {
            curr = Math.max(prev, map.get(min+1));
        } else {
            curr = Math.max(prev, 0);
        }

        for(int i=min+2; i<=max; i++) {
            int temp= curr;
            if(map.containsKey(i)) {
                curr = Math.max(curr, map.get(i)+ prev);
            } else {
                curr = Math.max(curr, 0+prev);
            }
            prev = temp;
            
        }
        return curr;
    }
}
