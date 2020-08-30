//Time Complexity: O(m) where m is the max number in the array
//Space complexity: O(1) constant size array
import java.util.Arrays;

public class DeleteAndEarn {
    public static int deleteAndEarn(int[] nums) {
    //         Map<Integer, Integer> map = new HashMap<>();
    //         for(int i=0;i<nums.length; i++){
    //             if(map.containsKey(nums[i])){
    //                 map.put(nums[i], map.get(nums[i])+1);
    //             }
    //             else{
    //                 map.put(nums[i], 1);
    //             }
    //         }
    //         TreeMap<Integer, Integer> sorted = new TreeMap<>(); 
        
    //         // Copy all data from hashMap into TreeMap 
    //         sorted.putAll(map); 
            
    //         System.out.println(map);
    //         int[] a = new int[map.size()];
    //         int[] b = new int[map.size()];
    //         int i = 0;
    //         for(Map.Entry<Integer, Integer> entry: map.entrySet()){
    //             a[i] = map.getKey();
    //             b[i] = map.getValue();
    //         }
        if(nums.length == 0 || nums == null)
            return 0;
        // sorting just to get the max element from the array
        Arrays.sort(nums);
        //creating an of array of size equal to the max value
        int[] a = new int[nums[nums.length-1]+1];
        System.out.println(a.length);
        //adding the values to the respective index
        for(int n : nums){
            a[n] += n;    
        }        

        int x=0;
        int y=0;
        
        //fetching the max value
        for(int n: a){
            int temp = y;
            y = Math.max(x, y);
            x = n+temp;
            System.out.println(x+","+y);
        }
        
        return Math.max(x, y);
        
    }
    public static void main(String[] args) {
        int[] nums = {12,3,3,2,1,4,6,7,8,4,3,2,2,4,5,6,7,3};
        System.out.println(deleteAndEarn(nums));
    }
}