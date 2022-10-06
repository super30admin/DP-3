//TC - O(n)
//SC - O(max)
class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] map = new int[10001];
        for (int i=0;i<nums.length;i++) {
            map[nums[i]] = map[nums[i]] + nums[i];
        }
        return house(0,map,new HashMap<Integer,Integer>());
    }
    
    public int house(int currentIndex,int[] map,HashMap<Integer,Integer>memo){
        
        if(currentIndex>=map.length) return 0;
        
        int currentKey = currentIndex;
        if(memo.containsKey(currentKey)) return memo.get(currentKey);
        
        int consider = map[currentIndex] + house(currentIndex + 2,map,memo);
        int notConsider =  house(currentIndex + 1,map,memo);
        
        memo.put(currentKey,Math.max(consider,notConsider));
        
        return Math.max(consider,notConsider);
    }
    
}