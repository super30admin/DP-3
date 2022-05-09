// Time Complexity : O(N)+O(max(given input))
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> totalPoints = new HashMap<>();
        int maxNum = 0;
        for(int num: nums) {
            totalPoints.put(num, totalPoints.getOrDefault(num, 0)+num);
            maxNum = Math.max(maxNum, num);
        }

        int choose = totalPoints.get(maxNum);
        int notChoose = totalPoints.getOrDefault(maxNum-1, 0);
        // we are looping from maxNumber - 2 to 0
        // at every iteration,
        // for instance, [3,4,5]
        // we try to choose between 4 and 3, whichever is max,
        // then compare it with 5 and 4, choose
        for(int i=maxNum-2;i>=0;i--) {
            int temp = choose;
            choose = Math.max(choose, notChoose);
            notChoose = temp+totalPoints.getOrDefault(i, 0);
        }
        return Math.max(choose, notChoose);
    }
}

//brute force - memoised
// Time Complexity : O(N)+2^N
// Space Complexity : O(N)

class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> totalPoints = new HashMap<>();
        int maxNum = 0;
        for(int num: nums) {
            totalPoints.put(num, totalPoints.getOrDefault(num, 0)+num);
            maxNum = Math.max(maxNum, num);
        }
        // we create a hashmap with elements as keys and occurences of each element*element
        //we take the maximum value from the given
        // recursively go through the map from the maximum value key to it becomes 0
        return helper(totalPoints, maxNum);
    }

    private int helper(HashMap<Integer, Integer> profits, int num) {
        if(num <= 0) {
            return 0;
        }
        if(memo.containsKey(num)){
            return memo.get(num);
        }
        //not choose case, we choose to go with one level up
        // for instance, [2,2,3,5]
        // we will have hashMap like [2:4,3:3,5:5]
        // we will go through the hashmap from the max,
        // incase of don't choose case, 5->4->3->2
        int case1 = helper(profits, num-1);
        // choose case we go two levels up
        // incase of don't choose case, 5->3->1
        int case2 = profits.getOrDefault(num, 0)+helper(profits, num-2);
        // finally, return the max
        memo.put(num, Math.max(case1, case2));
        return Math.max(case1, case2);
    }
}

//initial thought - literally coded the tree using recursion
// time: O(2^N)
//import java.util.HashSet;
//import java.util.Set;
//
//// "static void main" must be defined in a public class.
//class DeleteAndEarn {
//    public int findMaxDeleteAndEarn(int[] arr, Set<Integer> shouldNotConsider, int index, String init) {
//        if(index == arr.length) {
//            return 0;
//        }
//        int case1;
//        int case2;
//        System.out.println(init+" -> "+shouldNotConsider+" "+index);
//        case1 = findMaxDeleteAndEarn(arr, shouldNotConsider,index+1, "case1");
//        if(shouldNotConsider.contains(arr[index])) {
//            case2 = findMaxDeleteAndEarn(arr, shouldNotConsider, index+1, "case2");
//        } else {
//            Set<Integer> valueNotToConsider = new HashSet<>(shouldNotConsider);
//            valueNotToConsider.add(arr[index]-1);
//            valueNotToConsider.add(arr[index]+1);
//            case2 = findMaxDeleteAndEarn(arr, valueNotToConsider, index+1, "case2")+arr[index];
//        }
//        return Math.max(case1, case2);
//    }
//    public static void main(String[] args) {
//        DeleteAndEarn kp = new DeleteAndEarn();
//        int[] values = {2,2,3,3,3,4};
//        System.out.println(kp.findMaxDeleteAndEarn(values, new HashSet<>(),0, "Init"));
//    }
//}
