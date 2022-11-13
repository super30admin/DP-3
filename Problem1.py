#Time complexity: O(Max(n, maxVal in n))
#Space complexity: O(maxVal in n)

# Accepted on Leetcode

#Approach
#Create a dp array the size of (maxVal in n)
#Each index in this array contains value = total points of that particular 'index' in input array else 0
#Now iterate through dp array, each index = max(prevIndexVal, curVal + prevPrevIndexVal) since we can't take adjacent 'points' - last index in the dp array is the answer


class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        hashMap = {}
        maxVal = float('-inf')
        for x in nums:
            maxVal = max(maxVal, x)
            if x not in hashMap:
                hashMap[x] = x
            else:
                hashMap[x] += x
        
        dp = []
        for i in range(maxVal + 1):
            curVal = hashMap[i] if i in hashMap else 0 
            prevVal2 = 0 if i - 2 < 0 else dp[i-2] #i-2
            prevVal1 = 0 if i - 1 < 0 else dp[i-1] #i-1
            curVal = max(prevVal2 + curVal, prevVal1)
            dp.append(curVal)

        return dp[maxVal]

# TC 1 [1, 1, 2, 5, 6]
# HM = {1:2, 2:2, 5:5, 6:6}, MVal = 6
# i = 0 to 6 inclusive
# i = 0, curVal = 0, pv2, pv1 = 0, curVal = max(0 + 0, 0 ) = 0, dp [0]
# i = 1, curVal = 2, prevVal2 = 0, prevVal1 = 0, max(2, 0) = 2, dp [0,2]
# i = 2, curVal = 2, prevVal2 = 0, prevVal1 = 2, max(2, 2) = 2, dp [0,2,2]
# i = 3, curVal = 0, prevVal2 = 2, prevVal1 = 2, max(2, 2) = 2, dp [0,2,2,2]
# i = 4, curVal = 4, prevVal2 = 2, prevVal1 = 2, max(2, 2) = 2, dp [0,2,2,2,2]
# i = 5, curVal = 5, prevVal2 = 2, prevVal1 = 2, max(7, 2) = 7, dp [0,2,2,2,2,7]
# i = 6, curVal = 6, prevVal2 = 2, prevVal1 = 7, max(8, 7) = 8, dp [0,2,2,2,2,8]

#TC 2 [1,1,1,1,2,2,2,2]
#HM = {1:4, 2:8}, MVal = 2
# i = 0 to 2 inclusive
# i = 0, curVal = 0, pv2 = 0, pv1 = 0, curVal = max(0+0, 0) = 0, dp [0]
# i = 1, curVal = 4, pv2 = 0, pv1 = 0, curVal = (0+4, 0) = 4, dp[0, 4]
# i = 2, curVal = 8, pv2 = 0, pv1 = 8, curVal = (8, 4) = 8, dp[0, 4, 8]

        