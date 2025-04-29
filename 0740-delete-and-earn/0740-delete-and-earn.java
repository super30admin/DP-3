/*Approach
This is a variation of the "House Robber" problem.
In the "delete and earn", when you pick a number 'num', you earn 'num' points but
must delete all instances of 'num-1' and 'num+1'.
Thus u cannot pick adjacent numbers.
We  precompute the total points we can earn unique number.
Then, using dynamic programming (with memoization),
we decide at each step whether to pick or skip a number for maximum points.

Steps:

1. Create a HashMap to store total points earned by taking each number
2. Create a HashMap to cache maximum points computed for a given number.
3. Create a Helper method to compute maximum points up to a given number.
4. Base case for Helper function: No numbers to pick
5. Only 1 number available: Either take all 1's or 0 if no 1 exists
6. If already computed return cache result
7. Get points if we pick the current number.
8. Two choice: 1. Skip the current number : maxPoints(num-1)
9. 2. Pick current number : gain + maxPoints(num-2)
10. Take the maximum of these two choices.
11. Return the computed result.
12. Create a Main method to solve the delete and earn problems
13. Track the maximum number in nums
14. Precompute the points for each number
15. Update maxNumber
16. Compute the result starting from the maximum number


*/
import java.util.HashMap;

class Solution {
   
    private HashMap<Integer, Integer> points = new HashMap<>();
    private HashMap<Integer, Integer> cache = new HashMap<>();
    private int maxPoints(int num){
        if(num == 0){
            return 0;
        }

        if (num == 1){
            return points.getOrDefault(1, 0);
        }

        if(cache.containsKey(num)){
            return cache.get(num);
        }

        int gain = points.getOrDefault(num,0);

        cache.put(num, Math.max(maxPoints(num-1), maxPoints(num-2) + gain));

        return cache.get(num);
    }
    public int deleteAndEarn(int[] nums){
        int maxNumber = 0;
        for (int num : nums){
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }

    return maxPoints(maxNumber);
    }


        
    
}