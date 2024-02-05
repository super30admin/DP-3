
'''
Time Complexity - O(n). We are iterating the the nums array 3 times.
Space Complexity - O(1) if we use 2 variables to store the results. O(n) if we store the results in an array

This code works on Leetcode.
'''
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        maxNum = -1e9
        for num in nums: #find the max number in the array 
            maxNum = max(maxNum, num)
        cumArray = [0 for i in range(maxNum+1)]
        for num in nums: #create an array that stores the frequence of each number
            cumArray[num]+=num
        prev = cumArray[0] #store initial result (j-1)
        prev2 = 0 #stores result upto (j-2)
        for i in range(0,len(cumArray)): #similar to house robber
            pick = cumArray[i] #pick the element
            if i > 1:
                pick +=  prev2 # add to result of 2 indices before because if we select the current one the adjacent cannot be selected
            curr = max(pick, prev) #get the max of the of the prev and and current result
            prev2 = prev #set the current result as prev for next iteration
            prev = curr #the current prev will be the one i.e. two indices before in the next iteration hence move it to prev2
        return prev if prev > 0 else 0 #return the prev if it is greater than zero
        