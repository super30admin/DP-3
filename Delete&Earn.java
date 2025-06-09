//Time Complexity : O(n + max(n))
//Space Complexity: O(n)
class Solution {
    public int deleteAndEarn(int[] nums) {
                HashMap<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+num);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int prev = map.get(min);
        int curr = prev;
        if(map.containsKey(min+1)){
            curr = Math.max(prev, map.get(min+1));
        }

        for(int i=min+2; i<=max; i++){
            int temp = curr;
            if(map.containsKey(i)){
                curr = Math.max(curr, map.get(i)+prev);
            }
            prev = temp;
        }

        return curr;
    }
}
