class Solution {
    public int deleteAndEarn(int[] nums) {
        //using hashmap
        HashMap<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int max=0;

        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+num);
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
            } else{
                curr = Math.max(curr, 0+prev);
            }
            prev = temp;
        }
        return curr;


/*
        //using dp
        int max=0;
        for(int num: nums){
            max = Math.max(max, num);
        }

        int[] arr = new int[max+1];
        for(int num:nums){ //2
            arr[num] += num;
        }

        int prev = arr[0];
        int curr = Math.max(arr[0], arr[1]);

        for(int i=2; i<=max; i++){
            int temp = curr;
            curr = Math.max(curr, arr[i]+prev);
            prev=temp;
        }

        return curr;
        */
    }
}
