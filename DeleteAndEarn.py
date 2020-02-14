class DeleteAndEarn(object):
    '''
    Solution:
    1. A recursion problem where overlapping subproblems exist and so use Dynamic Programming.
    2. Create an array containing (maximum value of array) number of elements and update each index with the total cost
        it can earn (number of times that number occurred and number value).
    3. The problem now becomes similar to House Robber problem and can be solved it in a similar manner.

    --- Passed all testcases on Leetcode successfully
    '''

    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # O(maxValue) Time Complexity | O(maxValue) Space Complexity
        if (nums == None or len(nums) == 0):
            return 0

        maxValue = 0
        for i in range(len(nums)):
            maxValue = max(maxValue, nums[i])

        dpArray = [0 for i in range(maxValue + 1)]

        for i in range(len(nums)):
            dpArray[nums[i]] += nums[i]

        prevMax = 0
        currMax = 0

        for i in range(len(dpArray)):
            tempMax = max(currMax, dpArray[i] + prevMax)
            prevMax = currMax
            currMax = tempMax

        return max(prevMax, currMax)