// Time Complexity : O(n)
// Space Complexity : O(n)
    // n is the largest number present in the given array.

// Your code here along with comments explaining your approach
    //We use a count array to store the total sums of all the identical numbers.
    //We iterate over the count array keeping track of 2 variables, one for most earned by deleting last number, another for best of both "last number deleted" or the sum of "previous of last number and current number".
    //When we traverse the entire array, we end up with the most earnings acquired.
    
class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int x : nums)
        {
            if (x>max)
            {
                max = x;
            }
        }
        int[] aux = new int[max+1];
        for (int x : nums)
        {
            aux[x] += x;
        }
        if (aux.length==1)
        {
            return aux[0];
        }
        int lastNumberDeleted = aux[0];
        int bestOfBoth = Math.max(lastNumberDeleted, aux[1]);
        for (int i=2; i<=max; i++)
        {
            int currentBest = bestOfBoth;
            bestOfBoth = Math.max(bestOfBoth, lastNumberDeleted+aux[i]);
            lastNumberDeleted = currentBest;
        }
        return bestOfBoth;
    }
}