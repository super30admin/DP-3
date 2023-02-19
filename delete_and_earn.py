# Time Complexity :
#O(N) where is the number of elements in nums or maximum value in nums (whichever is larger)

# Space Complexity :
#O(K) where K is maximum value in nums

# Did this code successfully run on Leetcode :
#Yes

#We go through the initial array, and compute the total value associated with any number (frequency * number). 
#This will give us a sequence of values where we can only pick numbers which are not next to each other (we store even 0 frequency numbers)
#This then reduces to the house robber problem - so we need to find which combination of numbers finds the highest total value while not being able to pick consective numbers

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        max_val = max(nums)
        values = [0] * (max_val)

        for elem in nums:
            values[elem-1] += elem

        if max_val == 1 :
            return values[0]
        elif max_val == 2 :
            return max(values)

        prev1 = values[0]
        prev2 = max(values[1],values[0])

        for i in range(2,len(values)):
            temp = prev2
            prev2 = max(prev2, prev1+values[i])
            prev1 = temp
            
        return prev2
