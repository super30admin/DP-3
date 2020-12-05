class Solution(object):
    def deleteAndEarn(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #base case
        if not nums:
            return 0
        skip=0
        take=0
        #dp array has max+1 items
        maxi=max(nums)+1
        #initializing dp arary of size(max+1) items
        dp=[0]*maxi

        #print(dp)
        #fill array with sums of values
        for i in nums:
            dp[i]+=i
        #print(dp)
        #traverse the array, everytime looking to either skip that insex or take that index and find max points
        for i in range(len(dp)):
            #need to keep hold on previous max value
            prevskip=skip
            #keep note of max points
            skip=max(skip,take)
            #find new max points if considering thhat index
            take=dp[i]+prevskip
        #finally returning maximum points   
        return (max(skip,take))

solved=Solution()
print(solved.deleteAndEarn([2,2,3,3,3,4]))

# O(max(maxno.,n)) where n is array size>>
# case1>> [2,2,2,2,2]
# size of array
# case2>>[1,2,100]
# max number 100 (dp array)

# O (maxelement) to construct dp array