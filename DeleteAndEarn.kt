// In this problem, we first calculate the max number of element in the input array, create a new array with size of max + 1. 
// Then we accumulate the values for each index in the new array. Finally, we apply the house robber logic to get the result.
// Time complexity is O(n + m) where n is the size of input array and m is the max number in the input array.
// Space complexity is O(m) for the new array.
class Solution {
    fun deleteAndEarn(nums: IntArray): Int {
        if(nums.size < 2) return nums[0]
        var max = Int.MIN_VALUE
        for (n in nums) {
            max = Math.max(max, n)
        }

        val arr = IntArray(max + 1)
        for(n in nums) {
            arr[n] += n
        }

        var prev = arr[0]
        var curr = Math.max(arr[0], arr[1])
        for (i in 2..arr.size - 1) {
            var temp = curr
            curr = Math.max(curr, arr[i]+ prev)
            prev = temp
        }

        return curr
    }
}