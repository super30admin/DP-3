# Submitted by : Aryan Singh_RN12MAY2023
# Time Complexity : O(n)
# Space Complexity : Average : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    '''
    - Preprocess a dp array of size max(num)
    - with total sum of occurence of a number corresponding to the index it is stored in 
    - as repeating subproblem, so will find max in dp array (excluding neighbors if current selected)
    '''
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        maxnum = 0
        for num in nums:
            maxnum = max(maxnum, num)
        dpArray = [0 for _ in range(maxnum + 1)]
        
        for num in nums :
            dpArray[num] += num

        prevmax = dpArray[0]
        currmax = dpArray[1]
        for i in range(2, maxnum + 1):
            temp = currmax
            currmax = max(dpArray[i] + prevmax, temp)
            prevmax = temp
        return currmax