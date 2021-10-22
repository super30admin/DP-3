// 740 Delete and Earn
// solved on leetcode
// time complexity - O(n)
// space complexity - O(n)
class Solution {
    public int deleteAndEarn(int[] nums) {
        
        HashMap <Integer,Integer> hashmap = new HashMap();
        
        for(int i=0;i<nums.length;i++){
            if(!hashmap.containsKey(nums[i])){
                hashmap.put(nums[i],nums[i]);
            }else{
                hashmap.put(nums[i],nums[i]+hashmap.get(nums[i]));
            }
        }
        
        int max=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max){
                max=nums[i];
            }
        }
        int taken=0,notTaken=0;
        for(int i=0;i<=max;i++){
            if(!hashmap.containsKey(i)){
                notTaken=Math.max(taken,notTaken);
                taken=notTaken;
                continue;
            }
            int temp=taken;
            taken= hashmap.get(i)+ notTaken;
            notTaken=Math.max(temp,notTaken);
        }
        return Math.max(taken,notTaken);
    }
}