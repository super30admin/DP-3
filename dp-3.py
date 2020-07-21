# problem 1 : 740. Delete and Earn : https://leetcode.com/problems/delete-and-earn/
# Time Complexity :  O (n log n) - for sorting the keys
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def deleteAndEarn(self, nums: List[int]) -> int:
        if not nums:
            return 0
        res = Counter(nums)
        prev = None
        using = not_using = 0
        for i in sorted(res):
            if i-1 != prev:
                using, not_using = max(using, not_using) + (res[i] * i), max(using, not_using)
            else:
                using, not_using = not_using + (i *res[i]), max(using, not_using)
            prev = i
        return max(using, not_using)


# problem 1 : 931. Minimum Falling Path Sum : https://leetcode.com/problems/minimum-falling-path-sum/
# Time Complexity : O(N^2)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None

class Solution:
    def minFallingPathSum(self, A: List[List[int]]) -> int:
        if not A:
            return 0
        res = A[0]
        for i in range(1,len(A)):
            for j in range(len(A[0])):
                if j == 0:
                    A[i][j] += min(res[0], res[1])
                elif j == len(A[0]) - 1:
                    A[i][j] += min(res[-1], res[-2])
                else:
                    A[i][j] += min(res[j-1:j+2])
            res = A[i]
        return min(res)
 