class Solution(object):
    def deleteAndEarn(self, a):
        """
        :type nums: List[int]
        :rtype: int
        
        TC: O(max(k,n)) k(max value in a)
        2   3   4   3   3   2
        [ 0 0 4 9 4 ]  // earning  //HOUSE ROBBER PROBLEM Extension 
          0 1 2 3 4 //index
        Approach:
        find the max value possible
        create dp aaray of length max element and store the earning possible with each digit at the index digit.
        now do the houserobber
        
        ////////////////////////////////////////////////////////
        House Robvber
        TC : O(K) one pass 
        SC : O(1)
        
        Apprach : 
        2 7 9 2 3
        2 7 9 8 3  // greedy want work 
        1st : we will try to explore one path/ one best path.   // if this not work 
        2nd : we will try to explore all the paths and choose the best among all paths.  // if this works // it will work as best soltion lies in the diffrent paths
          
        here for exploring all the paths, apply choose/ not choose technique
        store the sub problem result in dp 
        
            2   7   9   2   3
        0   0   2   7   11  11
        1   2   7   11  9   14  
          
          
        """
        n = max(a) + 1
        dp = [0] * n
        for i in range(len(a)):
            dp[a[i]] += a[i]
            
        take = dp[0]
        skip = 0
        
        for i in range(1,n):
            take , skip = dp[i] + skip, max(take,skip)
        return max(take, skip)
        