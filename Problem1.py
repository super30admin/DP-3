#Delete and Earn

#time complexity -> On
# space complexity -> On
import math
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        # We'll have to convert the given array to house robber pattern
        # get the array of length 10^4 as that is the max number possible
        numsArr = [0] * 10001
        maxNum = 0
        minNum = math.inf

        for num in nums:
            maxNum = max(maxNum,num)
            minNum = min(minNum,num)
            numsArr[num] +=num
        
        #Now use houseroober method, i.e for each index try to maximise the sum
        numsArr[minNum+1] = max(numsArr[minNum], numsArr[minNum+1])
        for i in range(minNum+2,maxNum+1):
            numsArr[i] = max(numsArr[i-1],(numsArr[i]+numsArr[i-2]))
        return numsArr[maxNum]