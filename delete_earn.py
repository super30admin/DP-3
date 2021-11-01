# // Time Complexity : O(nlgn) where n is the length of the array
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : no

# // Your code here along with comments explaining your approach 
class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        
        arr = []
        hashmap = Counter(nums)
        for k,v in hashmap.items():
            arr.append(k)
        arr.sort()
        dp = [0 for _ in range(len(arr)+2)]
            
        for i in range(2,len(dp)):
            if i > 2 and arr[i-2] - 1 == arr[i-3]:
                # consecutive
                dp[i] = max(dp[i-1],dp[i-2]+hashmap[arr[i-2]]*arr[i-2])
            else:
                dp[i] = dp[i-1]+hashmap[arr[i-2]]*arr[i-2]

        return dp[-1]