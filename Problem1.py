'''
This is same as house robber problem with the added condition that if the previous number is same 
as current number-1 then do not choose it previous number.

Else choose the max between both the conditions.
Time Complexity: O(n)
Space Complexity: O(n)
'''

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        numSum = {}
        for num in nums:
            if num in numSum:
                numSum[num] += num
            else:
                numSum[num] = num

        sortedKeys = sorted(numSum.keys())
        choose, notChoose = numSum[sortedKeys[0]], 0
        prev = sortedKeys[0]
        for num in sortedKeys[1:]:
            if prev == num-1:
                chooseNum = numSum[num] + notChoose
            else:
                chooseNum = numSum[num] + max(choose, notChoose)
            notChooseNum = max(choose, notChoose)
            choose, notChoose = chooseNum, notChooseNum
            prev = num

        return max(choose, notChoose)