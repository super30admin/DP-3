#Time Complexity : O(N+M), N being the length of array and M being the max of a value in dp.
#Space Complexity : O(N+M), N being the length of array and M being the max of a value in dp.
#Did this code successfully run on Leetcode : Yes.
#Any problem you faced while coding this : Had a really hard time debugging the dynamic array 
#part. The issue was due to the fact I had mixed the recursion solution with the dp solution. 
#The second issue was due to not add the max of the two results for both pick and not_pick case. 

#Your code here along with comments explaining your approach in three sentences only
'''Used dynamic programming where the dp array is a 3*max_value, row for pick, row for not_pick, 
and final for each value. Final result is at the end. 
'''
class Solution:
    def helper(self, dictionary, index, max_length, points, dp):
        if index>=max_length or index<0:
            return 0
        else:
            if dp[1][index]==None:
                #pick and earn
                result1=dp[0][index-1]+dictionary[index]
                result2=dp[0][index-2]+dictionary[index]
                dp[1][index] = max(result1, result2)
            if dp[0][index]==None:
                #don't pick
                result1=dp[1][index-1]
                result2=dp[1][index-2]
                dp[0][index] = max(result1, result2)
            #max of two and call helper function again with incremented index.
            dp[2][index]=max(dp[0][index], dp[1][index])
            self.helper(dictionary, index+1, max_length, points, dp)


    def deleteAndEarn(self, nums: List[int]) -> int:
        #place values in a dictionary.
        dictionary = {}
        for n in nums:
            if n not in dictionary.keys():
                dictionary[n]=n
            else:
                dictionary[n]=dictionary[n]+n
        #create an array of length max_length +2
        max_length = max(dictionary.values())+2
        dictionary_array = []
        for i in range(max_length):
            if i in dictionary.keys():
                dictionary_array.append(dictionary[i])
            else:
                dictionary_array.append(0)
        #create dp array and initialize. 
        dp=[[None for i in range(max_length)] for j in range(3)]
        dp[0][0]=0
        dp[1][0]=0
        dp[2][0]=0
        dp[0][max_length-1]=0
        dp[1][max_length-1]=0
        dp[2][max_length-1]=0
        #call helper function. 
        result = self.helper(dictionary_array, 1, max_length, 0, dp)
        return dp[2][max_length-2]

