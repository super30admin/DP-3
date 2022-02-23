//                           Top-Down               Bottom-Up
// Time Complexity:            O(n)                  O(m+n)
// Space Complexity:           O(n)                   O(m)
// where n is number of elements in array and m is maximum number in array
// Top-Down approach seems a little hard
// No, I didn't face any problem in this problem statement

package src;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeleteAndEarn {
    public static void main(String[] args) {
        int[] nums = {1,1,3,4,4,4} ;
        FindEarn fe = new FindEarn();
        System.out.println("Highest earned amount: "+fe.deleteAndEarn(nums));
    }
}

class FindEarn
{
    public int deleteAndEarn(int[] nums) {

        int max = Integer.MIN_VALUE;

        for(int i : nums)
            max = Math.max(max,i);

        int[] dp = new int[max+1];

        for(int i=0; i<nums.length; i++)
            dp[nums[i]] += nums[i];

        for(int i=0; i<dp.length; i++)
            dp[i] = Math.max((dp[i] + (i>=2 ? dp[i-2] : 0)), (i>=1 ? dp[i-1] : 0));

        return dp[max];
    }
}


// ******************** Top-Down Approach ********************
//class FindAndEarn {
//
//    Set<Integer> set = new HashSet<>();
//    Map<Integer, Integer> map = new HashMap<>();
//
//    public static void main(String[] args) {
////        int[] nums = {8,10,4,9,1,3,5,9,4,10} ;
//        int[] nums = {2,2,3,3,3,4};
//        FindAndEarn fae = new FindAndEarn();
//        System.out.println("Highest earned amount: "+fae.deleteAndEarn(nums));
//    }
//
//    public int deleteAndEarn(int[] nums) {
//        for(int i:nums)
//        {
//            map.put(i, map.getOrDefault(i,0)+i);
//        }
//
//        return deleteAndEarn(nums, 0, set);
//    }
//
//    private int deleteAndEarn(int[] nums, int index, Set<Integer> set)
//    {
//        if(index == nums.length)
//            return 0;
//
//        int temp = nums[index];
//        int choose = Integer.MIN_VALUE;
//
//        if(!set.contains(temp))
//        {
//            set.add(temp);
//            set.add(temp-1);
//            set.add(temp+1);
//            int temp2 = map.get(temp) ;
//            choose = temp2 + deleteAndEarn(nums, index+1, set) ;
//        }
//
//        set.remove(temp);
////        set.remove(temp-1);
////        set.remove(temp+1);
//
//        int notChoose = deleteAndEarn(nums, index+1, set) ;
//
//        return Math.max(choose,notChoose) ;
//    }
//}