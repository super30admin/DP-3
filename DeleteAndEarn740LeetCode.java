// Time Compplexity : O(n+m)    n = array size
// Space Complexity : O(m)      m = maximum element value
// It runs successfully on leetcode
// I don't face any problems

public class DeleteAndEarn740LeetCode {



    // Bottom Up Approach
    public int deleteAndEarn(int[] nums) {

        int max=Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){                               //get the maximum value that are present in array
            max = Math.max(max, nums[i]);
        }

        int[] arr = new int[max+1];

        for(int i=0; i<nums.length; i++){                               // creating and storing values in another array by storing values = value*frequency
            arr[nums[i]] += nums[i];
        }

        int[] dp = new int[max+1];                                      //creating dp array to store dp state
        for(int i=1; i<=max; i++){                                      //iterating through max

            int select = arr[i] + ((i-2)<0 ? 0 : dp[i-2]);              //selecting the element check if array index out of bound or not
            int notSelect = (i-1)<0 ? 0 : dp[i-1];                      //not selecting the element check if array index out of bound or not
            dp[i] = Math.max(select, notSelect);                        //selecting the maxValue of select and notSelect way and storing in dp array

        }
        return dp[max];                                                 //returning the last element of dp array

    }




    // Top Down Approach
//     HashMap<Integer, Integer> map;
//     HashSet<Integer> set;
//     HashMap<Integer, Integer> map1;

//     public int deleteAndEarn(int[] nums) {

//         map = new HashMap<>();

//         map1 = new HashMap<>();
//         Arrays.sort(nums);
//         set = new HashSet<>();
//         for(int i=0; i<nums.length;i++){
//             map.put(nums[i], map.getOrDefault(nums[i], 0)+ 1);
//             set.add(nums[i]);
//         }

//         return getMaximum(nums, 0, set);
//     }

//     private int getMaximum(int[] nums, int index, HashSet<Integer> set){


//         if(index>=nums.length){
//             return 0;
//         }

//         if(set.contains(nums[index])){

//             if(map1.containsKey(nums[index])){
//                 return map1.get(nums[index]);
//             }


//             int freq =1;
//             if(map.containsKey(nums[index])){
//                 freq = map.get(nums[index]);
//             }

//             int value = nums[index]* freq;

//             HashSet<Integer> set1 = new HashSet<>(set);
//             HashSet<Integer> set2 = new HashSet<>(set);

//             int notSelect = getMaximum(nums, index+freq, set1);

//             if(set2.contains(nums[index]-1)){
//                 set2.remove(nums[index]-1);
//             }

//             if(set2.contains(nums[index]+1)){
//                 set2.remove(nums[index]+1);
//             }
//             int select = value+ getMaximum(nums, index+freq, set2);
//             map1.put(nums[index], Math.max(select, notSelect));
//             return Math.max(select, notSelect);
//         }
//         else{
//             return getMaximum(nums, index+1, set);
//         }
//     }


//     public int deleteAndEarn(int[] nums) {

//          return getMaximum(nums, 0, new HashSet<Integer>());
//     }


//     private int getMaximum(int[] nums, int index, HashSet<Integer> set){


//         if(index == nums.length){
//             return 0;
//         }

//         if(set.contains(nums[index])){
//             return getMaximum(nums, index+1, set);
//         }
//         else{

//             HashSet<Integer> set1 = new HashSet<>(set);
//             HashSet<Integer> set2 = new HashSet<>(set);

//             // System.out.println("Not Select---------");
//             // System.out.println(index);
//             // System.out.println(set1);
//             // System.out.println("Not Select---------");
//             int notSelect = getMaximum(nums, index+1, set1);

//             set2.add(nums[index] + 1);
//             set2.add(nums[index] - 1);


// //             System.out.println("Select---------");
// //             System.out.println(index);
// //             System.out.println(set2);
// //             System.out.println("Select--------");
//             int select = nums[index] + getMaximum(nums, index+1, set2);

//             return Math.max(notSelect, select);

//         }

//     }
}
