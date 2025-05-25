''' 
Time Complexity: O(n)
Space Complexity: O(n) 

Approach: 
Prepare a frequency map for each number in the array 
Use this frequency map to calculate the maximum earning 
Then perform the dynamic programming approach, 
where we take the maximum of the current element and the next element 

'''


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:

        maxNumber = max(nums)
        arr = [0 for i in range(maxNumber + 1)]

        for num in nums:
            arr[num] += num

        dp = [-1 for i in range(len(arr))]
        
        dp[0] = arr[0]
        dp[1] = max(arr[0], arr[1])

        for i in range(2, len(arr)):
            dp[i] = max(arr[i] + dp[i - 2], dp[i - 1])

        return dp[len(arr) - 1]
