#deleteand earn
#timecomplexity: O[m*n] where m is range of array and n is the points, the space complexity can be reduced if we use inbuilt count method
#leetcode solution accepted
#space complexity:
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:    #edge case check
            return 0
        fre = [0]*(max(nums)+1)
        #checkign the frequency of each number in the array
        for n in nums:
            fre[n]+=n
        dp=[0]*(len(fre))
        dp[1]=fre[1]

        for i in range(2,len(fre)):
            dp[i]= max(dp[i-2]+fre[i],dp[i-1])#reason to take i-2 is because we for i to exist i-1 cant be deleted and for i-1 to exist i cant be deleted
        return dp[len(fre)-1]