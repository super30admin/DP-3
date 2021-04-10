class Solution(object):

    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        ### DP
        N = max(nums)
        count_arr = [0]*(N+1)

        # Array of freq of occurences
        for num in nums:
            count_arr[num] += 1
        
        pick, skip = 0,0
        
        # At each iteration, we either pick or skip.
        for index, freq in enumerate(count_arr):
            temp = skip
            skip = max(pick, skip)
            pick = temp + (index*freq)

        # Return max 
        return max(pick, skip)


### Complexity Analysis

# Time Complexity: O(N) --> N = max(nums). Since we iterate through the entire range uptil max element in array
# Space Complexity: O(N) --> N = max(nums). Array of freq of occurences