//time complexity is O(N) N is max number in given array
//space complexity is O(N) N is max number in given array
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max=Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums){
            int tmp = map.getOrDefault(num,0);
            map.put(num, tmp+1);
            max=Math.max(num, max);
        }
        int[] arr = new int[max+1];
        if(max==1)
        return map.getOrDefault(1,0);
        if(map.size()==1)
        arr[1] = map.getOrDefault(1,0);
        arr[2] = map.getOrDefault(2,0)*2;

        for(int i=3;i<=max;i++){
            arr[i]=Math.max(arr[i-2], arr[i-3])+(map.getOrDefault(i,0)*i);
        }
        return Math.max(arr[max], arr[max-1]);
    }
}