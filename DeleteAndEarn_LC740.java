//Time: O (n log n(sort) + n (hashmap) + n(traversing through array)) => O(nlogn)

//Space = O(2n) =  O(n) [ hashmap and sorted list] ** Best case space is m => unique elements 

class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        //sort the elements and create list of unique sorted numbers as that's all we need along with hashmap
        Arrays.sort(nums); 
        List<Integer> sorted = new ArrayList<>();
        for (int num : nums) { 
            map.put(num, map.getOrDefault(num, 0) + num);
            if(!sorted.contains(num)) sorted.add(num);
        }
        int nc = 0, c = 0;
        for (int num : sorted) {
            if (map.containsKey(num - 1)) {
                int temp = Math.max(nc + map.get(num), c);
                nc = Math.max(c, nc);
                c = temp;
            } else {
                nc = Math.max(c, nc);
                c += map.get(num);
            }
        }
        return c;
    }
}